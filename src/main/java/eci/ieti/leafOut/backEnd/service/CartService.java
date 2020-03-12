package eci.ieti.leafout.backend.service;

import java.util.List;
import java.util.UUID;

import eci.ieti.leafout.backend.apimodel.Cart;
import eci.ieti.leafout.backend.model.Plan;

/**
 * CartService
 */
public interface CartService {

    public void save(Plan plan);
    
    public Cart get(UUID id);

    public List<Plan> getAllPlans();

    public Plan getPlanById(UUID user,Integer plan);


    public void removePlan(UUID user, Integer plan);

    public void updatePlan(UUID user, Integer plan);

    public void clear(UUID user);
}