package eci.ieti.leafout.backend.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import eci.ieti.leafout.backend.apimodel.Cart;
import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.repository.CartPersistence;
import eci.ieti.leafout.backend.service.CartService;

/**
 * CartServiceImpl
 */
public class CartServiceImpl implements CartService {

    @Autowired
    CartPersistence cartPersistence;

    @Override
    public List<Plan> getAllPlans() {
        cartPersistence.findAll();
        return null;
    }

    @Override
    public Plan getPlanById(UUID user, Integer plan) {
        return null;
    }

    @Override
    public void removePlan(UUID user, Integer plan) {

    }

    @Override
    public void updatePlan(UUID user, Integer plan) {

    }

    @Override
    public void clear(UUID user) {

    }

    @Override
    public void save(Plan plan) {

    }

    @Override
    public Cart get(UUID id) {
        return null;
    }

    
}