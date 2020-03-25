package leafout.backend.service.impl;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;
import leafout.backend.persistence.ActivityRepository;
import leafout.backend.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
public class ActivityServiceImpl implements ActivityService {
    @Autowired
    private ActivityRepository activityRepository;

    @Override
    public List getAllActivities() {
        return activityRepository.getAllActivities();
    }

    @Override
    public void saveActivity(Activity activity) throws LeafoutPersistenceException {
        if(!activityRepository.existsActivityById(activity.getId())){
            throw new LeafoutPersistenceException();
        }
        activityRepository.registerActivity(activity);
    }

    @Override
    public Activity getActivityById(UUID activityId) {
        Optional<Activity> optionalPay = activityRepository.getActivityById(activityId);
        return optionalPay.get();
    }

    @Override
    public void updateActivity(Activity activity) throws LeafoutPersistenceException {
        if(!activityRepository.existsActivityById(activity.getId())){
            throw new LeafoutPersistenceException();
        }
        activityRepository.updateActivity(activity);
    }

    @Override
    public void remove(Activity activity) throws LeafoutPersistenceException {
        if(!activityRepository.existsActivityById(activity.getId())){
            throw new LeafoutPersistenceException();
        }
        activityRepository.delete(activity);
    }
}
