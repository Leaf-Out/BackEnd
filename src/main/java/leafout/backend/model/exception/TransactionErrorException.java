package leafout.backend.model.exception;

/**
 * This exception occurs when there is an error with the transaction
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class TransactionErrorException extends Exception {
	public TransactionErrorException(String reason) {
		super("There was an error with the transaction, reason: " + reason);
	}
}
