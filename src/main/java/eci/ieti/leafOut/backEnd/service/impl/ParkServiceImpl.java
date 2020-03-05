package eci.ieti.leafOut.backEnd.service.impl;

import eci.ieti.leafOut.backEnd.model.Park;
import eci.ieti.leafOut.backEnd.persistence.LeafOutPersistenceException;
import eci.ieti.leafOut.backEnd.persistence.ParkRepository;
import eci.ieti.leafOut.backEnd.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkRepository parkRepository;

    @Override
    public List<Park> getAllParks() throws LeafOutPersistenceException {
        return parkRepository.findAll();
    }

    @Override
    public void savePark(Park park) throws LeafOutPersistenceException {
        parkRepository.save(park);
    }

    @Override
    public Park findParkByName(String name) throws LeafOutPersistenceException {
        Optional<Park> optinalPark = parkRepository.findByName(name);
        boolean present = optinalPark.isPresent();
        if (!present)
            throw new LeafOutPersistenceException(LeafOutPersistenceException.PARK_NOT_FOUND);
        return optinalPark.get();

    }
}
