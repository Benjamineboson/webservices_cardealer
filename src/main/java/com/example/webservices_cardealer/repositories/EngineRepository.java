package com.example.webservices_cardealer.repositories;

import com.example.webservices_cardealer.entities.Engine;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface EngineRepository extends MongoRepository<Engine,String>{
}
