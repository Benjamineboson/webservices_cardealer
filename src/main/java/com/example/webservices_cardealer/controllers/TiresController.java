package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Tires;
import com.example.webservices_cardealer.services.TiresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/v1/dealer/tires")
public class TiresController {

    @Autowired
    private TiresService tiresService;

    @Secured({"ROLE_ADMIN","ROLE_EMPLOYEE"})
    @GetMapping
    public ResponseEntity<List<Tires>> findAllTires (@RequestParam(required = false) String brand, @RequestParam(required = false) String dimension,
                                                    @RequestParam(required = false) String tireType, @RequestParam(required = false) String yearModel,
                                                    @RequestParam(required = false) boolean sortOnBrand){
        return ResponseEntity.ok(tiresService.findAllTires(brand,dimension,tireType,yearModel,sortOnBrand));
    }

    @Secured({"ROLE_ADMIN","ROLE_EMPLOYEE"})
    @GetMapping("/{id}")
    public ResponseEntity<Tires> findTiresById(@PathVariable String id) {
        return ResponseEntity.ok(tiresService.findTiresById(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Tires> saveNewTires (@Validated @RequestBody Tires tires){
        var savedTires = tiresService.saveNewTires(tires);
        var uri = URI.create("/api/v1/dealer/tires/" + savedTires.getTiresId());
        return ResponseEntity.created(uri).body(savedTires);
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateTires(@PathVariable String id, @RequestBody Tires tires){
        tiresService.updateTires(id,tires);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTires(@PathVariable String id){
        tiresService.deleteTires(id);
    }
}
