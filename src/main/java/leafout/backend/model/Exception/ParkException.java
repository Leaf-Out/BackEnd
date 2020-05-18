package leafout.backend.model.Exception;

import java.util.UUID;

public class ParkException extends Exception {

    public ParkException(String parkName) {
        super("There are no parks with the Name " + parkName);
    }
    public ParkException(UUID parkId) {
        super("There no an park exist with the ID " + parkId);
    }

}
