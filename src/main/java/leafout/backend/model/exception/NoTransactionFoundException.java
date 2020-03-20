package leafout.backend.model.exception;

import java.util.UUID;

/**
 * This exception occurs when a no existent transaction is trying to be consulted
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class NoTransactionFoundException extends Exception {
	public NoTransactionFoundException(UUID transaction) {
		super("There is no transaction with the ID " + transaction);
	}
}
