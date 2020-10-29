package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Car;
import com.example.webservices_cardealer.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
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

    @PostMapping
    public ResponseEntity<Car> saveNewCar (@Validated @RequestBody Car car){
        return ResponseEntity.ok(carService.saveNewCar(car));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCar(@PathVariable String id, @RequestBody Car car){
        carService.updateCar(id,car);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCar(@PathVariable String id){
        carService.deleteCar(id);
    }

}
