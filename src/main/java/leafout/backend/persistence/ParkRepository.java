package leafout.backend.persistence;

import leafout.backend.model.Park;

import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface ParkRepository extends MongoRepository<Park, UUID> {
    


}
