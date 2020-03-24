package leafout.backend.service;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.LeafoutPersistenceException;

import java.util.List;
import java.util.UUID;


public interface ActivityService <A extends Activity> {

    /**
     * This method get all pays
     */
    List<A> getAllActivities() ;

    /**
     * This method save a Activity
     * @param activity to save
     */
    void saveActivity(A activity) throws LeafoutPersistenceException;

    /**
     * This method get a Activity
     * @param activityId UUID of the Activity
     */

    A getActivityById(UUID activityId) ;

    /**
     * This method update a Activity
     * @param activity that gonna get an update Activity
     */

    void updateActivity(A activity)  throws LeafoutPersistenceException;

    /**
     * This method remove  a Activity
     * @param activity UUID of the Activity
     */
    void remove(A activity) throws LeafoutPersistenceException;
}
