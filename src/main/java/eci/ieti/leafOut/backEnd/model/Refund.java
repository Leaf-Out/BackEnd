package eci.ieti.leafout.backEnd.model;

import lombok.*;

import java.util.UUID;

/**
 * This class contains all data needed to create a refund request
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Refund {

	/**
	 * UUID of the transaction to be refunded
	 */
	private UUID transactionId;

	/**
	 * ID of the order to be refunded
	 */
	private int orderId;

	/**
	 * Reason why the customer wants the transaction refund
	 */
	private String reason;
}