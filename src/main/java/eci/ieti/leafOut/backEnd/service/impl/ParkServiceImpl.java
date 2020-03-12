package eci.ieti.leafout.backEnd.service.impl;

import eci.ieti.leafout.backEnd.model.Park;
import eci.ieti.leafout.backEnd.model.Plan;
import eci.ieti.leafout.backEnd.model.exception.LeafOutPersistenceException;
import eci.ieti.leafout.backEnd.persistence.ParkRepository;
import eci.ieti.leafout.backEnd.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return parkRepository.getAllParks();
    }

    @Override
    public void savePark(Park park) throws LeafOutPersistenceException {
        parkRepository.registerPark(park);
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
