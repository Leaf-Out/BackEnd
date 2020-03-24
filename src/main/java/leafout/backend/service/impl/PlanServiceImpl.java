package leafout.backend.service.impl;


import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Plan;
import leafout.backend.persistence.PlanRepository;
import leafout.backend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    public List getAllPlans()  {
        return null;
    }

    @Override
    public void savePlan(Plan plan) throws LeafoutPersistenceException {

    }

    @Override
    public Plan getPlanById(UUID planId)  {
        return null;
    }

    @Override
    public void updatePlan(Plan plan) throws LeafoutPersistenceException {

    }

    @Override
    public void remove(Plan plan) throws LeafoutPersistenceException {

    }
}

