package leafout.backend.service;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;


import java.util.List;
import java.util.UUID;
/**
 * This interface represents all the services of a plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
public interface PlanServices {
    /**
     * This method get all plans
     */
    List<Pay> getAllPlans() throws LeafoutPersistenceException;

    /**
     * This method save a plan
     * @param plan to save
     */
    void savePlan(Pay plan) throws LeafoutPersistenceException;

    /**
     * This method get a park
     * @param plan UUID of the park
     */
    Pay findPlanById(UUID plan) throws LeafoutPersistenceException;

    /**
     * This method update a plan
     * @param plan that gonna get an update
     */
    void updatePlan(Pay plan) throws LeafoutPersistenceException;

    /**
     * This method get the cost of a park
     * @param plan UUID of the park
     */
    Integer getCostPlan(UUID plan);
}
