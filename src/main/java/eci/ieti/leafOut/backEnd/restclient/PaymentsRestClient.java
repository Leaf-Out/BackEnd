package eci.ieti.leafout.backend.restclient;

/**
 * This interface defines the methods a payment rest client should perform
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
public interface PaymentsRestClient {

	void pay();

	void refund();

	void checkState();
}

