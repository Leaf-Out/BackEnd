package leafout.backend.persistence;

import leafout.backend.model.Plan;
import leafout.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface represent a MongoRepository impl
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    List<User> findAll();

    Optional<User> getUserByName(String userName);

    Optional<User> getUserByEmail(String userEmail);


    Optional<User> getUserById(String userId);

    User save(User user);

    boolean existsUserById(String userId);

    boolean existsUserByName(String userName);
}
