package eci.ieti.leafout.backEnd.persistence;


import eci.ieti.leafout.backEnd.model.Park;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This interface defines the methods used to persist Park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */

@Repository
public interface ParkRepository {

    List<Park> getAllParks();

    Optional<Park> getParkByName(String name);

    Park registerPark(Park park);

    void updatePark(Park park);


}
