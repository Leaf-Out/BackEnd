package leafout.backend.service.impl;

import leafout.backend.model.*;
import leafout.backend.model.exception.NoPayableFoundException;
import leafout.backend.model.exception.NoTransactionFoundException;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.NotRefundableTransactionException;
import leafout.backend.model.exception.TransactionErrorException;
import leafout.backend.model.exception.PaymentPlatformException;
import leafout.backend.model.exception.UnsuccessfulTransactionException;
import leafout.backend.restclient.PaymentRestClient;
import leafout.backend.service.ActivityService;
import leafout.backend.service.ParkService;
import leafout.backend.service.PaymentService;
import leafout.backend.service.PlanService;
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
	@Autowired
	private ParkService parkService;

	/**
	 * Injected PlanServices object
	 */
	@Autowired
	private PlanService planService;

	/**
	 * Injected ActivityServices object
	 */
	@Autowired
	private ActivityService activityService;

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

	@Override public void pay(Purchase purchase, UUID userId) throws PaymentPlatformException, NoPayableFoundException, NoUserFoundException, UnsuccessfulTransactionException, TransactionErrorException {
		/**final User user = userServices.getUserById(userId);
		if (user != null) {
			final Park park = parkService.getParkById(purchase.getTicket().getPaying().getId());
			final Plan plan = planService.getPlanById(purchase.getTicket().getPaying().getId());
			final Activity activity = activityService.getActivityById(purchase.getTicket().getPaying().getId());
			if (park != null || plan != null || activity != null) {
				final PaymentResponse paymentResponse = restClient.pay(purchase, user);
				paymentProcess(paymentResponse,purchase,user);
			} else {
				throw new NoPayableFoundException(purchase.getTicket().getPaying().getId());
			}
		} else {
			throw new NoUserFoundException(userId);
		}*/
	}

	/**
	 * This method registers a transaction and modifies customer's shopping cart and product stock if its needed
	 *
	 * @param response Response given by the payments platform
	 * @param purchase The purchase being made
	 * @param user The user paying
	 * @throws TransactionErrorException When the transaction results in an error
	 * @throws UnsuccessfulTransactionException When the transaction is unsuccessful
	 */
	private void paymentProcess(PaymentResponse response, Purchase purchase, User user)
			throws TransactionErrorException, UnsuccessfulTransactionException {
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
			throw new TransactionErrorException(response.getPaymentResult().getReason());
		} else if (PaymentResponseCode.UNSUCCESSFUL_TRANSACTION.equals(response.getPaymentResult().getPaymentResponseCode())) {
			throw new UnsuccessfulTransactionException(response.getPaymentResult().getReason());
		} else {
			if (PaymentResponseCode.SUCCESSFUL_TRANSACTION.equals(response.getPaymentResult().getPaymentResponseCode())) {
				//TODO remove ticket from the shopping cart
			}
		}
	}

	@Override public void refund(final Refund refund)
			throws PaymentPlatformException, UnsuccessfulTransactionException, NotRefundableTransactionException,
				   NoTransactionFoundException {
		Transaction transaction = getTransactionById(refund.getTransactionId());
		if (transaction != null) {
			if (PaymentResponseCode.SUCCESSFUL_TRANSACTION.equals(transaction.getState())) {
				refund.setOrderId(transaction.getOrderId());
				final PaymentResponse paymentResponse = restClient.refund(refund);
				if (PaymentResponseCode.SUCCESSFUL_TRANSACTION
						.equals(paymentResponse.getPaymentResult().getPaymentResponseCode())) {
					//TODO update transaction state
				} else {
					throw new UnsuccessfulTransactionException(paymentResponse.getPaymentResult().getReason());
				}
			} else {
				throw new NotRefundableTransactionException(transaction.getState());
			}
		} else {
			throw new NoTransactionFoundException(refund.getTransactionId());
		}
	}

	@Override public List<Transaction> getAllTransactions() {
		//TODO get transactions
		return null;
	}

	@Override public List<Transaction> getTransactionsByUser(UUID user) {
		//TODO get transactions
		return null;
	}

	@Override public Transaction getTransactionById(UUID id) {
		//TODO get transaction
		return null;
	}
}
