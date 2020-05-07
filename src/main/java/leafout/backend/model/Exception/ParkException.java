package leafout.backend.model.Exception;

import java.util.UUID;

public class ParkException extends Exception {

    public ParkException(String nameActivity) {
        super("There park exist with the Name " + nameActivity);
    }
    public ParkException(UUID parkId) {
        super("There no an park exist with the ID " + parkId);
    }

}
