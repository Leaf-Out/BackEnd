package leafout.backend.service.impl;

import leafout.backend.model.Exception.LeafoutPersistenceException;
import leafout.backend.model.Pay;
import leafout.backend.service.ParkServices;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ParkServiceImpl implements ParkServices {
    @Override
    public List<Pay> getAllParks() throws LeafoutPersistenceException {
        return null;
    }

    @Override
    public void savePark(Pay park) throws LeafoutPersistenceException {

    }

    @Override
    public Pay findParkById(UUID park) throws LeafoutPersistenceException {
        return null;
    }

    @Override
    public void updatePark(Pay park) {

    }

    @Override
    public List<Pay> getListPlansByPark(UUID park) {
        return null;
    }

    @Override
    public Integer getTicketCost(UUID park) {
        return null;
    }
}
