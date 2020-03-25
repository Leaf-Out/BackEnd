package leafout.backend.apimodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
public class RefundRequest {

	/**
	 * UUID of the transaction to be refunded
	 */
	private String transactionId;

	/**
	 * Reason why the customer wants the transaction refund
	 */
	private String reason;
}