package eci.ieti.leafout.backend.repository;

import eci.ieti.leafout.backend.model.PaymentResponse;
import org.springframework.data.repository.CrudRepository;

/**
 * This interface defines the methods used to persist a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentsRepository extends CrudRepository<PaymentResponse, Integer> {

}
