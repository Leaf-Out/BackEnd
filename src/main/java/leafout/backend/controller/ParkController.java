package leafout.backend.controller;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;
import leafout.backend.service.ParkServices;
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
    private ParkServices parkServices;

    @GetMapping
    public ResponseEntity<?> getAllPlans() {
        try {
            List<Pay> parks = parkServices.getAllParks();
            return new ResponseEntity<>(parks, HttpStatus.ACCEPTED);
        } catch (LeafoutPersistenceException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping(path = "/{uuid}")
    public ResponseEntity<?> getPlanByName(@PathVariable("uuid") UUID parkUuid) {
        Pay park = null;
        try {
            park = parkServices.findParkById(parkUuid);
            return new ResponseEntity<>(park, HttpStatus.ACCEPTED);
        } catch (LeafoutPersistenceException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody Pay park) {
        try {
            parkServices.savePark(park);
            return new ResponseEntity<>(park, HttpStatus.CREATED);
        } catch (LeafoutPersistenceException ex) {
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(path = "/{park}/plans")
    public ResponseEntity<?> getPlansByPark(@PathVariable UUID park) {
        return null;
    }

    @GetMapping(path = "/{park}/ticket")
    public ResponseEntity<?> getTicketPark(@PathVariable UUID park) {
        return null;
    }
}