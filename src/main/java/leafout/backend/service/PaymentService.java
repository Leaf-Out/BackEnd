package leafout.backend.service;

import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.Transaction;
import leafout.backend.model.exception.NoPayableFoundException;
import leafout.backend.model.exception.NoTransactionFoundException;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.NotRefundableTransactionException;
import leafout.backend.model.exception.TransactionErrorException;
import leafout.backend.model.exception.PaymentPlatformException;
import leafout.backend.model.exception.UnsuccessfulTransactionException;

import java.util.List;


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
	 * @throws NoPayableFoundException if the park, plan or activity being payed does not exist
	 * @throws NoUserFoundException if the user paying does not exist
	 * @throws TransactionErrorException When the transaction results in an error
	 * @throws UnsuccessfulTransactionException When the transaction is unsuccessful
	 */
	void pay(Purchase purchase, String user) throws PaymentPlatformException, NoPayableFoundException,
												  NoUserFoundException, TransactionErrorException,
												  UnsuccessfulTransactionException;

	/**
	 * This method makes a refund of a transaction
	 *
	 * @param refund Refund object with necessary data to make a refund
	 * @throws PaymentPlatformException if there was a problem with the payment platform while refunding a transaction
	 * @throws UnsuccessfulTransactionException When the transaction is unsuccessful
	 * @throws NotRefundableTransactionException When the transaction state can not be refunded due to a previous state
	 * @throws NoTransactionFoundException if the transaction being refunded does not exist
	 */
	void refund(Refund refund)
			throws PaymentPlatformException, UnsuccessfulTransactionException, NotRefundableTransactionException,
				   NoTransactionFoundException;

	/**
	 * This method returns all transactions made on the platform
	 *
	 * @return A list with all transactions
	 */
	List<Transaction> getAllTransactions();

	/**
	 * This method returns all transactions made by a user
	 *
	 * @param user UUID of the user
	 * @return A list with the transactions of a user
	 */
	List<Transaction> getTransactionsByUser(String user) throws NoUserFoundException;

	/**
	 * This method returns a transaction given its ID
	 *
	 * @param id UUID of the transaction
	 * @return An object of type Transaction
	 */
	Transaction getTransactionById(String id);
}
