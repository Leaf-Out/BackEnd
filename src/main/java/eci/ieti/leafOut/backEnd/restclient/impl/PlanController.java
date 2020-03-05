package eci.ieti.leafOut.backEnd.restclient.impl;



import eci.ieti.leafOut.backEnd.model.Plan;
import eci.ieti.leafOut.backEnd.persistence.LeafOutPersistenceException;
import eci.ieti.leafOut.backEnd.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Plans")
public class PlanController {
    @Autowired
    private PlanService planServices;


    @GetMapping
    public ResponseEntity<?> getAllPlans(){
        try{
            List<Plan> Plans = planServices.getAllPlans();
            return new ResponseEntity<>(Plans, HttpStatus.ACCEPTED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getPlanByName(@PathVariable("name") String name){
        Plan plan = null;
        try{
            plan = planServices.findPlanByName(name);
            return new ResponseEntity<>(plan,HttpStatus.ACCEPTED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody Plan plan){
        try{
            planServices.savePlan(plan);
            return new ResponseEntity<>(plan,HttpStatus.CREATED);
        }catch (LeafOutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }


}
