package leafout.backend.service;

import leafout.backend.model.Exception.ActivityException;
import leafout.backend.model.Exception.ParkException;
import leafout.backend.model.Exception.PlanException;
import leafout.backend.model.Park;


import java.util.List;


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

    Park getParkByName(String parkName) ;
    /**
     * This method get a Park
     * @param parkId id of the Park
     */
    Park getParkById(String parkId) ;

    /**
     * This method update a pay
     * @param park that gonna get an update pay
     */

    void updatePark(Park park) throws ParkException, ActivityException, PlanException;

    /**
     * This method remove  a pay
     * @param park UUID of the pay
     */
    void remove(Park park) throws  ParkException;

    /**
     * This method get all Plans
     */
    List<Park> getAllPopulateParks();
}
