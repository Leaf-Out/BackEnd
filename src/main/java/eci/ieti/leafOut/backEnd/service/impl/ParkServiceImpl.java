package eci.ieti.leafout.backend.service.impl;

import eci.ieti.leafout.backend.model.Plan;
import eci.ieti.leafout.backend.model.Park;
import eci.ieti.leafout.backend.repository.LeafOutPersistenceException;
import eci.ieti.leafout.backend.repository.ParkRepository;
import eci.ieti.leafout.backend.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


/**
 * This class implements the basic methods of a Park
 *
 * @author Juan Pablo Ospina Henao
 * @since 0.0.1
 */
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
    public Park findParkByName(UUID park) throws LeafOutPersistenceException {
        return null;
    }

    @Override
    public void updatePark(Park park) {

    }

    @Override
    public List<Plan> getListPlansByPark(UUID park) {
        return null;
    }

    @Override
    public Integer getTicketCost(UUID park) {
        return null;
    }
}
