package eci.ieti.leafout.backEnd.service.impl;


import eci.ieti.leafout.backEnd.model.Plan;
import eci.ieti.leafout.backEnd.model.exception.LeafOutPersistenceException;
import eci.ieti.leafout.backEnd.persistence.PlanRepository;
import eci.ieti.leafout.backEnd.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements the basic methods of a Plan
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;


    @Override
    public List<Plan> getAllPlans() throws LeafOutPersistenceException {
        return planRepository.getAllPlans();
    }

    @Override
    public void savePlan(Plan plan) throws LeafOutPersistenceException {
        planRepository.registerPlan(plan);
    }

    @Override
    public Plan findPlanByName(UUID park) throws LeafOutPersistenceException {
        return null;
    }

    @Override
    public void updatePlan(Plan plan) throws LeafOutPersistenceException {
        Optional<Plan> optinalPlan = planRepository.getPlanByName(plan.getNamePlan());
        boolean present = optinalPlan.isPresent();
        if (!present)
            throw new LeafOutPersistenceException(LeafOutPersistenceException.PLAN_NOT_FOUND);
        else {

        }

    }

    @Override
    public Integer getCostPlan(UUID plan) {
        return null;
    }
}
