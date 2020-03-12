package eci.ieti.leafout.backend.service;


import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.repository.LeafOutPersistenceException;

import java.util.List;

public interface PlanService {
    List<Plan> getAllPlans() throws LeafOutPersistenceException;

    void savePlan(Plan app) throws LeafOutPersistenceException;

    Plan findPlanByName(String name) throws LeafOutPersistenceException;

}
