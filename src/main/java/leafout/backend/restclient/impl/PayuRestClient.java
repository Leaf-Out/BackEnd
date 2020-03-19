package leafout.backend.restclient.impl;

import com.google.gson.Gson;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import leafout.backend.model.PaymentResponse;
import leafout.backend.model.Purchase;
import leafout.backend.model.Refund;
import leafout.backend.model.User;
import leafout.backend.model.exception.PaymentPlatformException;
import leafout.backend.payumodel.PayRequest;
import leafout.backend.payumodel.RequestGenerator;
import leafout.backend.restclient.PaymentRestClient;
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
 * @since 0.0.1
 */
@Service
public class PayuRestClient implements PaymentRestClient {

	/**
	 * String with the url of the PayU payments API
	 */
	private String url;

	private Config config;

	public PayuRestClient(){
		this.config = ConfigFactory.load();
		this.url = config.getString("payuPaymentsApi.url");
	}

	@Override
	public PaymentResponse pay(final Purchase purchase, final User user) throws PaymentPlatformException {
		final CloseableHttpClient client = HttpClients.createDefault();
		final HttpPost httpPost = new HttpPost(url);
		final PayRequest payRequest = RequestGenerator.generatePayRequest(purchase,user);
		final String json = new Gson().toJson(payRequest);
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
		/*
		final JSONObject jsonObject = new JSONObject(responseString);
		final RestClientResponse restClientResponse;
		if (PayuTransactionResponse.SUCCESS.equals(PayuTransactionResponse.valueOf(jsonObject.getString("code")))) {
			final JSONObject object = jsonObject.getJSONObject("transactionResponse");
			final PayuTransactionState payuTransactionState = PayuTransactionState.valueOf(object.getString("state"));
			final PaymentResponse paymentResponse = mapResponse(payuTransactionState, object);
			restClientResponse = RestClientResponse.builder()
												   .transactionId(object.getString("transactionId"))
												   .orderId(object.getInt("orderId"))
												   .paymentResponse(paymentResponse)
												   .build();
		} else {
			restClientResponse = RestClientResponse.builder()
												   .paymentResponse(PaymentResponse.builder()
																				   .transactionResponse(TransactionResponse.TRANSACTION_ERROR)
																				   .reason(jsonObject.getString("error"))
																				   .build())
												   .build();
		}
		return restClientResponse;*/
		return null;
	}

	@Override public PaymentResponse refund(Refund refund) throws PaymentPlatformException {

		return null;
	}
}
