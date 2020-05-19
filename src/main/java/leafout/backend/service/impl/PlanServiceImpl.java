package leafout.backend.service.impl;


import leafout.backend.model.*;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.persistence.ParkRepository;
import leafout.backend.persistence.PlanRepository;
import leafout.backend.service.ActivityService;
import leafout.backend.service.PlanService;
import leafout.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ParkRepository parkRepository;

    @Autowired
    private PlanRepository planRepository;

    @Autowired
    private ActivityService activityService;

    @Autowired
    private UserService userService;


    @Override
    public List<Plan> getAllPlans()  {
        return planRepository.findAll();
    }

    @Override
    public void savePlan(Plan plan) throws PlanException, ActivityException, ParkException {
        if(planRepository.existsPlanByName(plan.getName())){
            throw new PlanException(plan.getName());
        }
        AlreadyPlanInPark(plan);
        planRepository.save(plan);
        activityService.saveActivities(plan.getActivitiesList());

    }

    @Override
    public void savePlans(List<Plan> plans) throws PlanException, ActivityException, ParkException {
        for(Plan plan : plans){
            savePlan(plan);
        }
    }

    @Override
    public void updatePlans(List<Plan> plans) throws ParkException, ActivityException, PlanException {
        for(Plan plan : plans){
            updatePlan(plan);
        }
    }

    @Override
    public Plan getPlanByName(String planName) throws ParkException {
        Optional<Plan> optionalPay = planRepository.getPlanByName(planName);
        if(!optionalPay.isPresent()){
            throw new ParkException(planName);
        }
        return optionalPay.get();

    }

    @Override
    public Plan getPlanById(String planId) throws ParkException {
        Optional<Plan> optionalPay = planRepository.getPlanById(planId);
        if(!optionalPay.isPresent()){
            throw new ParkException(planId);
        }
        return optionalPay.get();
    }

    @Override
    public Plan updatePlan(Plan plan) throws ParkException, PlanException, ActivityException {

        activityService.updateActivities(plan.getActivitiesList());
        AlreadyPlanInPark(plan);
        planRepository.save(plan);
        return plan;
    }

    private void AlreadyPlanInPark(Plan plan) throws ParkException {
        if (plan.getParkName() != null) {
            Optional<Park> park = parkRepository.getParkByName(plan.getParkName());
            if (park.isPresent()) {
                List<Plan> plansP = park.get().getPlanList();
                System.err.println(isInArray(plansP,plan));
                if (!isInArray(plansP,plan)){
                    plansP.add(plan);
                    park.get().setPlanList(plansP);
                    parkRepository.save(park.get());
                }
            } else {
                throw new ParkException(plan.getParkName());
            }
        }
    }


    private Boolean isInArray(List<Plan> plans, Plan plan){
        Boolean b = false;
        for (Plan p : plans){
            if (p.getName().equals(plan.getName())){
                b = true;
            }
        }
        return b;
    }
    @Override
    public void remove(Plan plan) throws  PlanException {
        if(!planRepository.existsPlanById(plan.getId())){
            throw new PlanException(plan.getName());
        }
        if (plan.getParkName() != null) {
            Optional<Park> park = parkRepository.getParkByName(plan.getParkName());
            if (park.isPresent()) {
                List<Plan> plansP = park.get().getPlanList();
                if (isInArray(plansP,plan)){
                    plansP.remove(removeElement(plansP,plan));
                    park.get().setPlanList(plansP);
                    parkRepository.save(park.get());
                }
            }
        }
        planRepository.delete(plan);
        activityService.removeActivities(plan.getActivitiesList());
    }

    @Override
    public void removePlans(List<Plan> plans) throws PlanException {
        for(Plan plan : plans){
            remove(plan);
        }
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

    private int removeElement(List<Plan> plans, Plan plan){
        int indexF = 0 ;
        int index=0;
        for (Plan currentPlan : plans){

            if (currentPlan.getName().equals(plan.getName())){
                indexF = index;
            }
            index+=1;
        }
        return indexF;
    }
    @Override
    public void feedComment(String planName, String userName, String feedbackString) throws leafout.backend.model.exception.NoUserFoundException {
        Plan plan = null;
        try {
            plan = getPlanByName(planName);
        } catch (ParkException e) {
            e.printStackTrace();
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Feedback feedback = plan.getFeedback();
        List<Comment> comments = feedback.getComments();
        Comment newComment = Comment.builder().content(feedbackString).user(userService.getByEmail(userName)).build();
        comments.add(newComment);
        feedback.setComments(comments);
        plan.setFeedback(feedback);
        planRepository.save(plan);

    }
}

