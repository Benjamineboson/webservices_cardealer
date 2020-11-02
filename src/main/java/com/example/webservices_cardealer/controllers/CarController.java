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
@RequestMapping("/api/v1/dealer")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping
    public ResponseEntity<List<Car>> findAllCarsGuest(){
        return ResponseEntity.ok(carService.findAllCarsGuest());
    }

    @Secured({"ROLE_ADMIN","ROLE_EMPLOYEE"})
    @GetMapping("/cars")
    public ResponseEntity<List<Car>> findAllCars (@RequestParam(required = false) String registrationNumber, @RequestParam(required = false) String brand,
                                                  @RequestParam(required = false) String model, @RequestParam(required = false) String color,
                                                  @RequestParam(required = false) String engineModel, @RequestParam(required = false) String tireBrand,
                                                  @RequestParam(required = false) boolean sortOnBrand){
        return ResponseEntity.ok(carService.findAllCars(registrationNumber,brand,model,color,sortOnBrand,engineModel,tireBrand));
    }

    @Secured({"ROLE_ADMIN","ROLE_EMPLOYEE"})
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> findCarById(@PathVariable String id) {
        return ResponseEntity.ok(carService.findCarById(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping("/cars")
    public ResponseEntity<Car> saveNewCar (@Validated @RequestBody Car car){
        return ResponseEntity.ok(carService.saveNewCar(car));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateCar(@PathVariable String id, @RequestBody Car car){
        carService.updateCar(id,car);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/cars/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCar(@PathVariable String id){
        carService.deleteCar(id);
    }

}
