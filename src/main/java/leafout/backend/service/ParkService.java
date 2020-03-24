package leafout.backend.service;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Park;


import java.util.List;
import java.util.UUID;

public interface ParkService <P extends Park> {
    /**
     * This method get all pays
     */
    List<P> getAllParks() ;

    /**
     * This method save a pay
     * @param park to save
     */
    void savePark(P park) throws LeafoutPersistenceException;

    /**
     * This method get a pay
     * @param parkId UUID of the pay
     */

    P getParkById(UUID parkId) ;

    /**
     * This method update a pay
     * @param park that gonna get an update pay
     */

    void updatePark(P park)  throws LeafoutPersistenceException;

    /**
     * This method remove  a pay
     * @param park UUID of the pay
     */
    void remove(P park) throws LeafoutPersistenceException;
}
