package leafout.backend.service;

import leafout.backend.model.exception.ActivityException;
import leafout.backend.model.exception.ParkException;
import leafout.backend.model.exception.PlanException;
import leafout.backend.model.Park;
import leafout.backend.model.Population;
import leafout.backend.model.Tag;


import java.util.List;
import java.util.Map;


public interface ParkService  {
    /**
     * This method get all pays
     */
    List<Park> getAllParks() ;

    /**
     * This method save a pay
     * @param park to save
     */
    void savePark(Park park) throws ParkException, PlanException, ActivityException;

    /**
     * This method get a pay
     * @param parkName name of the park
     */

    Park getParkByName(String parkName) throws ParkException;
    /**
     * This method get a Park
     * @param parkId id of the Park
     */
    Park getParkById(String parkId) throws ParkException;

    /**
     * This method update a pay
     * @param park that gonna get an update pay
     */

    Park updatePark(Park park) throws ParkException, ActivityException, PlanException;

    /**
     * This method remove  a pay
     * @param park UUID of the pay
     */
    void remove(Park park) throws ParkException, PlanException;

    /**
     * This method get all Plans
     */
    List<Park> getAllPopulateParks();

    void feedComment(String parkName, String userName,  String feedbackString) throws leafout.backend.model.exception.NoUserFoundException;


    List<Park> getParksByTags(List<Tag> tag);

    List<Park> getParksByRegion(String region);

    List<Park> getParksByPopulationAndPrice(Map<Population,Double> price);
}
