package eci.ieti.leafout.backend.apimodel;

import java.util.List;
import java.util.UUID;

import eci.ieti.leafout.backend.model.Plan;

/**
 * Cart
 */
public class Cart {

    private UUID id;
    private UUID user;
    private List<Plan> plans;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getUser() {
        return user;
    }

    public void setUser(UUID user) {
        this.user = user;
    }

    public List<Plan> getPlans() {
        return plans;
    }

    public void setPlans(List<Plan> plans) {
        this.plans = plans;
    }

    public Cart() {
    }
    
}