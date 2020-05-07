package leafout.backend.service.impl;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.model.Park;
import leafout.backend.model.Plan;
import leafout.backend.model.Tag;
import leafout.backend.persistence.ActivityRepository;
import leafout.backend.persistence.ParkRepository;
import leafout.backend.persistence.PlanRepository;
import leafout.backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


/**
 * This class represent the implementation of the services of Activities
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private ParkRepository parkRepository;

    @Autowired
    private PlanRepository planRepository;

    @Override
    public List getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void saveActivity(Activity activity) throws ActivityException, ParkException, PlanException {
        if(activityRepository.existsActivityByName(activity.getName())){
            throw new ActivityException(activity.getName());
        }
        activityRepository.save(activity);
        AlreadyActivityInPark(activity);
        AlreadyActivityInPlan(activity);

    }

    @Override
    public void saveActivities(List<Activity> activities) throws ActivityException, ParkException, PlanException {
        for (Activity activity: activities){
            saveActivity(activity);
        }

    }

    @Override
    public void updateActivities(List<Activity> activities) throws ParkException, PlanException, ActivityException {

        for (Activity activity: activities){
           updateActivity(activity);
        }
    }

    @Override
    public Activity getActivityByName(String activityName) throws ActivityException {
        Optional<Activity> optionalPay = activityRepository.getActivityByName(activityName);
        if (!optionalPay.isPresent()){
            throw new ActivityException(activityName);
        }
        return optionalPay.get();
    }

    @Override
    public Activity getActivityById(String activityId) throws ActivityException {
        Optional<Activity> optionalPay = activityRepository.getActivityById(activityId);
        if (!optionalPay.isPresent()){
            throw new ActivityException(activityId);
        }
        return optionalPay.get();
    }

    @Override
    public Activity updateActivity(Activity activity) throws ActivityException, ParkException, PlanException {

        activityRepository.save(activity);
        AlreadyActivityInPark(activity);
        AlreadyActivityInPlan(activity);

        return activity;
    }

    private void AlreadyActivityInPark(Activity activity) throws ParkException, PlanException {
        if (activity.getParkName() != null){
            Optional<Park> park = parkRepository.getParkByName(activity.getParkName());
            if (park.isPresent()){
                List<Activity> activityP = park.get().getActivitiesList();
                if(!isInArray(activityP,activity)){
                    activityP.add(activity);
                    park.get().setActivitiesList(activityP);
                    parkRepository.save(park.get());
                }
            }else {
                throw new ParkException(activity.getParkName());
            }
        }

    }

    private void AlreadyActivityInPlan(Activity activity) throws PlanException {
        if (activity.getPlanName() != null){
            Optional<Plan> plan = planRepository.getPlanByName(activity.getPlanName());
            if (plan.isPresent()){
                List<Activity> activityPl = plan.get().getActivitiesList();
                if(!isInArray(activityPl,activity)){
                    activityPl.add(activity);
                    plan.get().setActivitiesList(activityPl);
                    planRepository.save(plan.get());
                }
            }else {
                throw new PlanException(activity.getPlanName());
            }
        }
    }
    private Boolean isInArray(List<Activity> activities, Activity activity){
        Boolean b = false;
        for (Activity a : activities){
            if (a.getName().equals(activity.getName())){
                b = true;
            }
        }
        return b;
    }

    @Override
    public void remove(Activity activity) throws ActivityException{
        if(!activityRepository.existsActivityById(activity.getId())){
            throw new ActivityException(activity.getName());
        }
        if (activity.getPlanName() != null){
            Optional<Plan> plan = planRepository.getPlanByName(activity.getPlanName());
            if (plan.isPresent()){
                List<Activity> activityPl = plan.get().getActivitiesList();
                if(isInArray(activityPl,activity)){
                    activityPl.remove(removeElement(activityPl,activity));
                    plan.get().setActivitiesList(activityPl);
                    planRepository.save(plan.get());
                }
            }
        }
        if (activity.getParkName() != null){
            Optional<Park> park = parkRepository.getParkByName(activity.getParkName());
            if (park.isPresent()){
                List<Activity> activityP = park.get().getActivitiesList();
                if(isInArray(activityP,activity)){
                    activityP.remove(removeElement(activityP,activity));
                    park.get().setActivitiesList(activityP);
                    parkRepository.save(park.get());
                }
            }
        }

        activityRepository.delete(activity);
    }
    private int removeElement(List<Activity> activities, Activity activity){
        int indexF = 0 ;
        int index=0;
        for (Activity currentActivity : activities){

            if (currentActivity.getName().equals(activity.getName())){
                indexF = index;
            }
            index+=1;
        }
        return indexF;
    }

    @Override
    public void removeActivities(List<Activity> activities) {
        for (Activity activity: activities){
            activityRepository.delete(activity);
        }
    }

    @Override
    public List getAllPopulateActivities() {
        List<Activity> allPopularActivities = activityRepository.findAllByOrderByFeedbackDesc();
        List<Activity> allPopular = allPopularActivities.subList(0,allPopularActivities.size());
        return allPopular;
    }

    @Override
    public List<Activity> getActivityByTags(List<Tag> tags) {
        return activityRepository.getAllByTags(tags);
    }
}
