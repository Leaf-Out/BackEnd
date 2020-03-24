package leafout.backend.service;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Plan;

import java.util.List;
import java.util.UUID;

public interface PlanService <P extends Plan>{

    /**
     * This method get all Plans
     */
    List<P> getAllPlans();

    /**
     * This method save a Plan
     * @param plan to save
     */
    void savePlan(P plan) throws LeafoutPersistenceException;

    /**
     * This method get a Plan
     * @param planId UUID of the Plan
     */

    P getPlanById(UUID planId) ;

    /**
     * This method update a Plan
     * @param plan that gonna get an update Plan
     */

    void updatePlan(P plan)  throws LeafoutPersistenceException;

    /**
     * This method remove  a Plan
     * @param plan UUID of the Plan
     */
    void remove(P plan) throws LeafoutPersistenceException;
}
