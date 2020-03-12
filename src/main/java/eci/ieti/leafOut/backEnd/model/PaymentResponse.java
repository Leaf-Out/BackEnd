package eci.ieti.leafout.backEnd.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * This class is contains the response of a transaction and the reason behind that response
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
public class PaymentResponse {

	/**
	 * Transaction response code inside the business
	 */
	TransactionResponse transactionResponse;

	/**
	 * Reason given by the payment platform
	 */
	String reason;
}