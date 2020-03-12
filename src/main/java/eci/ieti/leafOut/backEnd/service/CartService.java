package eci.ieti.leafOut.backEnd.service;

import java.util.List;
import java.util.UUID;

import eci.ieti.leafout.backend.model.Plan;

/**
 * CartService
 */
public interface CartService {

    public List<Plan> getAllPlans();

    public Plan getPlanById(UUID user,Integer plan);

    public void removePlan(UUID user, Integer plan);

    public void updatePlan(UUID user, Integer plan);

    public void clear(UUID user);
}