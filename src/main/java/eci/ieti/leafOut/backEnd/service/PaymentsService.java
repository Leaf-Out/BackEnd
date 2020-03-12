package eci.ieti.leafout.backend.service;


import eci.ieti.leafout.backend.model.Purchase;
import eci.ieti.leafout.backend.model.Refund;
import eci.ieti.leafout.backend.model.Transaction;

import java.util.List;
import java.util.UUID;

/**
 * This class offers the basic CRUD methods of a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentsService {

    /**
     * This method creates a transaction request by product
     *
     * @param purchase Purchase object containing data needed to make a payment
     * @param user UUID of the client making a payment
     */
    void pay(Purchase purchase, UUID user);

    /**
     * This method makes a refund of a transaction
     *
     * @param refund Refund object with necessary data to make a refund
     */
    void refund(Refund refund);

    /**
     * This method returns all transactions made on the platform
     *
     * @return A list with all transactions
     */
    List<Transaction> getAllTransactions() ;

    /**
     * This method returns all transactions made by a customer
     *
     * @param user UUID of the customer
     * @return A list with the transactions of a customer
     */
    List<Transaction> getTransactionsByUser(UUID user) ;

    /**
     * This method returns a transaction given its ID
     *
     * @param id UUID of the transaction
     * @return An object of type Transaction
     */
    Transaction getTransactionById(UUID id);
}
