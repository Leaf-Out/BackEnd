package eci.ieti.leafout.backEnd.controller;


import eci.ieti.leafout.backEnd.model.Park;
import eci.ieti.leafout.backEnd.model.exception.LeafOutPersistenceException;
import eci.ieti.leafout.backEnd.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This interface offers all Park API endpoints
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
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
    public ResponseEntity<?> getPlanByName(@PathVariable("name") UUID parkName){
        Park park = null;
        try{
            park = parkServices.findParkByName(parkName);
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

    @GetMapping(path = "/{park}/plans")
    public ResponseEntity<?> getPlansByPark(@PathVariable UUID park){return null;}

    @GetMapping(path = "/{park}/ticket")
    public ResponseEntity<?> getTicketPark(@PathVariable UUID park){return null;}



}
