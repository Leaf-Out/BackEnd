package eci.ieti.leafOut.backEnd.service;

import eci.ieti.leafOut.backEnd.model.Park;
import eci.ieti.leafOut.backEnd.persistence.LeafOutPersistenceException;

import java.util.List;
import java.util.Optional;

public interface ParkService {
    List<Park> getAllParks() throws LeafOutPersistenceException;

    void savePark(Park park) throws LeafOutPersistenceException;

    Park findParkByName(String name) throws LeafOutPersistenceException;
}
