package leafout.backend.controller;

import leafout.backend.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This interface offers all payment API endpoints
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@RestController
@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	/**
	 * This method returns all transactions made
	 *
	 * @return A list of transactions
	 * @throws DatabaseException If occurs a problem related to the database
	 * @throws RestIntegrationException If occurs a problem related to the payment platform
	 */
	/*@GetMapping
	public ResponseEntity<List<ApiTransactionResponse>> getAllTransactions() throws DatabaseException, RestIntegrationException {
		final ResponseEntity response;
		try {
			response = new ResponseEntity<>(mapTransactionsResponse(paymentServices.getAllTransactions()), HttpStatus.ACCEPTED);
		} catch (RestClientException e) {
			throw new RestIntegrationException();
		} catch (DatabaseConnectionException e) {
			throw new DatabaseException();
		} catch (DatabaseQueryException e) {
			throw new DatabaseException();
		}
		return response;
	}/*

	/**
	 * This method returns all transactions made by a customer
	 *
	 * @param customer UUID of the customer
	 * @return A list of transactions
	 * @throws DatabaseException If occurs a problem related to the database
	 * @throws RestIntegrationException If occurs a problem related to the payment platform
	 * @throws CrudException If there is a problem getting the transactions of a customer
	 */
	/*@GetMapping("/customer/{id}")
	public ResponseEntity<List<ApiTransactionResponse>> getTransactionsByCustomer(@PathVariable("id") UUID customer)
			throws CrudException, DatabaseException, RestIntegrationException {
		final ResponseEntity response;
		try {
			response = new ResponseEntity<>(mapTransactionsResponse(paymentServices.getTransactionsByCustomer(customer)), HttpStatus.ACCEPTED);
		} catch (NoCustomerFoundException e) {
			throw new CrudException(e.getMessage());
		} catch (DatabaseConnectionException e) {
			throw new DatabaseException();
		} catch (RestClientException e) {
			throw new RestIntegrationException();
		} catch (DatabaseQueryException e) {
			throw new DatabaseException();
		}
		return response;
	}*/

	/**
	 * This method returns a transaction given its ID
	 *
	 * @param id UUID of the transaction
	 * @return A list of transactions
	 * @throws DatabaseException If occurs a problem related to the database
	 * @throws RestIntegrationException If occurs a problem related to the payment platform
	 * @throws CrudException If there is a problem getting a transactions
	 */
	/*@GetMapping("/id/{id}")
	public ResponseEntity<ApiTransactionResponse> getTransactionById(@PathVariable("id") UUID id)
			throws DatabaseException, CrudException, RestIntegrationException {
		final ResponseEntity response;
		try {
			final ApiTransactionResponse transaction = mapTransactionResponse(paymentServices.getTransactionById(id));
			response = new ResponseEntity<>(transaction, HttpStatus.ACCEPTED);
		} catch (DatabaseConnectionException e) {
			throw new DatabaseException();
		} catch (NoTransactionFoundException e) {
			throw new CrudException(e.getMessage());
		} catch (RestClientException e) {
			throw new RestIntegrationException();
		} catch (DatabaseQueryException e) {
			throw new DatabaseException();
		}
		return response;
	}*/

	/**
	 * This method makes a payment with the data received
	 *
	 * @param customer UUID of the customer
	 * @return HTTP Response
	 * @throws CrudException If there is a problem with the customer or products during the payment process
	 * @throws DatabaseException If occurs a problem related to the database
	 * @throws PaymentFailureException If the payment could not be done
	 */
	/*@PostMapping("/pay/id/{customer}")
	public ResponseEntity<HttpStatus> pay(@RequestBody ApiPurchase purchase, @PathVariable("customer") UUID customer)
			throws CrudException, DatabaseException, PaymentFailureException {
		final ResponseEntity response;
		try {
			paymentServices.pay(mapPurchase(purchase), customer);
			response = new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (NoProductFoundException e) {
			throw new CrudException(e.getMessage());
		} catch (NoCustomerFoundException e) {
			throw new CrudException(e.getMessage());
		} catch (DatabaseConnectionException e) {
			throw new DatabaseException();
		} catch (NoStockException e) {
			throw new PaymentFailureException(e.getMessage());
		} catch (FailedPaymentsException e) {
			throw new PaymentFailureException(e.getMessage());
		} catch (DatabaseQueryException e) {
			throw new DatabaseException();
		}
		return response;
	}*/



	/**
	 * This method makes a refund of a transaction
	 *
	 * @param refund ApiRefund object with the necessary information to refund a transaction
	 * @return HTTP Response
	 * @throws CrudException If there is a problem with the customer or products during the refund process
	 * @throws DatabaseException If occurs a problem related to the database
	 * @throws PaymentFailureException If the refund could not be done
	 * @throws RestIntegrationException If occurs a problem related to the payment platform
	 */
	/*@PostMapping("/refund")
	public ResponseEntity<HttpStatus> refund(@RequestBody ApiRefund refund)
			throws CrudException, PaymentFailureException, DatabaseException, RestIntegrationException {
		final ResponseEntity response;
		try {
			paymentServices.refund(mapRefund(refund));
			response = new ResponseEntity<>(HttpStatus.ACCEPTED);
		} catch (NoProductFoundException e) {
			throw new CrudException(e.getMessage());
		} catch (RefundException e) {
			throw new PaymentFailureException(e.getMessage());
		} catch (DatabaseConnectionException e) {
			throw new DatabaseException();
		} catch (RestClientException e) {
			throw new RestIntegrationException();
		} catch (DatabaseQueryException e) {
			throw new DatabaseException();
		}
		return response;
	}*/

	/**
	 * This method transforms a Rest purchase object into the business purchase object
	 *
	 * @param apiPurchase Rest purchase object to be transformed
	 * @return A Purchase object
	 */
	/*private Purchase mapPurchase(final ApiPurchase apiPurchase) {
		Purchase purchase = Purchase.builder()
									.cardNumber(apiPurchase.getCardNumber())
									.expirationDate(apiPurchase.getExpirationDate())
									.name(apiPurchase.getName())
									.paymentMethod(apiPurchase.getPaymentMethod())
									.securityCode(apiPurchase.getSecurityCode())
									.items(mapItems(apiPurchase.getItems()))
									.build();
		return purchase;
	}*/

	/**
	 * This method transforms a Rest token purchase object into the business token purchase object
	 *
	 * @param apiPurchase Rest token purchase object to be transformed
	 * @return A TokenPurchase object
	 */
	/*private TokenPurchase mapPurchase(final ApiTokenPurchase apiPurchase) {
		TokenPurchase purchase = TokenPurchase.builder()
											  .tokenId(apiPurchase.getTokenId())
											  .paymentMethod(apiPurchase.getPaymentMethod())
											  .items(mapItems(apiPurchase.getItems()))
											  .build();
		return purchase;
	}*/

	/**
	 * This method transforms a Rest item object list into a business item object list
	 *
	 * @param items ApiItem object list
	 * @return Item object list
	 */
	/*private List<Item> mapItems(List<ApiItem> items) {
		List<Item> mappedItems = new ArrayList<Item>();
		for (ApiItem item: items) {
			mappedItems.add(
					Item.builder()
						.product(item.getProduct())
						.units(item.getUnits())
						.build()
						   );
		}
		return mappedItems;
	}*/

	/**
	 * This method transforms a Rest refund object into the business refund object
	 *
	 * @param apiRefund Rest token purchase object to be transformed
	 * @return A Refund object
	 */
	/*private Refund mapRefund(ApiRefund apiRefund) {
		Refund refund = Refund.builder()
							  .orderId(apiRefund.getOrderId())
							  .transactionId(apiRefund.getTransactionId())
							  .reason(apiRefund.getReason())
							  .build();
		return refund;
	}*/

	/**
	 * This method transforms a Rest token generation request object into the business token generation request object
	 *
	 * @param request Rest token generation request object to be transformed
	 * @return A TokenRequest object
	 */
	/*private TokenRequest mapTokenRequest(ApiTokenRequest request) {
		TokenRequest tokenRequest = TokenRequest.builder()
												.expirationDate(request.getExpirationDate())
												.identificationNumber(request.getIdentificationNumber())
												.name(request.getName())
												.number(request.getNumber())
												.paymentMethod(request.getPaymentMethod())
												.build();
		return tokenRequest;
	}*/

	/**
	 * This method transforms a list of transactions into Rest transaction response object list
	 *
	 * @param allTransactions Transaction object list
	 * @return ApiTransactionResponse object list
	 */
	/*private List<ApiTransactionResponse> mapTransactionsResponse(List<Transaction> allTransactions) {
		List<ApiTransactionResponse> transactions= new ArrayList<>();
		for (Transaction transaction: allTransactions) {
			transactions.add(
					ApiTransactionResponse.builder()
										  .id(transaction.getId())
										  .idProduct(transaction.getIdProduct())
										  .orderId(transaction.getOrderId())
										  .paymentMethod(transaction.getPaymentMethod())
										  .price(transaction.getPrice())
										  .units(transaction.getUnits())
										  .responseCode(transaction.getResponseCode())
										  .date(transaction.getDate())
										  .updateDate(transaction.getUpdateDate())
										  .build()
							);
		}
		return transactions;
	}*/

	/**
	 * This method transforms a transaction into Rest transaction response
	 *
	 * @param transaction Transaction object
	 * @return ApiTransactionResponse object
	 */
	/*private ApiTransactionResponse mapTransactionResponse(Transaction transaction) {
		ApiTransactionResponse mappedTransaction = ApiTransactionResponse.builder()
																		 .id(transaction.getId())
																		 .idProduct(transaction.getIdProduct())
																		 .orderId(transaction.getOrderId())
																		 .paymentMethod(transaction.getPaymentMethod())
																		 .price(transaction.getPrice())
																		 .units(transaction.getUnits())
																		 .responseCode(transaction.getResponseCode())
																		 .date(transaction.getDate())
																		 .updateDate(transaction.getUpdateDate())
																		 .build();
		return mappedTransaction;
	}*/

	/**
	 * This method transforms a list of tokens into Rest token response object list
	 *
	 * @param allTokens Token object list
	 * @return ApiTokenResponse object list
	 */
	/*private List<ApiTokenResponse> mapTokensResponse(List<Token> allTokens) {
		List<ApiTokenResponse> tokens= new ArrayList<>();
		for (Token token: allTokens) {
			tokens.add(
					ApiTokenResponse.builder()
									.id(token.getId())
									.maskedNumber(token.getMaskedNumber())
									.paymentMethod(token.getPaymentMethod())
									.token(token.getToken())
									.build()
					  );
		}
		return tokens;
	}*/

	/**
	 * This method transforms a token into Rest token response
	 *
	 * @param token Token object
	 * @return ApiTokenResponse object
	 */
	/*private ApiTokenResponse mapTokenResponse(Token token) {
		ApiTokenResponse mappedToken = ApiTokenResponse.builder()
													   .id(token.getId())
													   .maskedNumber(token.getMaskedNumber())
													   .paymentMethod(token.getPaymentMethod())
													   .token(token.getToken())
													   .build();
		return mappedToken;
	}*/
}