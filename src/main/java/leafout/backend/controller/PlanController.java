package leafout.backend.controller;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;
import leafout.backend.service.PlanServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * This interface offers all plan API endpoints
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

@RestController
@RequestMapping(value = "/Plans")
public class PlanController {
    @Autowired
    private PlanServices planServices;


    @GetMapping
    public ResponseEntity<?> getAllPlans(){
        try{
            List<Pay> Plans = planServices.getAllPlans();
            return new ResponseEntity<>(Plans, HttpStatus.ACCEPTED);
        }catch (LeafoutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{uuid}")
    public ResponseEntity<?> getPlanById(@PathVariable("uuid") UUID uuid){
        Pay plan = null;
        try{
            plan = planServices.findPlanById(uuid);
            return new ResponseEntity<>(plan,HttpStatus.ACCEPTED);
        }catch (LeafoutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.NOT_FOUND);
        }
    }



    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody Pay plan){
        try{
            planServices.savePlan(plan);
            return new ResponseEntity<>(plan,HttpStatus.CREATED);
        }catch (LeafoutPersistenceException ex){
            return new ResponseEntity<>(ex.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{plan}/ticket")
    public ResponseEntity<?> getPlanTicket(@PathVariable UUID plan){return null;}



}