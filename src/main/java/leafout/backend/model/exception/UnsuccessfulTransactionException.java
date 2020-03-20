package leafout.backend.model.exception;

/**
 * This exception occurs when the transaction is not successful
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class UnsuccessfulTransactionException extends Exception {
	public UnsuccessfulTransactionException(String reason) {
		super("The transaction was unsuccessful, reason: " + reason);
	}
}
