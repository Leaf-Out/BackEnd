package leafout.backend.persistence;

import leafout.backend.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

/**
 * This interface represent a MongoRepository impl
 *
 * @author <a href=sergio.ruiz-p@mail.escuelaing.edu.co> Sergio Hernando Ruiz Paez </a>
 * @since 0.0.1
 */
public interface UserRepository extends MongoRepository<User, UUID> {

}
