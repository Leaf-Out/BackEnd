package eci.ieti.leafout.backend.service;

import eci.ieti.leafout.backend.model.Park;
import eci.ieti.leafout.backend.repository.LeafOutPersistenceException;

import java.util.List;

public interface ParkService {
    List<Park> getAllParks() throws LeafOutPersistenceException;

    void savePark(Park park) throws LeafOutPersistenceException;

    Park findParkByName(String name) throws LeafOutPersistenceException;
}
