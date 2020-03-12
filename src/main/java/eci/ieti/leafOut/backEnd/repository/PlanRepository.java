package eci.ieti.leafOut.backEnd.persistence;



import eci.ieti.leafOut.backEnd.model.Plan;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlanRepository {

    List<Plan> findAll();

    Optional<Plan> findByName(String name);

    Plan save(Plan plan);
}
