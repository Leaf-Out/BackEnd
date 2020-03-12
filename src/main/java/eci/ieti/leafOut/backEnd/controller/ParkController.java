package eci.ieti.leafout.backend.controller;


import eci.ieti.leafout.backend.model.Park;
import eci.ieti.leafout.backend.model.exception.LeafOutPersistenceException;
import eci.ieti.leafout.backend.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Parks")
public class ParkController {

    @Autowired
    private ParkService parkServices;

    @GetMapping
    public ResponseEntity<?> getAllPlans() {
        List<Park> parks = parkServices.getAll();
        return new ResponseEntity<>(parks, HttpStatus.ACCEPTED);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPlanByName(@PathVariable("id") int id) {
        Optional<Park> park = null;
        try{
            park = parkServices.getById(id);
            return new ResponseEntity<>(park,HttpStatus.ACCEPTED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody Park park){
        try{
            parkServices.save(park);
            return new ResponseEntity<>(park,HttpStatus.CREATED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
