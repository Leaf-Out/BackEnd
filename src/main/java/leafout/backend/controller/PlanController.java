package leafout.backend.controller;

import leafout.backend.apimodel.ActivityRequest;
import leafout.backend.apimodel.PlanRequest;
import leafout.backend.model.Activity;
import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Plan;
import leafout.backend.service.PlanService;
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
     * This method returns a http response with the plan of the id
     * @param planId id of the conrresponsive plan
     * @return http response
     */
    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getPlanById(@PathVariable("id") UUID planId){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapPlanResponse(planServices.getPlanById(planId)), HttpStatus.ACCEPTED);
        return response;
    }

    /**
     * This method create a new plan
     * @param plan the plan that would be create
     * @return http reponse
     */

    @PostMapping
    public ResponseEntity<?> addNewPlan(@RequestBody PlanRequest plan){
        try{
            planServices.savePlan(mapPlan(plan));
        }catch (LeafoutPersistenceException ex){
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;
    }
    /**
     * This method get all the Activities by a plan
     * @param planId the id form a plan
     * @return list<Activities></>
     */
    @GetMapping(path = "/{id}/activities")
    public ResponseEntity<?> getActivitiesByPlan(@PathVariable("id") UUID planId) {
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivitiesResponse(planServices.getPlanById(planId).getActivitiesList()), HttpStatus.ACCEPTED);
        return response;
    }

    /**
     * This method transforms a Rest plan object into the business plan object
     *
     * @param planRequest Rest park object to be transformed
     * @return A plan object
     */
    private Plan mapPlan(final PlanRequest planRequest) {
        Plan plan = Plan.builder().id(UUID.randomUUID())
                .activitiesList(planRequest.getActivitiesList())
                .description(planRequest.getDescription())
                .feedback(planRequest.getFeedback())
                .name(planRequest.getName())
                .prices(planRequest.getPrices())
                .tags(planRequest.getTags())
                .build();
        return plan;
    }
    /**
     * This method transforms a Rest plan object into the business plan object
     *
     * @param plan Rest park object to be transformed
     * @return A plan object
     */
    private PlanRequest mapPlanResponse(final Plan plan) {
        PlanRequest planRe = PlanRequest.builder()
                .activitiesList(plan.getActivitiesList())
                .description(plan.getDescription())
                .feedback(plan.getFeedback())
                .name(plan.getName())
                .prices(plan.getPrices())
                .tags(plan.getTags())
                .build();
        return planRe;
    }

    /**
     * This method transforms a lists of  Plan object into the response  list Plan object
     *
     * @param allplans Rest park object to be transformed
     * @return A List<Plan> object
     */
    private List<PlanRequest> mapPlansResponse(final List<Plan> allplans) {
        List<PlanRequest> plans = new ArrayList<>();
        for (Plan plan : allplans) {
            plans.add(
                    PlanRequest.builder()
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
    private List<ActivityRequest> mapActivitiesResponse(final List<Activity> allActivities) {
        List<ActivityRequest> Activities = new ArrayList<>();
        for (Activity activity : allActivities) {
            Activities.add(
                    ActivityRequest.builder()
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