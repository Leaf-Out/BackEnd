package leafout.backend.service.impl;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Park;


import leafout.backend.service.ParkService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
    private ParkService parkRepository;

    @Override
    public List getAllParks() {
        return null;
    }

    @Override
    public void savePark(Park park) throws LeafoutPersistenceException {

    }


    @Override
    public Park getParkById(UUID parkId) {
        return null;
    }

    @Override
    public void updatePark(Park park) throws LeafoutPersistenceException {

    }

    @Override
    public void remove(Park park) throws LeafoutPersistenceException {

    }
}
