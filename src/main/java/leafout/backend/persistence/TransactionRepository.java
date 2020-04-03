package leafout.backend.persistence;


import leafout.backend.model.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * This class represent the repository of a Transactions
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Repository
public interface TransactionRepository extends MongoRepository<Transaction, String> {

    /**
     * find all Transactions created
     *
     * @return list<Plan>
     */
    List<Transaction> findAll();

    /**
     * find an Transaction by id
     *
     * @param transactionId the name of Transaction
     * @return optional<Transaction>
     **/
    Optional<Transaction> getTransactionById(String transactionId);

    /**
     * find an Transaction by user
     *
     * @param transactionUser the name of Transaction
     * @return optional<Transaction>
     **/
    List<Transaction> getTransactionsByUserId(String transactionUser);

    /**
     * Save a Transaction
     *
     * @param transaction the Plan would be save
     * @return Transaction
     */
    Transaction save(Transaction transaction);

    /**
     * if the Transaction exisist
     *
     * @param transactionId the id of Transaction
     * @return boolean
     */
    boolean existsTransactionById(String transactionId);

}
