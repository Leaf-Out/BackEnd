package eci.ieti.leafout.backEnd.persistence;

import eci.ieti.leafout.backEnd.model.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * This interface defines the methods used to persist plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

@Repository
public interface PlanRepository {

    List<Plan> getAllPlans();

    Optional<Plan> getPlanByName(String name);

    Plan registerPlan(Plan plan);

    void updatePlan(Plan plan);
}
