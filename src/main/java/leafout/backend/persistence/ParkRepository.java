package leafout.backend.persistence;


import leafout.backend.model.Park;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
/**
 * This class represent the repository of a Park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Repository
public interface ParkRepository extends MongoRepository<Park, UUID> {
    /**
     * find all Parks created
     * @return list<Park>
     */
    List<Park> findAll();
    /**
     * find an Park by id
     * @param parkId the di of Park
     * @return optional<Park>
     **/
    Optional<Park> getParkById(UUID parkId);
    /**
     * Save a Park
     * @param park the Park would be save
     * @return Park
     */
    Park save(Park park);

    /**
     * if the Park exisist
     * @param parkId the id of Park
     * @return boolean
     */
    boolean existsParkById(UUID parkId);
}
