package leafout.backend.service.impl;

import leafout.backend.model.Exception.ParkException;
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

        return parkRepository.findAll();
    }

    @Override
    public void savePark(Park park) throws  ParkException {
        if(parkRepository.existsParkByName(park.getName())){

            throw new ParkException(park.getName());
        }
        parkRepository.save(park);
    }


    @Override
    public Park  getParkByName(String parkName) {
        Optional<Park> optionalPay = parkRepository.getParkByName(parkName);
        return optionalPay.get();
    }

    @Override
    public Park getParkById(String parkId) {
        Optional<Park> optionalPay = parkRepository.getParkById(parkId);
        return optionalPay.get();
    }

    @Override
    public void updatePark(Park park) throws ParkException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new ParkException(park.getId());
        }
        parkRepository.save(park);
    }

    @Override
    public void remove(Park park) throws  ParkException {
        if(!parkRepository.existsParkById(park.getId())){
            throw new ParkException(park.getId());
        }
        parkRepository.delete(park);
    }
}
