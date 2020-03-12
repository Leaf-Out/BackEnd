package eci.ieti.leafout.backend.service;

import eci.ieti.leafout.backend.model.Park;
import eci.ieti.leafout.backend.repository.LeafOutPersistenceException;

import java.util.List;

/**
 * This interface implements the basic methods of a Park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
public interface ParkService {

    /**
     * This method get all parks
     */

    List<Park> getAllParks() throws LeafOutPersistenceException;
    /**
     * This method save a park
     * @param park to save
     */
    void savePark(Park park) throws LeafOutPersistenceException;

    /**
     * This method get a park
     * @param park UUID of the park
     */

    Park findParkByName(UUID park) throws LeafOutPersistenceException;

    /**
     * This method update a park
     * @param park that gonna get an update
     */

    void updatePark(Park park);

    /**
     * This method get all plans of a park
     * @param park UUID of the park to take the plans
     */
    List<Plan> getListPlansByPark(UUID park);
    /**
     * This method get the ticket of a park
     * @param park UUID of the park
     */
    Integer getTicketCost(UUID park);

}
