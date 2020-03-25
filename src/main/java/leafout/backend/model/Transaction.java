package leafout.backend.model;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.UUID;

/**
 * This class represents a transaction in the business
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "Transactions")
@JsonTypeName("Plan")
public class Transaction {

	/**
	 * ID of the transaction generated by the payments platform
	 */
	private String id;

	/**
	 * Order ID generated by the payments platform
	 */
	private int orderId;

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
	private PaymentResponseCode state;

	/**
	 * Payment method used to make a payment
	 */
	private PaymentMethod paymentMethod;

	/**
	 * The ticket being payed
	 */
	private Ticket ticket;

	/**
	 * the user of the ticket
	 */
	private User user;

}
