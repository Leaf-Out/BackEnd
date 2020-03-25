package leafout.backend.controller;


import leafout.backend.apimodel.ActivityRequest;
import leafout.backend.model.Activity;
import leafout.backend.model.Exception.LeafoutPersistenceException;
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

    @GetMapping
    public ResponseEntity<?> getAllActivities(){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivitiesResponse(activityServices.getAllActivities()), HttpStatus.ACCEPTED);
        return response;

    }


    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getActivityById(@PathVariable("id") UUID activityId){
        final ResponseEntity response;
        response = new ResponseEntity<>(mapActivityResponse(activityServices.getActivityById(activityId)), HttpStatus.ACCEPTED);
        return response;
    }



    @PostMapping
    public ResponseEntity<?> addNewActivity(@RequestBody ActivityRequest activity){
        try{
            activityServices.saveActivity(mapActivity(activity));
        }catch (LeafoutPersistenceException ex){
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.ACCEPTED);
        return response;
    }


    /**
     * This method transforms a Rest activity object into the business activity object
     *
     * @param planRequest Rest park object to be transformed
     * @return A plan object
     */
    private Activity mapActivity(final ActivityRequest planRequest) {
        Activity activity = Activity.builder().id(planRequest.getId())
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
    private ActivityRequest mapActivityResponse(final Activity activity) {
        ActivityRequest activityRe = ActivityRequest.builder().id(activity.getId())
                .description(activity.getDescription())
                .feedback(activity.getFeedback())
                .name(activity.getName())
                .prices(activity.getPrices())
                .tags(activity.getTags())
                .build();
        return activityRe;
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
                    ActivityRequest.builder().id(activity.getId())
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
