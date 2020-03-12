package eci.ieti.leafout.backend.controller;

import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.model.exception.LeafOutPersistenceException;
import eci.ieti.leafout.backend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/Plans")
public class PlanController {

    @Autowired
    private PlanService planServices;

    @GetMapping
    public ResponseEntity<?> getAllPlans() {
        try {
            List<Plan> Plans = planServices.getAll();
            return new ResponseEntity<>(Plans, HttpStatus.ACCEPTED);
        } catch (LeafOutPersistenceException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPlanById(@PathVariable("id") int id) {
        Optional<Plan> plan = null;
        try{
            plan = planServices.getById(id);
            return new ResponseEntity<>(plan,HttpStatus.ACCEPTED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody Plan plan){
        try{
            planServices.save(plan);
            return new ResponseEntity<>(plan,HttpStatus.CREATED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
