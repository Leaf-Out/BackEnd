package eci.ieti.leafOut.backEnd.restclient.impl;


import eci.ieti.leafOut.backEnd.model.Park;
import eci.ieti.leafOut.backEnd.persistence.LeafOutPersistenceException;
import eci.ieti.leafOut.backEnd.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Parks")
public class ParkController {

    @Autowired
    private ParkService parkServices;

    @GetMapping
    public ResponseEntity<?> getAllPlans(){
        try{
            List<Park> parks = parkServices.getAllParks();
            return new ResponseEntity<>(parks, HttpStatus.ACCEPTED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getPlanByName(@PathVariable("name") String name){
        Park park = null;
        try{
            park = parkServices.findParkByName(name);
            return new ResponseEntity<>(park,HttpStatus.ACCEPTED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody Park park){
        try{
            parkServices.savePark(park);
            return new ResponseEntity<>(park,HttpStatus.CREATED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
