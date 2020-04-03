package leafout.backend.model.Exception;

import java.util.UUID;

public class PlanException extends Exception {

    public PlanException(String nameActivity) {
        super("There activity exist with the Name " + nameActivity);
    }

    public PlanException(UUID planId) {
        super("There no an plan exist with the ID " + planId);
    }

}
