package leafout.backend.service.impl;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;
import leafout.backend.service.PlanServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class PlanServiceImpl implements PlanServices {
    @Override
    public List<Pay> getAllPlans() throws LeafoutPersistenceException {
        return null;
    }

    @Override
    public void savePlan(Pay plan) throws LeafoutPersistenceException {

    }

    @Override
    public Pay findPlanById(UUID plan) throws LeafoutPersistenceException {
        return null;
    }

    @Override
    public void updatePlan(Pay plan) throws LeafoutPersistenceException {

    }

    @Override
    public Integer getCostPlan(UUID plan) {
        return null;
    }
}
