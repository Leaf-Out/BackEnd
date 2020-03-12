package eci.ieti.leafout.backend.repository;


import eci.ieti.leafout.backend.model.Plan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PlanRepository extends CrudRepository<Plan, Integer> {

}
