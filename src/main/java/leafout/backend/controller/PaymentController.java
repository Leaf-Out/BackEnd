package leafout.backend.controller;

import leafout.backend.apimodel.ApiPaymentResponseCode;
import leafout.backend.apimodel.PayRequest;
import leafout.backend.apimodel.PurchaseRequest;
import leafout.backend.apimodel.RefundRequest;
import leafout.backend.apimodel.TicketResponse;
import leafout.backend.apimodel.TransactionResponse;
import leafout.backend.model.Activity;
import leafout.backend.model.Park;
import leafout.backend.model.Pay;
import leafout.backend.model.PaymentResponseCode;
import leafout.backend.model.Plan;
import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.Ticket;
import leafout.backend.model.Transaction;
import leafout.backend.model.exception.NoPayableFoundException;
import leafout.backend.model.exception.NoTransactionFoundException;
import leafout.backend.model.exception.NoUserFoundException;
import leafout.backend.model.exception.NotRefundableTransactionException;
import leafout.backend.model.exception.PaymentPlatformException;
import leafout.backend.model.exception.TransactionErrorException;
import leafout.backend.model.exception.UnsuccessfulTransactionException;
import leafout.backend.service.ActivityService;
import leafout.backend.service.ParkService;
import leafout.backend.service.PaymentService;
import leafout.backend.service.PlanService;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

