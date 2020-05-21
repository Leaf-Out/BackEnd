package leafout.backend.restclient;

import leafout.backend.model.PaymentResponse;
import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.User;
import leafout.backend.model.exception.PaymentPlatformException;

/**
 * This interface defines the methods a rest client should perform to make payments
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentProvider {

    /**
     * This method creates a post request to make a payment with payment platform
     *
     * @param purchase Object of type Purchase containing all data related to the payment
     * @param user     The user that is making the payment
     * @return PaymentResponse object with the result data of a payment request sent to a payment platform
     * @throws PaymentPlatformException I there is an error trying to make a request to a payment platform
     */
    PaymentResponse pay(final Purchase purchase, final User user) throws PaymentPlatformException;

	/**
	 * This method sends a post request to the payments platform, to refund a transaction before made
	 *
	 * @param refund Refund object containing all necessary data to refund a transaction
	 * @return PaymentResponse object with the result data of a refund request sent to a payment platform
	 * @throws PaymentPlatformException I there is an error trying to make a request to a payment platform
	 */
	PaymentResponse refund(final Refund refund) throws PaymentPlatformException;
}
