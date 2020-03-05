package eci.ieti.leafOut.backEnd.service.impl;


import eci.ieti.leafOut.backEnd.model.Park;
import eci.ieti.leafOut.backEnd.model.Plan;
import eci.ieti.leafOut.backEnd.persistence.LeafOutPersistenceException;
import eci.ieti.leafOut.backEnd.persistence.PlanRepository;
import eci.ieti.leafOut.backEnd.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;


    @Override
    public List<Plan> getAllPlans() throws LeafOutPersistenceException {
        return planRepository.findAll();
    }

    @Override
    public void savePlan(Plan plan) throws LeafOutPersistenceException {
        planRepository.save(plan);
    }

    @Override
    public Plan findPlanByName(String name) throws LeafOutPersistenceException {
        Optional<Plan> optinalPlan = planRepository.findByName(name);
        boolean present = optinalPlan.isPresent();
        if (!present)
            throw new LeafOutPersistenceException(LeafOutPersistenceException.PLAN_NOT_FOUND);
        return optinalPlan.get();
    }
}
