package leafout.backend.service;

import leafout.backend.model.Activity;
import leafout.backend.model.exception.ActivityException;
import leafout.backend.model.exception.ParkException;
import leafout.backend.model.exception.PlanException;
import leafout.backend.model.Tag;


import java.util.List;



public interface ActivityService {

    /**
     * This method get all pays
     */
    List<Activity> getAllActivities() ;

    /**
     * This method save a Activity
     * @param activity to save
     */
    void saveActivity(Activity activity) throws ActivityException, ParkException, PlanException;

    void saveActivities(List<Activity> activities) throws ActivityException, ParkException, PlanException;

    void updateActivitiesInPark(String parkName,List<Activity> activities) throws ActivityException, ParkException, PlanException;

    void updateActivitiesInPlan(String planName,List<Activity> activities) throws ActivityException, ParkException, PlanException;

    /**
     * This method get a Activity
     * @param activityName name of the Activity
     */

    Activity getActivityByName(String activityName) throws ActivityException;

    /**
     * This method get a activity
     * @param activityId id of the activity
     */
    Activity getActivityById(String activityId) throws ActivityException;

    /**
     * This method update a Activity
     * @param activity that gonna get an update Activity
     */

    Activity updateActivity(Activity activity) throws ActivityException, ParkException, PlanException;

    /**
     * This method remove  a Activity
     * @param activity UUID of the Activity
     */
    void remove(Activity activity) throws ActivityException;

    void removeActivities(List<Activity> activities);
    /**
     * This method get all popular activities
     */
    List<Activity> getAllPopulateActivities();

    List<Activity> getActivityByTags(List<Tag> tags);

    public void feedComment(String activityName, String userName, String feedbackString) throws leafout.backend.model.exception.NoUserFoundException;

}
