package eci.ieti.leafout.backend.service;

import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.repository.LeafOutPersistenceException;

import java.util.List;
import java.util.UUID;

/**
 * This interface implements the basic methods of a plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
public interface PlanService {

    /**
     * This method get all plans
     */
    List<Plan> getAllPlans() throws LeafOutPersistenceException;

    /**
     * This method save a plan
     * @param plan to save
     */
    void savePlan(Plan plan) throws LeafOutPersistenceException;

    /**
     * This method get a park
     * @param plan UUID of the park
     */
    Plan findPlanByName(UUID plan) throws LeafOutPersistenceException;

    /**
     * This method update a plan
     * @param plan that gonna get an update
     */
    void updatePlan(Plan plan) throws LeafOutPersistenceException;

    /**
     * This method get the cost of a park
     * @param plan UUID of the park
     */
    Integer getCostPlan(UUID plan);
}
