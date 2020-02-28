package eci.ieti.leafout.backend.restclient.impl;

import eci.ieti.leafout.backend.restclient.PaymentsRestClient;
import org.springframework.stereotype.Service;

/**
 * This class is a rest client connected to payment platform API
 *
 * @author <a href=alejoguzm08@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Service
public class PayuRestClient implements PaymentsRestClient {

	@Override public void pay() {

	}

	@Override public void refund() {

	}

	@Override public void checkState() {

	}
}
