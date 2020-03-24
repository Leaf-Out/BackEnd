package leafout.backend.service.impl;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.service.ActivityService;

import java.util.List;
import java.util.UUID;

public class ActivityServiceImpl implements ActivityService {
    @Override
    public List getAllActivities() {
        return null;
    }

    @Override
    public void saveActivity(Activity activity) throws LeafoutPersistenceException {

    }

    @Override
    public Activity getActivityById(UUID activityId) {
        return null;
    }

    @Override
    public void updateActivity(Activity activity) throws LeafoutPersistenceException {

    }

    @Override
    public void remove(Activity activity) throws LeafoutPersistenceException {

    }
}
