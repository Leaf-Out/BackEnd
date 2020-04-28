package leafout.backend.controller;

import leafout.backend.apimodel.*;
import leafout.backend.model.*;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;


import leafout.backend.service.ParkService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * This interface offers all Park API endpoints
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/parks")
public class ParkController{

    @Autowired
    private ParkService parkService;

    @Autowired
    private PlanController planController;

    @Autowired
    private ActivityController activityController;
    /**
     * This method returns all parks create
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllParks() {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapParksResponse(parkService.getAllParks()), HttpStatus.ACCEPTED);
        return response;
    }



    /**
     * This method returns a http response with the park of the id
     * @param parkName id of the conrresponsive park
     * @return http response
     */
    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getParkByName(@PathVariable("name") String parkName) {
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(mapParkResponse(parkService.getParkByName(parkName)), HttpStatus.ACCEPTED);
        } catch (ParkException e) {
            e.printStackTrace();
            response = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return response;

    }
    /**
     * This method create a new park
     * @param park the activity that would be create
     * @return http reponse
     */
    @PostMapping
    public ResponseEntity<?> addNewPark(@RequestBody ParkRequest park) {
        ResponseEntity response = null;
        try {
            parkService.savePark(mapPark(park));
            response = new ResponseEntity<>(HttpStatus.CREATED);
        } catch (ParkException ex) {
            ex.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.ALREADY_REPORTED);
        } catch (ActivityException e) {
            e.printStackTrace();
        } catch (PlanException e) {
            e.printStackTrace();
        }

