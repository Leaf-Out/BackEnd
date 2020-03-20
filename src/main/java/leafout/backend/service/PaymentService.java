package leafout.backend.service;

import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.Transaction;
import leafout.backend.model.exception.PaymentPlatformException;

import java.util.List;
import java.util.UUID;

/**
 * This class offers the basic CRUD methods of a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentService {

	/**
	 * This method creates a transaction request by product
	 *
	 * @param purchase Purchase object containing data needed to make a payment
	 * @param user UUID of the user making a payment
	 * @throws PaymentPlatformException if there was a problem with the payment platform while doing the payment
	 */
	void pay(Purchase purchase, UUID user) throws PaymentPlatformException;

	/**
	 * This method makes a refund of a transaction
	 *
	 * @param refund Refund object with necessary data to make a refund
	 * @throws PaymentPlatformException if there was a problem with the payment platform while refunding a transaction
	 */
	void refund(Refund refund) throws PaymentPlatformException;

	/**
	 * This method returns all transactions made on the platform
	 *
	 * @return A list with all transactions
	 */
	List<Transaction> getAllTransactions();

	/**
	 * This method returns all transactions made by a customer
	 *
	 * @param user UUID of the user
	 * @return A list with the transactions of a customer
	 */
	List<Transaction> getTransactionsByUser(UUID user);

	/**
	 * This method returns a transaction given its ID
	 *
	 * @param id UUID of the transaction
	 * @return An object of type Transaction
	 */
	Transaction getTransactionById(UUID id);
}
