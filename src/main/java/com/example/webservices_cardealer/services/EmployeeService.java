package com.example.webservices_cardealer.services;

import com.example.webservices_cardealer.entities.Employee;
import com.example.webservices_cardealer.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;
    private final EmployeeDetailsService employeeDetailsService;

    @Cacheable(value = "carCache")
    public List<Employee> findAllEmployees(String name, String lastname, String email, String username,
                                           boolean birthdate){
        var employees = employeeRepository.findAll();
        if (name != null){
            employees = employees.stream()
                    .filter(employee -> employee.getFirstname().toLowerCase().equals(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (lastname != null) {
            employees = employees.stream()
                    .filter(employee -> employee.getLastname().toLowerCase().equals(lastname.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (email != null) {
            employees = employees.stream()
                    .filter(employee -> employee.getEmail().toLowerCase().equals(email.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (username != null) {
            employees = employees.stream()
                    .filter(employee -> employee.getUsername().toLowerCase().equals(username.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (birthdate) {
            employees.sort(Comparator.comparing(Employee::getBirthdate));
        }
            return employees;
    }

    @Cacheable(value = "carCache", key = "#id")
    public Employee findById(String id) {
        return employeeRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Employee with this id %s. , could not be found", id)));
    }

   @Cacheable(value = "carCache", key = "#username")
   public Employee findByUsername(String username) {
        return employeeRepository.findByUsername(username).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
               String.format("Employee with this username %s. , could not be found", username)));
   }

   @CachePut(value = "carCache", key = "#result.employeeId")
   public Employee saveEmployee(Employee employee) {
       employee.setPassword(passwordEncoder.encode(employee.getPassword()));
       return employeeRepository.save(employee);
   }

   @CachePut(value = "carCache", key = "#id")
   public void updateEmployee(String id, Employee employee) {
        var isAdmin = SecurityContextHolder.getContext().getAuthentication().getAuthorities().stream()
                .anyMatch(grantedAuthority -> grantedAuthority.getAuthority().toUpperCase().equals("ROLE_ADMIN"));
        var isCurrentUser = employeeDetailsService.getCurrentUser();

       if (!isAdmin && !isCurrentUser.toLowerCase().equals(employee.getUsername().toLowerCase())) {
           throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "You can only update your own details.");
       }
       if(!employeeRepository.existsById(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                   String.format("Employee with this id %s. , could not be found", id));
       }
       // Prevent encoding on encoded password.....
       if (employee.getPassword().length() <= 16) {
           employee.setPassword(passwordEncoder.encode(employee.getPassword()));
       }
       employee.setEmployeeId(id);
       employeeRepository.save(employee);
   }

   @CacheEvict(value = "carCache", key = "#id")
   public void deleteEmployee(String id) {
       if(!employeeRepository.existsById(id)){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                   String.format("Employee with this id %s. , could not be found", id));
       }
       employeeRepository.deleteById(id);
   }
}
