package leafout.backend.model.exception;

/**
 * This exception occurs when there is an error trying to make a request to a payment platform
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class PaymentPlatformException extends Exception {
	public PaymentPlatformException(String message) {
		super("There was a problem trying to make a request to the payment platform, the problem was: " + message);
	}
}
