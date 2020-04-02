package leafout.backend.persistence;


import leafout.backend.model.Park;


import leafout.backend.model.Population;
import leafout.backend.model.Tag;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * This class represent the repository of a Park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Repository
public interface ParkRepository extends MongoRepository<Park, String> {
    /**
     * find all Parks created
     * @return list<Park>
     */
    List<Park> findAll();

    List<Park> findAllByOrderByFeedbackDesc();
    /**
     * find an Park by id
     * @param parkName the di of Park
     * @return optional<Park>
     **/
    Optional<Park> getParkByName(String parkName);
    /**
     * find an Park by id
     * @param parkId the id of Park
     * @return optional<Park>
     **/
    Optional<Park> getParkById(String parkId);
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
    boolean existsParkById(String parkId);

    /**
     * if the Park exisist
     * @param parkName the id of Park
     * @return boolean
     */
    boolean existsParkByName(String parkName);


    List<Park> getAllByTagsContaining(List<Tag> tags);


    List<Park> getAllByLocation_Region(String region);

    List<Park> getAllByPricesLessThanEqual(Map<Population,Double> price);


}
