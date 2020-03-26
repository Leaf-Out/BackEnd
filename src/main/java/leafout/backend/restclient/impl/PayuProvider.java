package leafout.backend.restclient.impl;

import com.google.gson.Gson;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import leafout.backend.model.PaymentResponse;
import leafout.backend.model.PaymentResponseCode;
import leafout.backend.model.PaymentResult;
import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.User;
import leafout.backend.model.exception.PaymentPlatformException;
import leafout.backend.payumodel.PayRequest;
import leafout.backend.payumodel.PayuTransactionResponse;
import leafout.backend.payumodel.PayuTransactionState;
import leafout.backend.payumodel.RefundRequest;
import leafout.backend.payumodel.RequestGenerator;
import leafout.backend.restclient.PaymentProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * This class is a rest client connected to the PayU payment platform API
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @author <a href=luis08acevedo@gmail.com> Luis Eduardo Moreno Acevedo </a>
 * @since 0.0.1
 */
@Service
public class PayuProvider implements PaymentProvider {

	/**
	 * String with the url of the PayU payments API
	 */
	private String url;

	private Config config;

	public PayuProvider(){
		this.config = ConfigFactory.load();
		this.url = config.getString("payuPaymentsApi.url");
	}

	@Override
	public PaymentResponse pay(final Purchase purchase, final User user) throws PaymentPlatformException {
		final CloseableHttpClient client = HttpClients.createDefault();
		final HttpPost httpPost = new HttpPost(url);
		final PayRequest payRequest = RequestGenerator.generatePayRequest(purchase,user);
		final String json = new Gson().toJson(payRequest);
		System.err.println(json);
		StringEntity entity = null;
		try {
			entity = new StringEntity(json);
		} catch (UnsupportedEncodingException e) {
			throw new PaymentPlatformException(e.getMessage());
		}
		httpPost.setEntity(entity);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		final CloseableHttpResponse response;
		String responseString = null;
		try {
			response = client.execute(httpPost);
			responseString = new BasicResponseHandler().handleResponse(response);
			System.err.println(responseString);
			client.close();
		} catch (IOException e) {
			throw new PaymentPlatformException(e.getMessage());
		}
		final JSONObject jsonObject = new JSONObject(responseString);
		final PaymentResponse paymentResponse = responseInterpreter(jsonObject);
		return paymentResponse;
	}

	@Override public PaymentResponse refund(Refund refund) throws PaymentPlatformException {
		final CloseableHttpClient client = HttpClients.createDefault();
		final HttpPost httpPost = new HttpPost(url);
		final RefundRequest refundRequest = RequestGenerator.generateRefundRequest(refund);
		final String json = new Gson().toJson(refundRequest);
		System.err.println(json);
		StringEntity entity = null;
		try {
			entity = new StringEntity(json);
		} catch (UnsupportedEncodingException e) {
			throw new PaymentPlatformException(e.getMessage());
		}
		httpPost.setEntity(entity);
		System.err.println(httpPost.toString());
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-type", "application/json");
		final CloseableHttpResponse response;
		String responseString = null;
		try {
			response = client.execute(httpPost);
			responseString = new BasicResponseHandler().handleResponse(response);
			System.err.println(responseString);
			client.close();
		} catch (IOException e) {
			throw new PaymentPlatformException(e.getMessage());
		}
		final JSONObject jsonObject = new JSONObject(responseString);
		final PaymentResponse paymentResponse = responseInterpreter(jsonObject);
		return paymentResponse;
	}

	/**
	 * This method interprets the answer returned by the PayU Payments API
	 *
	 * @param jsonObject Object representing a JSON with the response returned by PayU
	 * @return PaymentResponse object with the response, whether the transaction is satisfactory or not, is pending or an error
	 */
	private PaymentResponse responseInterpreter(JSONObject jsonObject) {
		final PaymentResponse paymentResponse;
		if (PayuTransactionResponse.SUCCESS.equals(PayuTransactionResponse.valueOf(jsonObject.getString("code")))) {
			final JSONObject responseObject = jsonObject.getJSONObject("transactionResponse");
			final PayuTransactionState payuTransactionState = PayuTransactionState.valueOf(responseObject.getString("state"));
			paymentResponse = PaymentResponse.builder()
								.paymentResult(mapResponse(payuTransactionState,responseObject))
								.orderId(responseObject.getInt("orderId"))
								.transactionId(responseObject.getString("transactionId"))
								.build();
		} else {
			PaymentResult paymentResult = PaymentResult.builder()
											.paymentResponseCode(PaymentResponseCode.TRANSACTION_ERROR)
											.reason(jsonObject.getString("error"))
											.build();
			paymentResponse = PaymentResponse.builder()
								.paymentResult(paymentResult)
								.build();
		}
		return paymentResponse;
	}


	/**
	 * This method adapts a PayU transaction response code to be one of the response codes of the commerce
	 *
	 * @param responseObject JSONObject with the transactionResponse section of a response given by PayU
	 * @return TransactionResponse object with the business response code
	 */
	private PaymentResult mapResponse(PayuTransactionState transactionState, JSONObject responseObject){
		PaymentResult paymentResult;
		if (PayuTransactionState.APPROVED.equals(transactionState)) {
			paymentResult = PaymentResult.builder()
					.reason(responseObject.get("responseCode").toString())
					.paymentResponseCode(PaymentResponseCode.SUCCESSFUL_TRANSACTION)
					.build();
		} else if (PayuTransactionState.PENDING.equals(transactionState)) {
			paymentResult = PaymentResult.builder()
					.reason(responseObject.getString("pendingReason"))
					.paymentResponseCode(PaymentResponseCode.PENDING_TRANSACTION)
					.build();
		} else {
			paymentResult = PaymentResult.builder()
					.reason(responseObject.getString("responseCode"))
					.paymentResponseCode(PaymentResponseCode.UNSUCCESSFUL_TRANSACTION)
					.build();
		}
		return paymentResult;
	}
}
