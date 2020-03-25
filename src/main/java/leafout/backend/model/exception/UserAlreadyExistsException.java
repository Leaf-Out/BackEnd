package leafout.backend.model.exception;

import java.util.UUID;

/**
 * This exception occurs when an already user is tried to be added.
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(UUID user) { super("There is an user "+ user + "already exists"); }
}
