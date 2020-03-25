package leafout.backend.persistence;

import leafout.backend.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class represent the repository of a Activity
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Repository
public interface ActivityRepository extends MongoRepository<Activity, UUID> {

    /**
     * find all activities created
     * @return list<Activity>
     */
    List<Activity> findAll();

    /**
     * find an activity by id
     * @param activitiesId the di of activity
     * @return optional<Activity>
     **/
    Optional<Activity> getActivityById(UUID activitiesId);

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
    boolean existsActivityById(UUID activityId);
}
