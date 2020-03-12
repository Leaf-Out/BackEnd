package eci.ieti.leafout.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.repository.PlanRepository;

@Service
/**
 * PlanService
 */
public class PlanService {

    @Autowired
    PlanRepository planRepository;

    public List<Plan> getAll(){
        List<Plan> plans = new ArrayList<Plan>();
        planRepository.findAll().forEach(plan -> plans.add(plan));
        return plans;
    }

    public Optional<Plan> getById(int planId){
        return planRepository.findById(planId);
    }

    public void save(Plan plan){
        planRepository.save(plan);
    }
}