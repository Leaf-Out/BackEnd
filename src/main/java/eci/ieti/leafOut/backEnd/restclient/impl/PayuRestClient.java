package eci.ieti.leafout.backEnd.restclient.impl;

import eci.ieti.leafout.backEnd.model.exception.RestClientException;
import eci.ieti.leafout.backEnd.model.Plan;
import eci.ieti.leafout.backEnd.model.Purchase;
import eci.ieti.leafout.backEnd.model.Refund;
import eci.ieti.leafout.backEnd.model.RestClientResponse;
import eci.ieti.leafout.backEnd.model.Transaction;
import eci.ieti.leafout.backEnd.model.User;
import eci.ieti.leafout.backEnd.restclient.PaymentsRestClient;
import org.springframework.stereotype.Service;

/**
 * This class is a rest client connected to payment platform API
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Service
public class PayuRestClient implements PaymentsRestClient {

	@Override
	public RestClientResponse pay(Purchase purchase, Plan product, User customer, int units)
			throws RestClientException {

		return null;
	}

	@Override public RestClientResponse refund(Refund refund) throws RestClientException {

		return null;
	}

	@Override public RestClientResponse checkState(Transaction transaction) throws RestClientException {

		return null;
	}
}
