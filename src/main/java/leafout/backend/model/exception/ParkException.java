package leafout.backend.model.exception;

public class ParkException extends Exception {
  
    public ParkException(String parkName) {
        super("There are no parks with the Name " + parkName);
    }
}
