package eci.ieti.leafout.backEnd.persistence;

/**
 * This interface defines the methods used to persist a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentsPersistence {

	void registerTransaction();
	void getAllTransactions();
	void getTransactionsByUserId();
	void getTransactionById();
	void updateTransaction();

}
