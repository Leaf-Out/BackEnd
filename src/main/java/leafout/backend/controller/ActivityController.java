package leafout.backend.controller;


import leafout.backend.apimodel.ActivityRequest;
import leafout.backend.apimodel.ActivityResponse;
import leafout.backend.apimodel.PayRequest;
import leafout.backend.model.Activity;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.model.Feedback;
import leafout.backend.model.Plan;
import leafout.backend.model.Tag;
import leafout.backend.service.ActivityService;
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
        ResponseEntity response;
        try {
            response = new ResponseEntity<>(mapActivityResponse(activityServices.getActivityByName(activityName)), HttpStatus.ACCEPTED);
        } catch (ActivityException e) {
            e.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return response;
    }


    /**
     * This method create a new activity
     * @param activity the activity that would be create
     * @return http reponse
     */
    @PostMapping
    public ResponseEntity<?> addNewActivity(@RequestBody ActivityRequest activity){
        ResponseEntity response;
        try{
            activityServices.saveActivity(mapActivity(activity));
            response = new ResponseEntity<>(HttpStatus.CREATED);
        }catch (ActivityException | ParkException | PlanException ex){
            ex.printStackTrace();
            response = new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
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
        response = new ResponseEntity<>(mapActivitiesResponse(activityServices.getActivityByTags(tagList)), HttpStatus.ACCEPTED);
        return response;
    }

    /**
     * This method rating a activity
     * @param activityName the name of a activity
     *
     */
    @SneakyThrows
    @PostMapping(path = "/{name}/rating")
    public ResponseEntity<?> ratingPark(@RequestBody Double rating, @PathVariable("name") String activityName) {
        Activity activity = activityServices.getActivityByName(activityName);
        Feedback feedback = activity.getFeedback();
        feedback.setRating((feedback.getRating()+rating)/2);
        activity.setFeedback(feedback);
        System.err.println(activity.getFeedback().getRating());
        try {
            activityServices.updateActivity(activity);
        } catch (ActivityException ex) {
            ex.printStackTrace();
        }
        final ResponseEntity response = new ResponseEntity<>(HttpStatus.CREATED);
        return response;

    }


    /**
     * This method transforms a Rest activity object into the business activity object
     *
     * @param activityRequest Rest park object to be transformed
     * @return A plan object
     */
    public Activity mapActivity(final ActivityRequest activityRequest) {
        Activity activity = Activity.builder().id(UUID.randomUUID().toString())
                .description(activityRequest.getDescription())
                .feedback(activityRequest.getFeedback())
                .name(activityRequest.getName())
                .prices(activityRequest.getPrices())
                .tags(activityRequest.getTags())
                .parkName(activityRequest.getParkName())
                .planName(activityRequest.getPlanName())
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
                .parkName(activity.getParkName())
                .planName(activity.getPlanName())
                .type(PayRequest.ACTIVITY)
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
                                .parkName(activity.getParkName())
                                .planName(activity.getPlanName())
                                .type(PayRequest.ACTIVITY)
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
            for (ActivityRequest activityRequest : allActivitiesRequest) {
                Activities.add(
                        Activity.builder().id(UUID.randomUUID().toString())
                                .description(activityRequest.getDescription())
                                .feedback(activityRequest.getFeedback())
                                .name(activityRequest.getName())
                                .prices(activityRequest.getPrices())
                                .tags(activityRequest.getTags())
                                .parkName(activityRequest.getParkName())
                                .planName(activityRequest.getPlanName())
                                .build()
                );
            }
        }

        return Activities;
    }

}