/**
 * This interface offers all payment API endpoints
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

	/**
	 * PaymentService injected object
	 */
	@Autowired
	private PaymentService paymentService;

	/**
	 * ParckService injected object
	 */
	@Autowired
	private ParkService parkService;

	/**
	 * PlanService injected object
	 */
	@Autowired
	private PlanService planService;

	/**
	 * ActivityService injected object
	 */
	@Autowired
	private ActivityService activityService;

	/**
	 * This method returns all transactions made
	 *
	 * @return A list of transactions
	 */
	@GetMapping
	public ResponseEntity<List<TransactionResponse>> getAllTransactions() {
		final ResponseEntity response;
			response = new ResponseEntity<>(mapTransactionsResponse(paymentService.getAllTransactions()), HttpStatus.ACCEPTED);
		return response;
	}

	/**
	 * This method returns all transactions made by a user
	 *
	 * @param userEmail UUID of the user
	 * @return A list of transactions
	 */
	@GetMapping("/user/{email}")
	public ResponseEntity<List<TransactionResponse>> getTransactionsByCustomer(final @PathVariable("email") String userEmail) throws NoUserFoundException {
		final ResponseEntity response;
			response = new ResponseEntity<>(mapTransactionsResponse(paymentService.getTransactionsByUser(userEmail)), HttpStatus.ACCEPTED);

		return response;
	}

	/**
	 * This method returns a transaction given its ID
	 *
	 * @param id UUID of the transaction
	 * @return A list of transactions
	 */
	@GetMapping("/id/{id}")
	public ResponseEntity<TransactionResponse> getTransactionById(final @PathVariable("id") String id) {
		final ResponseEntity response;
			final TransactionResponse transaction = mapTransactionResponse(paymentService.getTransactionById(id));
			response = new ResponseEntity<>(transaction, HttpStatus.ACCEPTED);

		return response;
	}

	/**
	 * This method makes a payment with the data received
	 *
	 * @param user UUID of the user
	 * @param purchase Purchase request object with the necessary information to make a payment
	 * @return HTTP Response
	 */
	@PostMapping("/pay/user/{user}")
	public ResponseEntity<HttpStatus> pay(final @RequestBody PurchaseRequest purchase, final @PathVariable("user") String user) {

		try {
			paymentService.pay(mapPurchase(purchase), user);
		} catch (PaymentPlatformException e) {
			e.printStackTrace();
		} catch (NoPayableFoundException e) {
			e.printStackTrace();
		} catch (NoUserFoundException e) {
			e.printStackTrace();
		} catch (TransactionErrorException e) {
			e.printStackTrace();
		} catch (UnsuccessfulTransactionException e) {
			e.printStackTrace();
		}
		final ResponseEntity response = new ResponseEntity<>(HttpStatus.ACCEPTED);
		return response;
	}



	/**
	 * This method makes a refund of a transaction
	 *
	 * @param refund Refund request object with the necessary information to refund a transaction
	 * @return HTTP Response
	 */
	@PostMapping("/refund")
	public ResponseEntity<HttpStatus> refund(final @RequestBody RefundRequest refund) {
		try {
			paymentService.refund(mapRefund(refund));
		} catch (PaymentPlatformException e) {
			e.printStackTrace();
		} catch (UnsuccessfulTransactionException e) {
			e.printStackTrace();
		} catch (NotRefundableTransactionException e) {
			e.printStackTrace();
		} catch (NoTransactionFoundException e) {
			e.printStackTrace();
		}
		final ResponseEntity response = new ResponseEntity<>(HttpStatus.ACCEPTED);
		return response;
	}

	/**
	 * This method transforms a Rest purchase object into the business purchase object
	 *
	 * @param purchaseRequest Rest purchase object to be transformed
	 * @return A Purchase objectx
	 */
	private Purchase mapPurchase(final PurchaseRequest purchaseRequest) {
		Purchase purchase = Purchase.builder()
									.cardNumber(purchaseRequest.getCardNumber())
									.dni(purchaseRequest.getDni())
									.expirationDate(purchaseRequest.getExpirationDate())
									.name(purchaseRequest.getName())
									.paymentMethod(purchaseRequest.getPaymentMethod())
									.securityCode(purchaseRequest.getSecurityCode())
									.ticket(generateTicket(purchaseRequest))
									.build();
		return purchase;
	}

	/**
	 * This method generates a ticket with the information provided
	 *
	 * @param purchaseRequest Rest purchase object with necessary information to create a ticket
	 * @return The ticket generated
	 */
	@SneakyThrows
	private Ticket generateTicket(final PurchaseRequest purchaseRequest) {
		final Pay pay;
		System.err.println(purchaseRequest.getPay());
		System.err.println(PayRequest.PLAN.toString().equals(purchaseRequest.getPay().toString()));
		if (PayRequest.PARK.toString().equals(purchaseRequest.getPay().toString())) {
			pay = parkService.getParkById(purchaseRequest.getPayId());
		} else if (PayRequest.PLAN.toString().equals(purchaseRequest.getPay().toString())) {
			pay = planService.getPlanById(purchaseRequest.getPayId());
		} else {
			pay = activityService.getActivityById(purchaseRequest.getPayId());
		}
		final double totalPrice = purchaseRequest.getUnits() * pay.getPrices().get(purchaseRequest.getPopulation());
		final Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, 3);
		final Date expirationDate = new Date(calendar.getTime().getTime());
		return Ticket.builder()
					 .id(UUID.randomUUID().toString())
					 .population(purchaseRequest.getPopulation())
					 .units(purchaseRequest.getUnits())
					 .totalPrice(totalPrice)
					 .date(new Date(Calendar.getInstance().getTime().getTime()))
					 .expirationDate(expirationDate)
					 .paying(pay)
					 .build();
	}

	/**
	 * Maps a refund request into a refund understood by the business
	 *
	 * @param refundRequest Refund request made by the client
	 * @return Refund object state understood by the business
	 */
	private Refund mapRefund(final RefundRequest refundRequest) {
		final Refund refund = Refund.builder()
							  .transactionId(refundRequest.getTransactionId())
							  .reason(refundRequest.getReason())
							  .build();
		return refund;
	}

	/**
	 * This method transforms a list of transactions into a client oriented transaction list
	 *
	 * @param allTransactions Transaction object list
	 * @return TransactionResponse object list
	 */
	private List<TransactionResponse> mapTransactionsResponse(final List<Transaction> allTransactions) {
		final List<TransactionResponse> transactions= new ArrayList<>();
		for (Transaction transaction: allTransactions) {
			transactions.add(
					TransactionResponse.builder()
									   .id(transaction.getId())
									   .date(transaction.getDate())
									   .updateDate(transaction.getUpdateDate())
									   .state(mapPaymentResponseCode(transaction.getState()))
									   .paymentMethod(transaction.getPaymentMethod())
									   .ticket(mapTicket(transaction.getTicket()))
									   .build()
							);
		}
		return transactions;
	}

	/**
	 * This method transforms a transaction into a client oriented transaction
	 *
	 * @param transaction Transaction object
	 * @return TransactionResponse object
	 */
	private TransactionResponse mapTransactionResponse(final Transaction transaction) {
		final TransactionResponse mappedTransaction = TransactionResponse.builder()
																   	.id(transaction.getId())
																   	.date(transaction.getDate())
																   	.updateDate(transaction.getUpdateDate())
																   	.state(mapPaymentResponseCode(transaction.getState()))
																   	.paymentMethod(transaction.getPaymentMethod())
																   	.ticket(mapTicket(transaction.getTicket()))
																   	.build();
		return mappedTransaction;
	}

	/**
	 * Maps a ticker into client oriented ticket
	 *
	 * @param ticket Ticket object understood by the business
	 * @return Ticket object state understood by the client
	 */
	private TicketResponse mapTicket(final Ticket ticket) {
		final TicketResponse mappedTicked = TicketResponse.builder()
														  .id(ticket.getId())
														  .date(ticket.getDate())
														  .expirationDate(ticket.getExpirationDate())
														  .population(ticket.getPopulation())
														  .totalPrice(ticket.getTotalPrice())
														  .units(ticket.getUnits())
														  .name(ticket.getPaying().getName())
														  .build();
		return mappedTicked;
	}

	/**
	 * Maps a transaction state into client oriented transaction state
	 *
	 * @param paymentResponseCode Transaction state understood by the business
	 * @return Transaction state understood by the client
	 */
	private ApiPaymentResponseCode mapPaymentResponseCode(final PaymentResponseCode paymentResponseCode) {
		if (PaymentResponseCode.SUCCESSFUL_TRANSACTION.equals(paymentResponseCode)) {
			return ApiPaymentResponseCode.SUCCESSFUL;
		} else if (PaymentResponseCode.REFUNDED.equals(paymentResponseCode)) {
			return ApiPaymentResponseCode.REFUNDED;
		} else if (PaymentResponseCode.PENDING_TRANSACTION.equals(paymentResponseCode)) {
			return ApiPaymentResponseCode.PENDING;
		} else {
			return ApiPaymentResponseCode.UNSUCCESSFUL;
		}
	}


}