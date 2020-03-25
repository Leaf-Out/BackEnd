package leafout.backend.service.impl;


import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Park;
import leafout.backend.model.Plan;
import leafout.backend.persistence.PlanRepository;
import leafout.backend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class represent the implementation of the services of plans
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Service
public class PlanServiceImpl implements PlanService {


    @Autowired
    private PlanRepository planRepository;

    @Override
    public List<Plan> getAllPlans()  {
        return planRepository.getAllPlans();
    }

    @Override
    public void savePlan(Plan plan) throws LeafoutPersistenceException {
        if(!planRepository.existsPlanById(plan.getId())){
            throw new LeafoutPersistenceException();
        }
        planRepository.registerPlan(plan);
    }

    @Override
    public Plan getPlanById(UUID planId)  {
        Optional<Plan> optionalPay = planRepository.getPlanById(planId);
        return optionalPay.get();
    }

    @Override
    public void updatePlan(Plan plan) throws LeafoutPersistenceException {
        if(!planRepository.existsPlanById(plan.getId())){
            throw new LeafoutPersistenceException();
        }
        planRepository.updatePlan(plan);
    }

    @Override
    public void remove(Plan plan) throws LeafoutPersistenceException {
        if(!planRepository.existsPlanById(plan.getId())){
            throw new LeafoutPersistenceException();
        }
        planRepository.delete(plan);
    }
}

