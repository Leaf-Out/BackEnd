package leafout.backend.service;

import leafout.backend.model.User;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.UserAlreadyExistsException;

import java.util.List;
import java.util.Optional;


/**
 * This class represent an User for the client.
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
public interface UserService {

    List<User> getAll() throws NoUserFoundException;
    Optional<User> getById(String userId) throws NoUserFoundException;
    void save(User user) throws UserAlreadyExistsException;
    void delete(String userId) throws NoUserFoundException;

}
