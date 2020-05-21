package leafout.backend.model.exception;

public class PlanException extends Exception {

    public PlanException(String planName) {
        super("There are no plans with the Name " + planName);
    }

}
