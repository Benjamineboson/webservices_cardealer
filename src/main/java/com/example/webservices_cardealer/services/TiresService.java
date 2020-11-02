package com.example.webservices_cardealer.services;

import com.example.webservices_cardealer.entities.Tires;
import com.example.webservices_cardealer.repositories.TiresRepository;
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
public class TiresService {

    @Autowired
    private TiresRepository tiresRepository;

    @Cacheable(value = "carCache")
    public List<Tires> findAllTires(String brand, String dimension, String tireType, String yearModel, boolean sortOnBrand) {
        System.out.println("Fresh Tires data..."); // use only under development...
        var tiresList = tiresRepository.findAll();
        if (brand != null){
            tiresList = tiresList.stream().filter(tires -> tires.getBrand().toLowerCase().equals(brand.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (dimension != null){
            tiresList = tiresList.stream().filter(tires -> tires.getDimension().toLowerCase().equals(dimension.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (tireType != null){
            tiresList = tiresList.stream().filter(tires -> tires.getTireType().toLowerCase().equals(tireType.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (tireType != null){
            tiresList = tiresList.stream().filter(tires -> tires.getYearModel().toLowerCase().equals(yearModel.toLowerCase()))
                    .collect(Collectors.toList());
        }
        if (sortOnBrand){
            tiresList.sort(Comparator.comparing(Tires::getBrand));
        }
        if (tiresList.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT, "No tires found in the system");
        }else {
            return tiresList;
        }
    }

    @Cacheable(value = "carCache", key = "#id")
    public Tires findTiresById(String id) {
        return tiresRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("Tires with this id %s. , could not be found", id)));
    }

    @CachePut(value = "carCache", key = "#result.tiresId")
    public Tires saveNewTires(Tires tires) {
        return tiresRepository.save(tires);
    }

    @CachePut(value = "carCache", key = "#id")
    public void updateTires(String id, Tires tires) {
        if (!tiresRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Could not find tires with id %s",id));
        }
        tires.setTiresId(id);
        tiresRepository.save(tires);
    }

    @CacheEvict(value = "carCache",key="#id")
    public void deleteTires(String id) {
        if (!tiresRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    String.format("Could not find tires with id %s",id));
        }
        tiresRepository.deleteById(id);
    }
}
