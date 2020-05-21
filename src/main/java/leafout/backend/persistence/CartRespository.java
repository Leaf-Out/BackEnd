package leafout.backend.persistence;

import leafout.backend.model.Cart;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRespository extends MongoRepository<Cart, String> {
}
