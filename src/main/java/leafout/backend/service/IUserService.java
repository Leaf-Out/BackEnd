package leafout.backend.service;

import leafout.backend.model.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class represent an User for the client.
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
public interface IUserService {

    List<User> getAll();
    Optional<User> getById(UUID userId);
    void save(User user);
    void delete(UUID userId);

}
