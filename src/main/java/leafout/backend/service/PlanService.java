package leafout.backend.service;

import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.model.Plan;

import java.util.List;


public interface PlanService {

    /**
     * This method get all Plans
     */
    List<Plan> getAllPlans();

    /**
     * This method save a Plan
     * @param plan to save
     */
    void savePlan(Plan plan) throws PlanException, ActivityException;

    void savePlans(List<Plan> plans) throws PlanException, ActivityException;

    void updatePlans(List<Plan> plans) ;

    /**
     * This method get a Plan
     * @param planName name of the Plan
     */

    Plan getPlanByName(String planName) ;
    /**
     * This method get a Plan
     * @param planId id of the Plan
     */
    Plan getPlanById(String planId) ;

    /**
     * This method update a Plan
     * @param plan that gonna get an update Plan
     */

    void updatePlan(Plan plan) throws PlanException, ActivityException;

    /**
     * This method remove  a Plan
     * @param plan UUID of the Plan
     */
    void remove(Plan plan) throws  PlanException;

    /**
     * This method get all Plans
     */
    List<Plan> getAllPopulatePlans();
}
