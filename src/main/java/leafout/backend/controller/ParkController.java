package leafout.backend.controller;

import leafout.backend.apimodel.ActivityResponse;
import leafout.backend.apimodel.ParkRequest;
import leafout.backend.apimodel.ParkResponse;
import leafout.backend.apimodel.PlanResponse;
import leafout.backend.model.Activity;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Park;
import leafout.backend.model.Plan;
import leafout.backend.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This interface offers all Park API endpoints
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@RestController
@RequestMapping(value = "/parks")
public class ParkController {

    @Autowired
    private ParkService parkService;

    /**
     * This method returns all parks create
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllPlans() {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapParks(parkService.getAllParks()), HttpStatus.ACCEPTED);
        return response;
    }

    /**
     * This method returns a http response with the park of the id
     *
     * @param parkName id of the conrresponsive park
     * @return http response
     */
    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getPlanByName(@PathVariable("name") String parkName) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapParkResponse(parkService.getParkByName(parkName)), HttpStatus.ACCEPTED);
        return response;

    }

    /**
     * This method create a new park
     *
     * @param park the activity that would be create
     * @return http reponse
     */
    @PostMapping
    public ResponseEntity<?> addNewPark(@RequestBody ParkRequest park) {

        try {
            parkService.savePark(mapPark(park));
        } catch (ParkException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;
    }

    /**
     * This method get all the plans by a park
     *
     * @param parkName the name of a park
     * @return list<Plan></>
     */
    @GetMapping(path = "/{name}/plans")
    public ResponseEntity<?> getPlansByPark(@PathVariable("name") String parkName) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapPlansResponse(parkService.getParkByName(parkName).getPlanList()), HttpStatus.ACCEPTED);
        return response;

    }

    /**
     * This method get all the Activities by a park
     *
     * @param parkName the id form a park
     * @return list<Activities></>
     */

    @GetMapping(path = "/{name}/activities")
    public ResponseEntity<?> getActivitiesByPark(@PathVariable("name") String parkName) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivitiesResponse(parkService.getParkByName(parkName).getActivitiesList()), HttpStatus.ACCEPTED);
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
                .activitiesList(parkRequest.getActivitiesList())
                .description(parkRequest.getDescription())
                .feedback(parkRequest.getFeedback())
                .name(parkRequest.getName())
                .planList(parkRequest.getPlanList())
                .prices(parkRequest.getPrices())
                .tags(parkRequest.getTags())
                .planList(parkRequest.getPlanList())
                .build();
        return park;
    }

    /**
     * This method transforms a Rest Park object into the business park object
     *
     * @param parkRequest Rest park object to be transformed
     * @return A Park object
     */
    private ParkResponse mapParkResponse(final Park parkRequest) {
        ParkResponse park = ParkResponse.builder().id(parkRequest.getId())
                .activitiesList(parkRequest.getActivitiesList())
                .description(parkRequest.getDescription())
                .feedback(parkRequest.getFeedback())
                .name(parkRequest.getName())
                .planList(parkRequest.getPlanList())
                .prices(parkRequest.getPrices())
                .tags(parkRequest.getTags())
                .build();
        return park;
    }

    /**
     * This method transforms a lists of  Park object into the response  list park object
     *
     * @param allparks Rest park object to be transformed
     * @return A Park object
     */
    private List<ParkResponse> mapParks(final List<Park> allparks) {
        List<ParkResponse> parks = new ArrayList<>();
        for (Park park : allparks) {
            parks.add(
                    ParkResponse.builder().id(park.getId())
                            .activitiesList(park.getActivitiesList())
                            .description(park.getDescription())
                            .feedback(park.getFeedback())
                            .name(park.getName())
                            .planList(park.getPlanList())
                            .prices(park.getPrices())
                            .tags(park.getTags())
                            .build()
            );
        }

        return parks;
    }

    /**
     * This method transforms a lists of  Plan object into the response  list Plan object
     *
     * @param allplans Rest park object to be transformed
     * @return A List<Plan> object
     */
    private List<PlanResponse> mapPlansResponse(final List<Plan> allplans) {
        final List<PlanResponse> plans = new ArrayList<>();
        for (Plan plan : allplans) {
            plans.add(
                    PlanResponse.builder().id(plan.getId())
                            .activitiesList(plan.getActivitiesList())
                            .description(plan.getDescription())
                            .feedback(plan.getFeedback())
                            .name(plan.getName())
                            .prices(plan.getPrices())
                            .tags(plan.getTags())
                            .build()
            );
        }

        return plans;
    }

    /**
     * This method transforms a lists of  activities object into the response  list activities object
     *
     * @param allActivities Rest park object to be transformed
     * @return A List<Activities>  object
     */
    private List<ActivityResponse> mapActivitiesResponse(final List<Activity> allActivities) {
        final List<ActivityResponse> Activities = new ArrayList<>();
        for (Activity activity : allActivities) {
            Activities.add(
                    ActivityResponse.builder().id(activity.getId())
                            .description(activity.getDescription())
                            .feedback(activity.getFeedback())
                            .name(activity.getName())
                            .prices(activity.getPrices())
                            .tags(activity.getTags())
                            .build()
            );
        }

        return Activities;
    }


}