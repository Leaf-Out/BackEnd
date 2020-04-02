package leafout.backend.service;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.ActivityException;


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
    void saveActivity(Activity activity) throws ActivityException;

    void saveActivities(List<Activity> activities) throws ActivityException;

    void updateActivities(List<Activity> activities) ;

    /**
     * This method get a Activity
     * @param activityName name of the Activity
     */

    Activity getActivityByName(String activityName) ;

    /**
     * This method get a activity
     * @param activityId id of the activity
     */
    Activity getActivityById(String activityId) ;

    /**
     * This method update a Activity
     * @param activity that gonna get an update Activity
     */

    void updateActivity(Activity activity) throws ActivityException;

    /**
     * This method remove  a Activity
     * @param activity UUID of the Activity
     */
    void remove(Activity activity) throws ActivityException;
    /**
     * This method get all popular activities
     */
    List<Activity> getAllPopulateActivities();

}
