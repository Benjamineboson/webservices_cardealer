package com.example.webservices_cardealer.controllers;

import com.example.webservices_cardealer.entities.Engine;
import com.example.webservices_cardealer.services.EngineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/dealer/engines")
public class EngineController {

    @Autowired
    private EngineService engineService;

    @Secured({"ROLE_ADMIN","ROLE_EMPLOYEE"})
    @GetMapping
    public ResponseEntity<List<Engine>> findAllEngines (@RequestParam(required = false) String brand, @RequestParam(required = false) String model,
                                                        @RequestParam(required = false) String cylinders, @RequestParam(required = false) String fuelType,
                                                        @RequestParam(required = false) boolean sortOnBrand){
        return ResponseEntity.ok(engineService.findAllEngines(brand,model,cylinders,fuelType,sortOnBrand));
    }

    @Secured({"ROLE_ADMIN","ROLE_EMPLOYEE"})
    @GetMapping("/{id}")
    public ResponseEntity<Engine> findEngineById(@PathVariable String id) {
        return ResponseEntity.ok(engineService.findEngineById(id));
    }

    @Secured("ROLE_ADMIN")
    @PostMapping
    public ResponseEntity<Engine> saveNewEngine (@Validated @RequestBody Engine engine){
        return ResponseEntity.ok(engineService.saveNewEngine(engine));
    }

    @Secured("ROLE_ADMIN")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateEngine(@PathVariable String id, @RequestBody Engine engine){
        engineService.updateEngine(id,engine);
    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEngine(@PathVariable String id){
        engineService.deleteEngine(id);
    }
}
