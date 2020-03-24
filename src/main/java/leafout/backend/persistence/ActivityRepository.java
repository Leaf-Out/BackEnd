package leafout.backend.persistence;

import leafout.backend.model.Activity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ActivityRepository extends MongoRepository<Activity, UUID> {
    List<Activity> getAllActivities();

    Optional<Activity> getActivityById(UUID activitiesId);

    Activity registerActivity(Activity activity);

    void updateActivity(Activity activity);

    boolean existsActivityById(UUID activityId);
}
