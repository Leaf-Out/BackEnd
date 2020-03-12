package eci.ieti.leafout.backEnd.persistence.impl;

import eci.ieti.leafout.backEnd.model.Park;

import eci.ieti.leafout.backEnd.model.Plan;
import eci.ieti.leafout.backEnd.persistence.ParkRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;



public class ParkRepositoryImpl implements ParkRepository {

    static Map<String, Park> parkMap = new ConcurrentHashMap<>();

    public ParkRepositoryImpl(){
        Park park1 = Park.builder().idPark(1).addressPark("park1").build();
        Plan plan1 = Plan.builder().idPlan(1).namePlan("pla1").build();
        List<Plan> planes1 = new ArrayList<>();
        planes1.add(plan1);
        park1.setPlans(planes1);
        parkMap.put("park1",park1);
    }

    @Override
    public List<Park> getAllParks() {
        return (List<Park>) parkMap.values();
    }

    @Override
    public Optional<Park> getParkByName(String name) {
        Optional<Park> optionalPark = Optional.ofNullable(parkMap.get(name));

        return optionalPark;
    }


    @Override
    public Park registerPark(Park park) {
        return parkMap.put(park.getNamePark(),park);
    }

    @Override
    public void updatePark(Park park) {

    }
}
