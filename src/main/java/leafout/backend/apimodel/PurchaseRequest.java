package leafout.backend.apimodel;

import leafout.backend.model.PaymentMethod;
import leafout.backend.model.Population;
import leafout.backend.model.Ticket;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

/**
 * This class represents a payment request
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PurchaseRequest {

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
	 * The document of the cardholder
	 */
	private String dni;

	/**
	 * Payment method used in a payment
	 */
	private PaymentMethod paymentMethod;

	/**
	 * Units of the product to be bought
	 */
	private int units;

	/**
	 * Segment being payed
	 */
	private Population population;

	/**
	 * Type of payable being payed
	 */
	private PayRequest pay;

	/**
	 * ID of the payable
	 */
	private UUID payId;

}
