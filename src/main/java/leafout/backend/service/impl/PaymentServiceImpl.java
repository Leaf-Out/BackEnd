package leafout.backend.service.impl;

import leafout.backend.model.Activity;
import leafout.backend.model.Park;
import leafout.backend.model.PaymentResponse;
import leafout.backend.model.PaymentResponseCode;
import leafout.backend.model.Plan;
import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.Ticket;
import leafout.backend.model.Transaction;
import leafout.backend.model.User;
import leafout.backend.model.exception.PaymentPlatformException;
import leafout.backend.restclient.PaymentRestClient;
import leafout.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * This class implements the basic CRUD methods of a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	/**
	 * Injected UserServices object
	 */
	//@Autowired
	//private UserServices userServices;

	/**
	 * Injected ParkServices object
	 */
	//@Autowired
	//private ParkServices parkServices;

	/**
	 * Injected PlanServices object
	 */
	//@Autowired
	//private PlanServices planServices;

	/**
	 * Injected ActivityServices object
	 */
	//@Autowired
	//private ActivityServices activityServices;

	/**
	 * Injected ShippingCartServices object
	 */
	//@Autowired
	//private ShoppingCartServices shoppingCartServices;

	/**
	 * Injected PaymentPersistence object
	 */
	//@Autowired
	//private PaymentPersistence paymentPersistence;

	/**
	 * Injected PaymentRestClient object
	 */
	@Autowired
	private PaymentRestClient restClient;

	@Override public void pay(Purchase purchase, UUID userId) throws PaymentPlatformException {
		/*final User user = userServices.getUserById(userId);
		if (user != null) {
			final Park park = parkServices.getParkById(purchase.getTicket().getPaying().getId());
			final Plan plan = planServices.getPlanById(purchase.getTicket().getPaying().getId());
			final Activity activity = activityServices.getActivityById(purchase.getTicket().getPaying().getId());
			if (park != null || plan != null || activity != null) {
				final PaymentResponse paymentResponse = restClient.pay(purchase, user);
				paymentProcess(paymentResponse,purchase,user);
			} else {
				//TODO throw no payable exception
			}
		} else {
			//TODO throw no customer exception
		}*/
	}

	/**
	 * This method registers a transaction and modifies customer's shopping cart and product stock if its needed
	 *
	 * @param response Response given by the payments platform
	 * @param purchase The purchase being made
	 * @param user The user paying
	 */
	private void paymentProcess(PaymentResponse response, Purchase purchase, User user) {
		final Transaction transaction = Transaction.builder()
												   .id(UUID.fromString(response.getTransactionId()))
												   .orderId(response.getOrderId())
												   .date(new Date(Calendar.getInstance().getTime().getTime()))
												   .paymentMethod(purchase.getPaymentMethod())
												   .state(response.getPaymentResult().getPaymentResponseCode())
												   .ticket(purchase.getTicket())
												   .build();
		//TODO register transaction
		if (PaymentResponseCode.TRANSACTION_ERROR.equals(response.getPaymentResult().getPaymentResponseCode())) {
			//TODO throw payment error exception
		} else if (PaymentResponseCode.UNSUCCESSFUL_TRANSACTION.equals(response.getPaymentResult().getPaymentResponseCode())) {
			//TODO throw unsuccessful payment exception
		} else {
			if (PaymentResponseCode.SUCCESSFUL_TRANSACTION.equals(response.getPaymentResult().getPaymentResponseCode())) {
				//TODO remove ticket from the shopping cart
			}
		}
	}

	@Override public void refund(Refund refund) throws PaymentPlatformException {
		Transaction transaction = getTransactionById(refund.getTransactionId());
		if (transaction != null) {
			if (PaymentResponseCode.SUCCESSFUL_TRANSACTION.equals(transaction.getState())) {
				final PaymentResponse paymentResponse = restClient.refund(refund);
				if (PaymentResponseCode.SUCCESSFUL_TRANSACTION
						.equals(paymentResponse.getPaymentResult().getPaymentResponseCode())) {
					//TODO update transaction state
				} else {
					//TODO throw unsuccessful refund exception
				}
			} else {
				//TODO throw not refundable transaction state exception
			}
		} else {
			//TODO throw no transaction exception
		}
	}

	@Override public List<Transaction> getAllTransactions() {

		return null;
	}

	@Override public List<Transaction> getTransactionsByUser(UUID user) {

		return null;
	}

	@Override public Transaction getTransactionById(UUID id) {

		return null;
	}
}
