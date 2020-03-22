package leafout.backend.service;



import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;

import java.util.List;
import java.util.UUID;

/**
 * This interface represents all the services of a park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

public interface ParkServices {


    /**
     * This method get all parks
     */
    List<Pay> getAllParks() throws LeafoutPersistenceException;

    /**
     * This method save a park
     * @param park to save
     */
    void savePark(Pay park) throws LeafoutPersistenceException;

    /**
     * This method get a park
     * @param park UUID of the park
     */

    Pay findParkById(UUID park) throws LeafoutPersistenceException;

    /**
     * This method update a park
     * @param park that gonna get an update
     */

    void updatePark(Pay park);

    /**
     * This method get all plans of a park
     * @param park UUID of the park to take the plans
     */
    List<Pay> getListPlansByPark(UUID park);
    /**
     * This method get the ticket of a park
     * @param park UUID of the park
     */
    Integer getTicketCost(UUID park);

}
