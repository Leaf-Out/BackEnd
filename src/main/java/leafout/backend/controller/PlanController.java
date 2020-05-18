package leafout.backend.controller;

import leafout.backend.apimodel.*;
import leafout.backend.model.*;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.service.PlanService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This interface offers all plan API endpoints
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

@RestController
@RequestMapping(value = "/plans")
public class PlanController {
    @Autowired
    private PlanService planServices;

    @Autowired
    private ActivityController activityController;

    /**
     * This method returns all Plans create
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllPlans(){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapPlansResponse(planServices.getAllPlans()), HttpStatus.ACCEPTED);
        return response;

    }
    /**
     * This method returns all Plans Popular
     * @return
     */
    @GetMapping(path = "/popular")
    public ResponseEntity<?> getAllPopularPlans(){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapPlansResponse(planServices.getAllPopulatePlans()), HttpStatus.ACCEPTED);
        return response;

    }

    /**
     * This method returns a http response with the plan of the id
     * @param planName id of the conrresponsive plan
     * @return http response
     */
    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getPlanById(@PathVariable("name") String planName){
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(mapPlanResponse(planServices.getPlanByName(planName)), HttpStatus.ACCEPTED);
        } catch (ParkException e) {
            e.printStackTrace();
            response = new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * This method create a new plan
     * @param plan the plan that would be create
     * @return http reponse
     */

    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody PlanRequest plan){
        ResponseEntity response;
        try{
            planServices.savePlan(mapPlan(plan));
            response = new ResponseEntity<>(HttpStatus.CREATED);
        }catch (PlanException | ActivityException | ParkException ex){
            ex.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }
    /**
     * This method get all the Activities by a plan
     * @param planName the name of a plan
     * @return list<Activities></>
     */
    @GetMapping(path = "/{name}/activities")
    public ResponseEntity<?> getActivitiesByPlan(@PathVariable("name") String planName) {
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(activityController.mapActivitiesResponse(planServices.getPlanByName(planName).getActivitiesList()), HttpStatus.ACCEPTED);
        } catch (ParkException e) {
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }
    /**
     * This method get all the park by a list of tags
     * @return list<Park></>
     */

    @GetMapping(path = "/tags")
    public ResponseEntity<?> getParksByTags(@RequestBody List<Tag> tagList) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapPlansResponse(planServices.getPlansByTags(tagList)), HttpStatus.ACCEPTED);
        return response;
    }

    /**
     * This method get all the plans by a park
     * @param planName the name of a park
     * @return list<Plan></>
     */

    @PostMapping(path = "/{name}/activities")
    public ResponseEntity<?> addActivitiesByPark(@RequestBody List<ActivityRequest> allActivityRequest, @PathVariable("name") String planName) {
        Plan plan = null;
        try {
            plan = planServices.getPlanByName(planName);
        } catch (ParkException e) {
            e.printStackTrace();
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        List<Activity> activities = plan.getActivitiesList();
        for (ActivityRequest activityRequest : allActivityRequest) {
            activities.add(activityController.mapActivity(activityRequest));
        }
        plan.setActivitiesList(activities);
        try {
            planServices.updatePlan(plan);
        } catch (ActivityException | PlanException | ParkException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;
    }


    /**
     * This method rating a plan
     * @param planName the name of a plan
     *
     */

    @PostMapping(path = "/{name}/rating")
    public ResponseEntity<?> ratingPark(@RequestBody Double rating, @PathVariable("name") String planName) {
        Plan plan = null;
        try {
            plan = planServices.getPlanByName(planName);
        } catch (ParkException e) {
            e.printStackTrace();
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Feedback feedback = plan.getFeedback();
        feedback.setRating((feedback.getRating()+rating)/2);
        plan.setFeedback(feedback);
        System.err.println(plan.getFeedback().getRating());
        try {
            planServices.updatePlan(plan);
        } catch (ActivityException | PlanException | ParkException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;

    }
    @PutMapping(path = "/{name}")
    public ResponseEntity<?> updatePlan(@PathVariable("name") String planName, @RequestBody PlanRequest planRequest) {
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(mapPlanResponse(planServices.updatePlan(mapPlanAlredy(planName,planRequest))),HttpStatus.OK);
        } catch (ActivityException e) {
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (PlanException e) {
            e.printStackTrace();

            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (ParkException e) {
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return response;
    }

    @DeleteMapping
    public ResponseEntity<?> removePark( @RequestBody PlanRequest planRequest) {
        ResponseEntity response;
        try {
            planServices.remove(mapPlanAlredy(planRequest.getName(),planRequest));
            response = new ResponseEntity<>(HttpStatus.OK);
        } catch (PlanException | ParkException e) {
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }

    /**
     * This method transforms a Rest plan object into the business plan object
     *
     * @param planRequest Rest park object to be transformed
     * @return A plan object
     */
    public Plan mapPlan(final PlanRequest planRequest) {
        Plan plan = Plan.builder().id(UUID.randomUUID().toString())
                .activitiesList(activityController.mapActivitiesRequiest(planRequest.getActivitiesList()))
                .description(planRequest.getDescription())
                .feedback(planRequest.getFeedback())
                .name(planRequest.getName())
                .prices(planRequest.getPrices())
                .activityDescription(planRequest.getActivityDescription())
                .tags(planRequest.getTags())
                .parkName(planRequest.getParkName())
                .build();
        return plan;
    }
    /**
     * This method transforms a Rest plan object into the business plan object
     *
     * @param planRequest Rest park object to be transformed
     * @return A plan object
     */
    public Plan mapPlanAlredy(String planName,final PlanRequest planRequest) throws ParkException {
        Plan planAlredy = planServices.getPlanByName(planName);
        Plan plan = Plan.builder().id(planAlredy.getId())
                .activitiesList(planAlredy.getActivitiesList())
                .description(planRequest.getDescription() == null ? planAlredy.getDescription() : planRequest.getDescription())
                .feedback(planAlredy.getFeedback())
                .name(planRequest.getName() == null ? planAlredy.getName() : planRequest.getName())
                .prices(planRequest.getPrices() == null ? planAlredy.getPrices() : planRequest.getPrices())
                .activityDescription(planRequest.getActivityDescription() == null ? planAlredy.getActivityDescription() : planRequest.getActivityDescription())
                .tags(planRequest.getTags() == null ? planAlredy.getTags() : planRequest.getTags())
                .parkName(planRequest.getParkName() == null ? planAlredy.getParkName() : planRequest.getParkName())
                .build();
        return plan;
    }
    /**
     * This method transforms a Rest plan object into the business plan object
     *
     * @param plan Rest park object to be transformed
     * @return A plan object
     */
    public PlanResponse mapPlanResponse(final Plan plan) {
        PlanResponse planResponse = PlanResponse.builder().id(plan.getId())
                .activitiesList(activityController.mapActivitiesResponse(plan.getActivitiesList()))
                .description(plan.getDescription())
                .feedback(plan.getFeedback())
                .name(plan.getName())
                .prices(plan.getPrices())
                .tags(plan.getTags())
                .activityDescription(plan.getActivityDescription())
                .parkName(plan.getParkName())
                .type(PayRequest.PLAN)
                .build();
        return planResponse;
    }

    /**
     * This method transforms a lists of  Plan object into the response  list Plan object
     *
     * @param allplansRequest Rest park object to be transformed
     * @return A List<Plan> object
     */
    public List<Plan> mapPlansRequest(final List<PlanRequest> allplansRequest) {
        List<Plan> plans = new ArrayList<>();
        if(!(allplansRequest == null)) {
            for (PlanRequest planRequest : allplansRequest) {
                plans.add(
                        Plan.builder().id(UUID.randomUUID().toString())
                                .activitiesList(activityController.mapActivitiesRequiest(planRequest.getActivitiesList()))
                                .description(planRequest.getDescription())
                                .feedback(planRequest.getFeedback())
                                .name(planRequest.getName())
                                .prices(planRequest.getPrices())
                                .activityDescription(planRequest.getActivityDescription())
                                .tags(planRequest.getTags())
                                .parkName(planRequest.getParkName())
                                .build()

                );
            }
        }
        return plans;
    }

    /**
     * This method transforms a lists of  Plan object into the response  list Plan object
     *
     * @param allplans Rest park object to be transformed
     * @return A List<Plan> object
     */
    public List<PlanResponse> mapPlansResponse(final List<Plan> allplans) {
        List<PlanResponse> plans = new ArrayList<>();
        if(!(allplans == null)){
            for (Plan plan : allplans) {
                plans.add(
                        PlanResponse.builder().id(plan.getId())
                                .activitiesList(activityController.mapActivitiesResponse(plan.getActivitiesList()))
                                .description(plan.getDescription())
                                .feedback(plan.getFeedback())
                                .name(plan.getName())
                                .prices(plan.getPrices())
                                .tags(plan.getTags())
                                .activityDescription(plan.getActivityDescription())
                                .parkName(plan.getParkName())
                                .type(PayRequest.PLAN)
                                .build()
                );
            }
        }

        return plans;
    }


}