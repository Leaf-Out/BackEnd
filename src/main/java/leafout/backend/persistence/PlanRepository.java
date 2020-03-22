package leafout.backend.persistence;

import leafout.backend.model.Park;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface PlanRepository  extends MongoRepository<Park, UUID> {

    
}
