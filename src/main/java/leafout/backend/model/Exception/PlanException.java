package leafout.backend.model.Exception;

import java.util.UUID;

public class PlanException extends Exception {

    public PlanException(String planName) {
        super("There are no plans with the Name " + planName);
    }
    public PlanException(UUID planId) {
        super("There no an plan exist with the ID " + planId);
    }

}
