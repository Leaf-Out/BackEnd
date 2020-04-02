package leafout.backend.service.impl;


import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.model.Plan;
import leafout.backend.model.Tag;
import leafout.backend.persistence.PlanRepository;
import leafout.backend.service.ActivityService;
import leafout.backend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;


/**
 * This class represent the implementation of the services of plans
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Service
public class PlanServiceImpl implements PlanService {


    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ActivityService activityService;

    @Override
    public List<Plan> getAllPlans()  {
        return planRepository.findAll();
    }

    @Override
    public void savePlan(Plan plan) throws PlanException, ActivityException {
        if(planRepository.existsPlanByName(plan.getName())){
            throw new PlanException(plan.getName());
        }
        planRepository.save(plan);
        activityService.saveActivities(plan.getActivitiesList());

    }

    @Override
    public void savePlans(List<Plan> plans) throws PlanException, ActivityException {
        for(Plan plan : plans){
            planRepository.save(plan);
            activityService.saveActivities(plan.getActivitiesList());
        }
    }

    @Override
    public void updatePlans(List<Plan> plans) {
        for(Plan plan : plans){
            planRepository.save(plan);
            activityService.updateActivities(plan.getActivitiesList());
        }
    }

    @Override
    public Plan getPlanByName(String planName)  {
        Optional<Plan> optionalPay = planRepository.getPlanByName(planName);
        return optionalPay.get();
    }

    @Override
    public Plan getPlanById(String planId) {
        Optional<Plan> optionalPay = planRepository.getPlanById(planId);
        return optionalPay.get();
    }

    @Override
    public void updatePlan(Plan plan) throws PlanException, ActivityException {
        if(!planRepository.existsPlanById(plan.getId())){
            throw new PlanException(plan.getId());
        }
        planRepository.save(plan);
        activityService.saveActivities(plan.getActivitiesList());
    }

    @Override
    public void remove(Plan plan) throws  PlanException {
        if(!planRepository.existsPlanById(plan.getId())){
            throw new PlanException(plan.getId());
        }
        planRepository.delete(plan);
    }

    @Override
    public List getAllPopulatePlans() {
        List<Plan> allPopularPlans = planRepository.findAllByOrderByFeedbackDesc();
        List<Plan> allPopular = allPopularPlans.subList(0,allPopularPlans.size());
        return allPopular;
    }

    @Override
    public List<Plan> getPlansByTags(List<Tag> tags) {
        return planRepository.getAllByTags(tags);
    }
}

