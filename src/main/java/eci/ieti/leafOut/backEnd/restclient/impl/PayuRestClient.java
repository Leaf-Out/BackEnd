package eci.ieti.leafout.backend.restclient.impl;

import eci.ieti.leafout.backend.model.Exception.RestClientException;
import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.model.Purchase;
import eci.ieti.leafout.backend.model.Refund;
import eci.ieti.leafout.backend.model.RestClientResponse;
import eci.ieti.leafout.backend.model.Transaction;
import eci.ieti.leafout.backend.model.User;
import eci.ieti.leafout.backend.restclient.PaymentsRestClient;
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
