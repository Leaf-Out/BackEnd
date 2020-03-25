package leafout.backend.service.impl;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.persistence.ActivityRepository;
import leafout.backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


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

    @Override
    public List getAllActivities() {
        return activityRepository.findAll();
    }

    @Override
    public void saveActivity(Activity activity) throws  ActivityException {
        if(activityRepository.existsActivityByName(activity.getName())){
            throw new ActivityException(activity.getName());
        }
        activityRepository.save(activity);
    }

    @Override
    public Activity getActivityByName(String activityName) {
        Optional<Activity> optionalPay = activityRepository.getActivityByName(activityName);
        return optionalPay.get();
    }

    @Override
    public Activity getActivityById(String activityId) {
        Optional<Activity> optionalPay = activityRepository.getActivityById(activityId);
        return optionalPay.get();
    }

    @Override
    public void updateActivity(Activity activity) throws ActivityException {
        if(!activityRepository.existsActivityById(activity.getId())){
            throw new ActivityException(activity.getId());
        }
        activityRepository.save(activity);
    }

    @Override
    public void remove(Activity activity) throws ActivityException {
        if(!activityRepository.existsActivityById(activity.getId())){
            throw new ActivityException(activity.getId());
        }
        activityRepository.delete(activity);
    }
}
