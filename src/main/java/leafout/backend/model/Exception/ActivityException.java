package leafout.backend.model.Exception;


import java.util.UUID;

public class ActivityException extends Exception {

    public ActivityException(String nameActivity) {
        super("Already exist an activity with the Name " + nameActivity);
    }

    public ActivityException(UUID activityId) {
        super("There no an activity exist with the ID " + activityId);
    }
}
