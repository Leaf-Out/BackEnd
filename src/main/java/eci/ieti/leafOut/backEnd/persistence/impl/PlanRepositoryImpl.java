package eci.ieti.leafout.backEnd.persistence.impl;

import eci.ieti.leafout.backEnd.model.Plan;
import eci.ieti.leafout.backEnd.persistence.PlanRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PlanRepositoryImpl implements PlanRepository {

    static Map<String, Plan> planMap = new ConcurrentHashMap<>();

    public PlanRepositoryImpl(){
        Plan plan1 = Plan.builder().idPlan(1).namePlan("plan1").build();
        planMap.put("plan1",plan1);
    }

    @Override
    public List<Plan> getAllPlans() {
        return null;
    }

    @Override
    public Optional<Plan> getPlanByName(String name) {
        return Optional.empty();
    }



    @Override
    public Plan registerPlan(Plan plan) {
        return null;
    }

    @Override
    public void updatePlan(Plan plan) {

    }
}
