package eci.ieti.leafOut.backEnd.persistence;


import eci.ieti.leafOut.backEnd.model.Park;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ParkRepository {

    List<Park> findAll();

    Optional<Park> findByName(String name);

    Park save(Park park);

}
