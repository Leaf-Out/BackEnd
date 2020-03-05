package eci.ieti.leafOut.backEnd.service;


import eci.ieti.leafOut.backEnd.model.Plan;
import eci.ieti.leafOut.backEnd.persistence.LeafOutPersistenceException;

import java.util.List;
import java.util.Optional;

public interface PlanService {
    List<Plan> getAllPlans() throws LeafOutPersistenceException;

    void savePlan(Plan app) throws LeafOutPersistenceException;

    Plan findPlanByName(String name) throws LeafOutPersistenceException;

}
