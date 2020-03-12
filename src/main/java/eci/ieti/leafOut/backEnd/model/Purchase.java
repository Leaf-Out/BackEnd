package eci.ieti.leafout.backEnd.model;

import lombok.*;

import java.util.List;

/**
 * This class represents a payment or checkout
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {

	/**
	 * The number of the credit card used in a payment
	 */
	private String cardNumber;

	/**
	 * CVV code of the credit card used in a payment
	 */
	private String securityCode;

	/**
	 * Expiration date of the credit card used in a payment
	 */
	private String expirationDate;

	/**
	 * Name of the cardholder
	 */
	private String name;

	/**
	 * Payment method used in a payment
	 */
	private PaymentMethod paymentMethod;

	/**
	 * List of products to be bought and the number of units
	 */
	private List<Plan> items;

}

