package leafout.backend.persistence;


import leafout.backend.model.Park;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ParkRepository extends MongoRepository<Park, UUID> {

    List<Park> getAllParks();

    Optional<Park> getParkById(UUID parkId);

    Park registerPark(Park pay);

    void updatePark(Park pay);

    boolean existsParkById(UUID parkId);
}
