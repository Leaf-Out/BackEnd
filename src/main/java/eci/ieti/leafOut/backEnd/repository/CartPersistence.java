package eci.ieti.leafout.backend.repository;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import eci.ieti.leafout.backend.apimodel.Cart;

/**
 * CartPersistense
 */
@Repository
public interface CartPersistence extends CrudRepository<Cart, UUID>{

    
}