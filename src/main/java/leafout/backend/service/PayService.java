package leafout.backend.service;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;

import java.util.List;
import java.util.UUID;

public interface PayService<P extends Pay> {

    /**
     * This method get all pays
     */
    List<Pay> getAllPays() throws LeafoutPersistenceException;

    /**
     * This method save a pay
     * @param pay to save
     */
    void savePay(P pay) throws LeafoutPersistenceException;

    /**
     * This method get a pay
     * @param payId UUID of the pay
     */

    Pay getPayById(UUID payId) throws LeafoutPersistenceException;

    /**
     * This method update a pay
     * @param pay that gonna get an update pay
     */

    void updatePay(P pay)  throws LeafoutPersistenceException;

    /**
     * This method remove  a pay
     * @param pay UUID of the pay
     */
    void remove(P pay) throws LeafoutPersistenceException;
}
