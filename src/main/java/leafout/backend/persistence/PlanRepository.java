package leafout.backend.persistence;



import leafout.backend.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlanRepository  extends MongoRepository<Plan, UUID> {

    List<Plan> getAllPlans();

    Optional<Plan> getPlanById(UUID planId);

    Plan registerPlan(Plan plan);

    void updatePlan(Plan plan);

    boolean existsPlanById(UUID planId);

}
