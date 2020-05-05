package leafout.backend.persistence;

import leafout.backend.model.Activity;
import leafout.backend.model.Park;
import leafout.backend.model.Plan;
import leafout.backend.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * This class represent the repository of a Activity
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Repository
public interface ActivityRepository extends MongoRepository<Activity, String> {

    /**
     * find all activities created
     * @return list<Activity>
     */
    List<Activity> findAll();

    List<Activity> findAllByOrderByFeedbackDesc();
    /**
     * find an activity by name
     * @param activitiesName the di of activity
     * @return optional<Activity>
     **/
    Optional<Activity> getActivityByName(String activitiesName);
    /**
     * find an activity by id
     * @param activitiesId the id of activity
     * @return optional<Activity>
     **/
    Optional<Activity> getActivityById(String activitiesId);

    /**
     * Save a activity
     * @param activity the activity would be save
     * @return activity
     */
    Activity save(Activity activity);



    /**
     * if the acivity exisist
     * @param activityId the id of activity
     * @return boolean
     */
    boolean existsActivityById(String activityId);

    /**
     * if the acivity exisist
     * @param activityName the id of activity
     * @return boolean
     */
    boolean existsActivityByName(String activityName);


    List<Activity> getAllByTags(List<Tag> tags);


}
