package leafout.backend.model.exception;

import java.util.UUID;

/**
 * This exception occurs when a no existent park, plan or activity is trying to be consulted
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class NoPayableFoundException extends Exception {
	public NoPayableFoundException(UUID payable) {
		super("There is no park, plan or activity with the ID " + payable);
	}
}
