package eci.ieti.leafout.backend.restclient;

import eci.ieti.leafout.backend.model.exception.RestClientException;
import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.model.Purchase;
import eci.ieti.leafout.backend.model.Refund;
import eci.ieti.leafout.backend.model.RestClientResponse;
import eci.ieti.leafout.backend.model.Transaction;
import eci.ieti.leafout.backend.model.User;

/**
 * This interface defines the methods a payment rest client should perform
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentsRestClient {

	/**
	 * This method creates a post request to make a payment with payment platform
	 *
	 * @param purchase Object of type Purchase containing all data related to the payment
	 * @param product The product that is being bought
	 * @param customer The customer that is making the payment
	 * @param units Number of units of the product being payed
	 * @return RestClientResponse object with the result data of a payment request sent to a payment platform
	 * @throws RestClientException I there is an error trying to make a request to a payment platform
	 */
	RestClientResponse pay(final Purchase purchase, final Plan product, final User customer, final int units)
			throws RestClientException;

	/**
	 * This method sends a post request to the payments platform, to refund a transaction before made
	 *
	 * @param refund Refund object containing all necessary data to refund a transaction
	 * @return RestClientResponse object with the result data of a refund request sent to a payment platform
	 * @throws RestClientException I there is an error trying to make a request to a payment platform
	 */
	RestClientResponse refund(final Refund refund) throws RestClientException;

	/**
	 * This method checks the state of a transaction in the payments platform
	 *
	 * @param transaction Transaction object
	 * @return RestClientResponse object with the information about the new transaction state
	 * @throws RestClientException I there is an error trying to make a request to a payment platform
	 */
	RestClientResponse checkState(final Transaction transaction) throws RestClientException;
}
