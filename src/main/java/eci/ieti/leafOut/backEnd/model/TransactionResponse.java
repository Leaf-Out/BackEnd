package eci.ieti.leafout.backend.model;

/**
 * This class defines all valid transaction response types for the business
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public enum TransactionResponse {
	SUCCESSFUL_TRANSACTION,
	PENDING_TRANSACTION,
	UNSUCCESSFUL_TRANSACTION,
	TRANSACTION_ERROR,
	REFUNDED
}
