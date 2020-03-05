package eci.ieti.leafout.backend.service;

/**
 * This class offers the basic CRUD methods of a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentsService {

    void getAllTransactions();
    void pay();
    void refund();
    void getTransactionsByUserId();
    void getTransactionById();
}