        return response;
    }

    /**
     * This method get all the plans by a park
     * @param parkName the name of a park
     * @return list<Plan></>
     */
    @GetMapping(path = "/{name}/plans")
    public ResponseEntity<?> getPlansByPark(@PathVariable("name") String parkName) {
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(planController.mapPlansResponse(parkService.getParkByName(parkName).getPlanList()), HttpStatus.ACCEPTED);
        } catch (ParkException e) {
            e.printStackTrace();
            response = new ResponseEntity( HttpStatus.NOT_FOUND);
        }
        return response;

    }
    /**
     * This method get all the plans by a park
     * @param parkName the name of a park
     * @return list<Plan></>
     */
    @SneakyThrows
    @PostMapping(path = "/{name}/plans")
    public ResponseEntity<?> addPlansByPark(@RequestBody List<PlanRequest> allPlanRequest,@PathVariable("name") String parkName) {
        Park park = parkService.getParkByName(parkName);
        List<Plan> plans = park.getPlanList();
        for (PlanRequest planRequest: allPlanRequest){
            plans.add(planController.mapPlan(planRequest));
        }
        park.setPlanList(plans);
        try {
            parkService.updatePark(park);
        } catch (ParkException | ActivityException | PlanException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;

    }
    /**
     * This method get all the Activities by a park
     * @param parkName the id form a park
     * @return list<Activities></>
     */

    @GetMapping(path = "/{name}/activities")
    public ResponseEntity<?> getActivitiesByPark(@PathVariable("name") String parkName) {
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(activityController.mapActivitiesResponse(parkService.getParkByName(parkName).getActivitiesList()), HttpStatus.ACCEPTED);
        } catch (ParkException e) {
            response = new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return response;
    }
    /**
     * This method get all the plans by a park
     * @param parkName the name of a park
     * @return list<Plan></>
     */
    @SneakyThrows
    @PostMapping(path = "/{name}/activities")
    public ResponseEntity<?> addActivitiesByPark(@RequestBody List<ActivityRequest> allActivityRequest, @PathVariable("name") String parkName) {
        Park park = parkService.getParkByName(parkName);
        List<Activity> activities = park.getActivitiesList();
        for (ActivityRequest activityRequest: allActivityRequest){
            activities.add(activityController.mapActivity(activityRequest));
        }
        park.setActivitiesList(activities);
        try {
            parkService.updatePark(park);
        } catch (ParkException | ActivityException | PlanException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;

    }


    /**
     * This method get all the park by a list of tags
     * @return list<Park></>
     */

    @GetMapping(path = "/tags")
    public ResponseEntity<?> getParksByTags(@RequestBody List<Tag> tagList) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapParksResponse(parkService.getParksByTags(tagList)), HttpStatus.ACCEPTED);
        return response;
    }

    /**
     * This method get all the park by a list of tags
     * @return list<Park></>
     */

    @GetMapping(path = "/region/{region}")
    public ResponseEntity<?> getParksByRegion( @PathVariable("region") String regionName) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapParksResponse(parkService.getParksByRegion(regionName)), HttpStatus.ACCEPTED);
        return response;
    }


    /**
     * This method rating a park
     * @param parkName the name of a park
     *
     */
    @SneakyThrows
    @PostMapping(path = "/{name}/rating")
    public ResponseEntity<?> ratingPark(@RequestBody Double rating, @PathVariable("name") String parkName) {
        Park park = parkService.getParkByName(parkName);
        Feedback feedback = park.getFeedback();
        feedback.setRating((feedback.getRating()+rating)/2);
        park.setFeedback(feedback);
        System.err.println(park.getFeedback().getRating());
        try {
            parkService.updatePark(park);
        } catch (ParkException | ActivityException | PlanException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;

    }


    /**
     * This method transforms a Rest Park object into the business park object
     *
     * @param parkRequest Rest park object to be transformed
     * @return A Park object
     */
    private Park mapPark(final ParkRequest parkRequest) {

        Park park = Park.builder().id(UUID.randomUUID().toString())
                .activitiesList(activityController.mapActivitiesRequiest(parkRequest.getActivitiesList()))
                .description(parkRequest.getDescription())
                .feedback(parkRequest.getFeedback())
                .name(parkRequest.getName())
                .planList(planController.mapPlansRequest(parkRequest.getPlanList()))
                .prices(parkRequest.getPrices())
                .tags(parkRequest.getTags())
                .location(parkRequest.getLocation())
                .build();
        return park;
    }

    /**
     * This method get all the park by a list of tags
     * @return list<Park></>
     */

    @GetMapping(path = "/population/price")
    public ResponseEntity<?> getParksByPopulationAndPrice( @RequestBody Map<Population,Double> price) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapParksResponse(parkService.getParksByPopulationAndPrice(price)), HttpStatus.ACCEPTED);
        return response;
    }
    /**
     * This method transforms a Rest Park object into the business park object
     *
     * @param park Rest park object to be transformed
     * @return A Park object
     */
    private ParkResponse mapParkResponse(final Park park) {
        ParkResponse parkResponse = ParkResponse.builder().id(park.getId())
                .activitiesList(activityController.mapActivitiesResponse(park.getActivitiesList()))
                .description(park.getDescription())
                .feedback(park.getFeedback())
                .name(park.getName())
                .planList(planController.mapPlansResponse(park.getPlanList()))
                .prices(park.getPrices())
                .tags(park.getTags())
                .location(park.getLocation())
                .build();
        return parkResponse;
    }
    /**
     * This method transforms a lists of  Park object into the response  list park object
     *
     * @param allparks Rest park object to be transformed
     * @return A Park object
     */
    private List<ParkResponse> mapParksResponse(final List<Park> allparks) {
        List<ParkResponse> parks = new ArrayList<>();
        if(!(allparks == null)){
            for (Park park : allparks) {
                parks.add(
                        ParkResponse.builder().id(park.getId())
                                .activitiesList(activityController.mapActivitiesResponse(park.getActivitiesList()))
                                .description(park.getDescription())
                                .feedback(park.getFeedback())
                                .name(park.getName())
                                .planList(planController.mapPlansResponse(park.getPlanList()))
                                .prices(park.getPrices())
                                .tags(park.getTags())
                                .location(park.getLocation())
                                .build()
                );
            }
        }


        return parks;
    }
    /**
     * This method transforms a lists of  Park object into the response  list park object
     *
     * @param allparksRequest Rest park object to be transformed
     * @return A Park object
     */
    private List<Park> mapParksRequest(final List<ParkRequest> allparksRequest) {
        List<Park> parks = new ArrayList<>();
        if(!(allparksRequest == null)){
            for (ParkRequest parkRequest : allparksRequest) {
                parks.add(
                        Park.builder().id(UUID.randomUUID().toString())
                                .activitiesList(activityController.mapActivitiesRequiest(parkRequest.getActivitiesList()))
                                .description(parkRequest.getDescription())
                                .feedback(parkRequest.getFeedback())
                                .name(parkRequest.getName())
                                .planList(planController.mapPlansRequest(parkRequest.getPlanList()))
                                .prices(parkRequest.getPrices())
                                .tags(parkRequest.getTags())
                                .location(parkRequest.getLocation())
                                .build()
                );
            }
        }
        return parks;
    }

}