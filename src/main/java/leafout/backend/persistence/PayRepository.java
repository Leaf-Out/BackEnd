package leafout.backend.persistence;


import leafout.backend.model.Pay;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PayRepository extends MongoRepository<Pay, UUID> {

    List<Pay> getAllPays();

    Optional<Pay> getPayById(UUID parkId);

    Pay registerPay(Pay pay);

    void updatePay(Pay pay);

    boolean existsPayById(UUID payId);
}
