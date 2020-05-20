package leafout.backend.service.impl;

import leafout.backend.model.*;
import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;


import leafout.backend.persistence.ParkRepository;
import leafout.backend.service.ActivityService;
import leafout.backend.service.ParkService;

import leafout.backend.service.PlanService;
import leafout.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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
    @Autowired
    private UserService userService;

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
    public Park updatePark(Park park) throws ParkException, ActivityException, PlanException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new ParkException(park.getId());
        }


        planService.updatePlans(park.getName(),park.getPlanList());
        activityService.updateActivitiesInPark( park.getName(),park.getActivitiesList());
        parkRepository.save(park);
        return park;
    }

    @Override
    public void remove(Park park) throws ParkException, PlanException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new ParkException(park.getId());
        }

        planService.removePlans(park.getPlanList());
        activityService.removeActivities(park.getActivitiesList());
        parkRepository.delete(park);
    }

    @Override
    public List getAllPopulateParks() {
        List<Park> allPopularParks = parkRepository.findAllByOrderByFeedbackDesc();
        List<Park> allPopular = allPopularParks.subList(0,allPopularParks.size());
        return allPopular;
    }

    @Override
    public void feedComment(String parkName, String userName, String feedbackString) throws leafout.backend.model.exception.NoUserFoundException {
        Park park = null;
        try {
            park = getParkByName(parkName);
        } catch (ParkException e) {
            e.printStackTrace();
            new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Feedback feedback = park.getFeedback();
        List<Comment> comments = feedback.getComments();
        Comment newComment = Comment.builder().content(feedbackString).user(userService.getByEmail(userName)).build();
        comments.add(newComment);
        feedback.setComments(comments);
        park.setFeedback(feedback);
        parkRepository.save(park);
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
