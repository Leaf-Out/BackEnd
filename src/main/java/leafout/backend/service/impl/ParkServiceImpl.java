package leafout.backend.service.impl;

import leafout.backend.model.Activity;
import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Park;


import leafout.backend.persistence.ParkRepository;
import leafout.backend.service.ParkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * This class represent the implementation of the services of parks
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
@Service
public class ParkServiceImpl implements ParkService {


    @Autowired
    private ParkRepository parkRepository;

    @Override
    public List getAllParks() {

        return parkRepository.getAllParks();
    }

    @Override
    public void savePark(Park park) throws LeafoutPersistenceException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new LeafoutPersistenceException();
        }
        parkRepository.registerPark(park);
    }


    @Override
    public Park getParkById(UUID parkId) {
        Optional<Park> optionalPay = parkRepository.getParkById(parkId);
        return optionalPay.get();
    }

    @Override
    public void updatePark(Park park) throws LeafoutPersistenceException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new LeafoutPersistenceException();
        }
        parkRepository.updatePark(park);
    }

    @Override
    public void remove(Park park) throws LeafoutPersistenceException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new LeafoutPersistenceException();
        }
        parkRepository.delete(park);
    }
}
