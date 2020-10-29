package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Employee;
import com.example.webservices_cardealer.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("api/v1/dealer/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    //@Secured("ROLE_ADMIN")
    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees(@RequestParam(required = false) String name,
                                                           @RequestParam(required = false) String lastname,
                                                           @RequestParam(required = false) String email,
                                                           @RequestParam(required = false) String phone,
                                                           @RequestParam(required = false) boolean sort) {
        return ResponseEntity.ok(employeeService.findAllEmployees(name, lastname, email, phone, sort));
    }

    //@Secured("ROLE_ADMIN")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> findEmployeeById(@PathVariable String id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    //@Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Employee> saveEmployee(@Validated @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    //@Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEmployee(@PathVariable String id, @RequestBody Employee employee) {
        employeeService.updateEmployee(id, employee);
    }

    //@Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEmployee(@PathVariable String id) {
        employeeService.deleteEmployee(id);
    }
}
