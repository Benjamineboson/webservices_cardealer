package com.example.webservices_cardealer.repositories;

import com.example.webservices_cardealer.entities.Car;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CarRepository extends MongoRepository<Car,String> {
}
