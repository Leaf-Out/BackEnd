package leafout.backend.service.impl;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;
import leafout.backend.persistence.PayRepository;
import leafout.backend.service.PayService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PayServiceImpl implements PayService {


    @Autowired
    private PayRepository payRepository;


    @Override
    public List<Pay> getAllPays() throws LeafoutPersistenceException {
        return payRepository.getAllPays();
    }

    @Override
    public void savePay(Pay pay) throws LeafoutPersistenceException {
        if(!payRepository.existsPayById(pay.getId())){
            throw new LeafoutPersistenceException();
        }
        payRepository.registerPay(pay);
    }

    @Override
    public Pay getPayById(UUID payId) throws LeafoutPersistenceException {
        Optional<Pay> optionalPay = payRepository.getPayById(payId);
        if (!optionalPay.isPresent()){
            throw new LeafoutPersistenceException();
        }
        return optionalPay.get();
    }

    @Override
    public void updatePay(Pay pay) throws LeafoutPersistenceException{
        if(!payRepository.existsPayById(pay.getId())){
            throw new LeafoutPersistenceException();
        }
        payRepository.updatePay(pay);
    }


    @Override
    public void remove(Pay pay) throws LeafoutPersistenceException {
        if(!payRepository.existsPayById(pay.getId())){
            throw new LeafoutPersistenceException();
        }
        payRepository.delete(pay);
    }
}

