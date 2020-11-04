package com.example.webservices_cardealer.services;

import com.example.webservices_cardealer.entities.Engine;
import com.example.webservices_cardealer.repositories.EngineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EngineService {

    @Autowired
    private EngineRepository engineRepository;

    @Cacheable(value = "carCache")
    public List<Engine> findAllEngines(String brand,String model,String cylinders,String fuelType, boolean sortOnBrand){
        System.out.println("Fresh Engines data..."); // use only under development...
        var engineList = engineRepository.findAll();

        if (brand != null){
            engineList = engineList.stream().filter(engine -> engine.getBrand().toLowerCase().equals(brand.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (model != null){
            engineList = engineList.stream().filter(engine -> engine.getModel().toLowerCase().equals(model.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (cylinders != null){
            engineList = engineList.stream().filter(engine -> engine.getCylinders().toLowerCase().equals(cylinders.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (fuelType != null){
            engineList = engineList.stream().filter(engine -> engine.getFuelType().toLowerCase().equals(fuelType.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (sortOnBrand){
            engineList.sort(Comparator.comparing(Engine::getBrand));
        }
        if (engineList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No engines found in the system");
        }else {
            return engineList;
        }
    }

    @Cacheable(value = "carCache", key = "#id")
    public Engine findEngineById(String id){
        return engineRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Engine with this id %s. , could not be found", id)));
    }

    @CachePut(value = "carCache")
    public Engine saveNewEngine(Engine engine){
        return engineRepository.save(engine);
    }

    @CachePut(value = "carCache", key = "#id")
    public void updateEngine(String id, Engine engine){
        if (!engineRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Could not find engine with id %s",id));
        }
        engine.setEngineId(id);
        engineRepository.save(engine);
    }

    @CacheEvict(value = "carCache",key="#id")
    public void deleteEngine (String id){
        if (!engineRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Could not find engine with id %s",id));
        }
        engineRepository.deleteById(id);
    }
}
