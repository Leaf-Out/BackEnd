package leafout.backend.apimodel;

/**
 * This class defines all valid transaction states for the client
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public enum ApiPaymentResponseCode {
	SUCCESSFUL,
	UNSUCCESSFUL,
	REFUNDED,
	PENDING
}
