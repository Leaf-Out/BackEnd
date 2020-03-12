package eci.ieti.leafout.backEnd.service.impl;


import eci.ieti.leafout.backEnd.model.Purchase;
import eci.ieti.leafout.backEnd.model.Refund;
import eci.ieti.leafout.backEnd.model.Transaction;
import eci.ieti.leafout.backEnd.service.PaymentsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the basic CRUD methods of a payment
 *
 * @author <a href=alejoguzm07@gmail.com> José Alejandro Naranjo Guzmán </a>
 * @since 0.0.1
 */
@Service
public class PaymentsServiceImpl implements PaymentsService {

	@Override
	public void pay(Purchase purchase, UUID user) {

	}

	@Override
	public void refund(Refund refund) {

	}

	@Override
	public List<Transaction> getAllTransactions() {

		return null;
	}

	@Override
	public List<Transaction> getTransactionsByUser(UUID user) {

		return null;
	}

	@Override
	public Transaction getTransactionById(UUID id) {

		return null;
	}
}
