package leafout.backend.service;

import leafout.backend.model.exception.ActivityException;
import leafout.backend.model.exception.ParkException;
import leafout.backend.model.exception.PlanException;
import leafout.backend.model.Plan;
import leafout.backend.model.Tag;

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
    void savePlan(Plan plan) throws PlanException, ActivityException, ParkException;

    void savePlans(List<Plan> plans) throws PlanException, ActivityException, ParkException;

    void updatePlans(String parkName,List<Plan> plans) throws ParkException, ActivityException, PlanException;

    /**
     * This method get a Plan
     * @param planName name of the Plan
     */

    Plan getPlanByName(String planName) throws ParkException;
    /**
     * This method get a Plan
     * @param planId id of the Plan
     */
    Plan getPlanById(String planId) throws ParkException;

    /**
     * This method update a Plan
     * @param plan that gonna get an update Plan
     */

    Plan updatePlan(Plan plan) throws PlanException, ActivityException, ParkException;

    /**
     * This method remove  a Plan
     * @param plan UUID of the Plan
     */
    void remove(Plan plan) throws  PlanException;

    void removePlans(List<Plan> plans) throws PlanException;

    /**
     * This method get all Plans
     */
    List<Plan> getAllPopulatePlans();

    List<Plan> getPlansByTags(List<Tag> tag);

    void feedComment(String parkName, String userName, String feedbackString) throws leafout.backend.model.exception.NoUserFoundException;
}
