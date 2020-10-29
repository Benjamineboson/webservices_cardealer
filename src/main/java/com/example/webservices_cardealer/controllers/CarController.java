package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Car;
import com.example.webservices_cardealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/dealer/cars")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> findAllCars (@RequestParam(required = false) String registrationNumber, @RequestParam(required = false) String brand,
                                                  @RequestParam(required = false) String model, @RequestParam(required = false) String color,
                                                  @RequestParam(required = false) boolean sortOnBrand){
        return ResponseEntity.ok(carService.findAllCars(registrationNumber,brand,model,color,sortOnBrand));
    }
}
