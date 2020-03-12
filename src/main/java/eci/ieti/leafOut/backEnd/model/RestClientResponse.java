package eci.ieti.leafout.backEnd.model;

import lombok.Builder;
import lombok.Getter;

/**
 * This class represents the response expected from a rest client
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
public class RestClientResponse {

	/**
	 * Response code of a transaction
	 */
	private PaymentResponse paymentResponse;

	/**
	 * Order ID of a transaction
	 */
	private int orderId;

	/**
	 * Transaction ID returned by the payment platform
	 */
	private String transactionId;

	/**
	 * Token returned by the payment platform
	 */
	private String token;

	/**
	 * Masked Card returned by the payment platform
	 */
	private String maskedCard;

}