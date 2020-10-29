package com.example.webservices_cardealer.services;

import com.example.webservices_cardealer.entities.Car;
import com.example.webservices_cardealer.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.awt.print.Book;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAllCars(String registrationNumber,String brand,String model,String color,boolean sortOnBrand){
        var carList = carRepository.findAll();
        if (registrationNumber != null){
            carList = carList.stream().filter(car -> car.getRegistrationNumber().toLowerCase().equals(registrationNumber.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (brand != null){
            carList = carList.stream().filter(car -> car.getBrand().toLowerCase().equals(brand.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (model != null){
            carList = carList.stream().filter(car -> car.getModel().toLowerCase().equals(model.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (color != null){
            carList = carList.stream().filter(car -> car.getColor().toLowerCase().equals(color.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (sortOnBrand){
            carList.sort(Comparator.comparing(Car::getBrand));
        }
        return carList;
    }

    public Car saveNewCar(Car car){
        return carRepository.save(car);
    }


    @CacheEvict(value = "userCache",key="#id")
    public void updateCar(String id, Car car){
        if (!carRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Could not find car with id %s",id));
        }
        car.setCarId(id);
        carRepository.save(car);
    }

    public void deleteCar (String id){
        if (!carRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Could not find car with id %s",id));
        }
        carRepository.deleteById(id);
    }
}
