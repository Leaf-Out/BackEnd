package leafout.backend.model.exception;

import leafout.backend.model.PaymentResponseCode;

/**
 * This exception occurs when a transaction can not be refunded
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public class NotRefundableTransactionException extends Exception {
	public NotRefundableTransactionException(PaymentResponseCode state) {
		super("The transaction can not be refunded, the state is " + state.toString());
	}
	public NotRefundableTransactionException(String reason) {
		super("The transaction can not be refunded, reason: " + reason);
	}
}
