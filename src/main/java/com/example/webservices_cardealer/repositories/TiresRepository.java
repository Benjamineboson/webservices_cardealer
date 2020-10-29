package com.example.webservices_cardealer.repositories;

import com.example.webservices_cardealer.entities.Tires;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TiresRepository extends MongoRepository<Tires,String>{
}
