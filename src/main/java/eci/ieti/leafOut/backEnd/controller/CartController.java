<<<<<<< HEAD
package eci.ieti.leafout.backend.controller;
=======
package eci.ieti.leafOut.backEnd.controller;
>>>>>>> 87e0c6c5b8d4213c3c69d65f13864e917b4a8d37

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * CartController
 */
@RestController
@RequestMapping("/cart")
public class CartController {


    //Get requests
    
    @GetMapping("/user/{id}")
    public ResponseEntity<?> getAll(@PathVariable("user_id") UUID user) {
        //TODO
        return null;
    }
    @GetMapping("/user/{id}/plans")
    public ResponseEntity<?> getAllPlans(@PathVariable("user_id") Integer Plan) {
        //TODO
        return null;
    }
    @GetMapping("/user/{user_id}/plan/{plan_id}")
    public ResponseEntity<?> getPlanById(@PathVariable("user_id") UUID user, @PathVariable("plan_id") Integer plan) {
        //TODO
        return null;
    }

    //Post Requests

    @PostMapping("/user/{id}/plans")
    public void savePlan(@PathVariable("user_id") UUID user) {
        //TODO
    }
}