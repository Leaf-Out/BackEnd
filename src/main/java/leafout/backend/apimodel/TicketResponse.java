package leafout.backend.apimodel;


import leafout.backend.model.Population;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

/**
 * This class represents a ticket to the client
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TicketResponse {
	/**
	 * ID of the ticket to be payed
	 */
	private String id;

	/**
	 * Date when the ticket starts being valid
	 */
	private Date date;

	/**
	 * Date when the ticket expires
	 */
	private Date expirationDate;

	/**
	 * Units of the product to be bought
	 */
	private int units;

	/**
	 * Segment being payed
	 */
	private Population population;

	/**
	 * Total price of the ticket
	 */
	private double totalPrice;

	/**
	 * Product payed
	 */
	private String name;

}
