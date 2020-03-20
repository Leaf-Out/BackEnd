package leafout.backend.model.exception;

import java.util.UUID;

/**
 * This exception occurs when a no existent user is trying to be consulted
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class NoUserFoundException extends Exception {
	public NoUserFoundException(UUID user) {
		super("There is no user with the ID " + user);
	}
	public NoUserFoundException(String user) {
		super("There is no user with the email " + user);
	}
}
