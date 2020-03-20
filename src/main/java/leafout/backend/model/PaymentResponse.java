package leafout.backend.model;

import lombok.Builder;
import lombok.Getter;

/**
 * This class represents a payment platform response
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
public class PaymentResponse {

	/**
	 * Response of a transaction
	 */
	private PaymentResult paymentResult;

	/**
	 * Order ID of a transaction
	 */
	private int orderId;

	/**
	 * Transaction ID returned by the payment platform
	 */
	private String transactionId;

}
