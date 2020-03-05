package eci.ieti.leafOut.backEnd.persistence.impl;

import eci.ieti.leafOut.backEnd.model.Plan;
import eci.ieti.leafOut.backEnd.persistence.PlanRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class PlanRepositoryImpl implements PlanRepository {

    static Map<String, Plan> planMap = new ConcurrentHashMap<>();

    public PlanRepositoryImpl(){
        Plan plan1 = new Plan();
        plan1.setIdPlan(1);plan1.setNamePlan("plan1");
        planMap.put("plan1",plan1);
    }

    @Override
    public List<Plan> findAll() {
        return null;
    }

    @Override
    public Optional<Plan> findByName(String name) {
        return Optional.empty();
    }



    @Override
    public Plan save(Plan plan) {
        return null;
    }
}
