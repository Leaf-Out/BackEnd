package eci.ieti.leafOut.backEnd.persistence.impl;

import eci.ieti.leafOut.backEnd.model.Park;

import eci.ieti.leafOut.backEnd.model.Plan;
import eci.ieti.leafOut.backEnd.persistence.ParkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class ParkRepositoryImpl implements ParkRepository {

    static Map<String, Park> parkMap = new ConcurrentHashMap<>();

    public ParkRepositoryImpl(){
        Park park1 = new Park();
        park1.setIdPark(1);park1.setNamePark("park1");
        Plan plan1 = new Plan();
        plan1.setIdPlan(1);plan1.setNamePlan("plan1");
        List<Plan> planes1 = new ArrayList<>();
        planes1.add(plan1);
        park1.setPlans(planes1);
        parkMap.put("park1",park1);
    }

    @Override
    public List<Park> findAll() {
        return null;
    }

    @Override
    public Optional<Park> findByName(String name) {
        return Optional.empty();
    }


    @Override
    public Park save(Park park) {
        return null;
    }
}
