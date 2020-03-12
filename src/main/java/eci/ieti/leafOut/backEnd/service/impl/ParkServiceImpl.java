package eci.ieti.leafout.backend.service.impl;

import eci.ieti.leafout.backend.model.Park;
import eci.ieti.leafout.backend.repository.LeafOutPersistenceException;
import eci.ieti.leafout.backend.repository.ParkRepository;
import eci.ieti.leafout.backend.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkRepository parkRepository;

    @Override
    public List<Park> getAllParks() throws LeafOutPersistenceException {
        List<Park> parks = new ArrayList<Park>();
        parkRepository.findAll().forEach(park -> parks.add(park));
        return parks;
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
