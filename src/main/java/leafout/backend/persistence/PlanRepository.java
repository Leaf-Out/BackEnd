package leafout.backend.persistence;



import leafout.backend.model.Park;
import leafout.backend.model.Plan;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * This class represent the repository of a Plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Repository
public interface PlanRepository  extends MongoRepository<Plan, UUID> {
    /**
     * find all Plans created
     * @return list<Plan>
     */
    List<Plan> findAll();
    /**
     * find an Plan by id
     * @param planName the di of Plan
     * @return optional<Plan>
     **/
    Optional<Plan> getPlanByName(String planName);
    /**
     * find an Plan by id
     * @param planId the id of Plan
     * @return optional<Plan>
     **/
    Optional<Plan> getPlanById(UUID planId);
    /**
     * Save a Plan
     * @param plan the Plan would be save
     * @return Plan
     */
    Plan save(Plan plan);

    /**
     * if the Plan exisist
     * @param planId the id of Plan
     * @return boolean
     */
    boolean existsPlanById(UUID planId);
    /**
     * if the Plan exisist
     * @param activityName the id of Plan
     * @return boolean
     */
    boolean existsPlanByName(String activityName);


}
