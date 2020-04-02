package leafout.backend.controller;


import leafout.backend.apimodel.ActivityRequest;
import leafout.backend.apimodel.ActivityResponse;
import leafout.backend.model.Activity;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.service.ActivityService;
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
@RequestMapping(value = "/activities")
public class ActivityController {

    @Autowired
    private ActivityService activityServices;

    /**
     * This method returns all activities create
     * @return
     */
    @GetMapping
    public ResponseEntity<?> getAllActivities(){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivitiesResponse(activityServices.getAllActivities()), HttpStatus.ACCEPTED);
        return response;

    }

    /**
     * This method returns all Plans Popular
     * @return
     */
    @GetMapping(path = "/popular")
    public ResponseEntity<?> getAllPopularActivities(){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivitiesResponse(activityServices.getAllPopulateActivities()), HttpStatus.ACCEPTED);
        return response;

    }


    /**
     * This method returns a http response with the activity of the id
     * @param activityName id of the conrresponsive activity
     * @return http response
     */
    @GetMapping(path = "/{name}")
    public ResponseEntity<?> getActivityById(@PathVariable("name") String activityName){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivityResponse(activityServices.getActivityByName(activityName)), HttpStatus.ACCEPTED);
        return response;
    }


    /**
     * This method create a new activity
     * @param activity the activity that would be create
     * @return http reponse
     */
    @PostMapping
    public ResponseEntity<?> addNewActivity(@RequestBody ActivityRequest activity){
        try{
            activityServices.saveActivity(mapActivity(activity));
        }catch (ActivityException ex){
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;
    }


    /**
     * This method transforms a Rest activity object into the business activity object
     *
     * @param planRequest Rest park object to be transformed
     * @return A plan object
     */
    public Activity mapActivity(final ActivityRequest planRequest) {
        Activity activity = Activity.builder().id(UUID.randomUUID().toString())
                .description(planRequest.getDescription())
                .feedback(planRequest.getFeedback())
                .name(planRequest.getName())
                .prices(planRequest.getPrices())
                .tags(planRequest.getTags())
                .build();
        return activity;
    }
    /**
     * This method transforms a Rest activity object into the business activity object
     *
     * @param activity Rest park object to be transformed
     * @return A plan object
     */
    public ActivityResponse mapActivityResponse(final Activity activity) {
        ActivityResponse activityResponse = ActivityResponse.builder().id(activity.getId())
                .description(activity.getDescription())
                .feedback(activity.getFeedback())
                .name(activity.getName())
                .prices(activity.getPrices())
                .tags(activity.getTags())
                .build();
        return activityResponse;
    }
    /**
     * This method transforms a lists of  activities object into the response  list activities object
     *
     * @param allActivities Rest park object to be transformed
     * @return A List<Activities>  object
     */
    public List<ActivityResponse> mapActivitiesResponse(final List<Activity> allActivities) {
        List<ActivityResponse> Activities = new ArrayList<>();
        if(!(allActivities == null)){
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
        }
        return Activities;
    }
    /**
     * This method transforms a lists of  activities object into the response  list activities object
     *
     * @param allActivitiesRequest Rest park object to be transformed
     * @return A List<Activities>  object
     */
    public List<Activity> mapActivitiesRequiest(final List<ActivityRequest> allActivitiesRequest) {
        List<Activity> Activities = new ArrayList<>();
        if (!(allActivitiesRequest == null)){
            for (ActivityRequest activity : allActivitiesRequest) {
                Activities.add(
                        Activity.builder().id(UUID.randomUUID().toString())
                                .description(activity.getDescription())
                                .feedback(activity.getFeedback())
                                .name(activity.getName())
                                .prices(activity.getPrices())
                                .tags(activity.getTags())
                                .build()
                );
            }
        }

        return Activities;
    }

}
