package leafout.backend.apimodel;

import leafout.backend.model.PaymentMethod;
import lombok.*;

import java.util.Date;

/**
 * This class represents a transaction for the client
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse {

    /**
     * ID of the transaction
     */
    private String id;

	/**
	 * Date when the transaction was first made
	 */
	private Date date;

	/**
	 * Date when the state of the transaction changed, if it did
	 */
	private Date updateDate;

	/**
	 * The state in which the transaction is
	 */
	private ApiPaymentResponseCode state;

	/**
	 * Payment method used to make a payment
	 */
	private PaymentMethod paymentMethod;

	/**
	 * The ticket payed
	 */
	private TicketResponse ticket;

}
