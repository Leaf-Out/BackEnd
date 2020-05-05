package leafout.backend.service.impl;

import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.model.Location;
import leafout.backend.model.Park;


import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import leafout.backend.persistence.ParkRepository;
import leafout.backend.service.ActivityService;
import leafout.backend.service.ParkService;

import leafout.backend.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.Optional;



/**
 * This class represent the implementation of the services of parks
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Service
public class ParkServiceImpl implements ParkService {


    @Autowired
    private ParkRepository parkRepository;
    @Autowired
    private PlanService planService;
    @Autowired
    private ActivityService activityService;

    @Override
    public List getAllParks() {

        return parkRepository.findAll();
    }

    @Override
    public void savePark(Park park) throws ParkException, PlanException, ActivityException {
        if(parkRepository.existsParkByName(park.getName())){

            throw new ParkException(park.getName());
        }
        parkRepository.save(park);
        planService.savePlans(park.getPlanList());
        activityService.saveActivities(park.getActivitiesList());
    }


    @Override
    public Park  getParkByName(String parkName) throws ParkException {
        Optional<Park> optionalPay = parkRepository.getParkByName(parkName);
        if(!optionalPay.isPresent()){
            throw new ParkException(parkName);
        }
        return optionalPay.get();
    }

    @Override
    public Park getParkById(String parkId) throws ParkException {
        Optional<Park> optionalPay = parkRepository.getParkById(parkId);
        if(!optionalPay.isPresent()){
            throw new ParkException(parkId);
        }
        return optionalPay.get();
    }

    @Override
    public void updatePark(Park park) throws ParkException, ActivityException, PlanException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new ParkException(park.getId());
        }
        parkRepository.save(park);
        planService.updatePlans(park.getPlanList());
        activityService.updateActivities(park.getActivitiesList());
    }

    @Override
    public void remove(Park park) throws  ParkException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new ParkException(park.getId());
        }
        parkRepository.delete(park);
    }

    @Override
    public List getAllPopulateParks() {
        List<Park> allPopularParks = parkRepository.findAllByOrderByFeedbackDesc();
        List<Park> allPopular = allPopularParks.subList(0,allPopularParks.size());
        return allPopular;
    }

    @Override
    public List<Park> getParksByTags(List<Tag> tags) {
        return parkRepository.getAllByTagsContaining(tags);
    }

    @Override
    public List<Park> getParksByRegion(String region) {
        return parkRepository.getAllByLocation_Region(region);
    }

    @Override
    public List<Park> getParksByPopulationAndPrice(Map<Population,Double> price) {
        return parkRepository.getAllByPricesLessThanEqual(price);
    }
}
