package eci.ieti.leafout.backend.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eci.ieti.leafout.backend.model.Park;
import eci.ieti.leafout.backend.repository.ParkRepository;

@Service
/**
 * ParkService
 */
public class ParkService {

    @Autowired
    ParkRepository parkRepository;

    public List<Park> getAll(){
        List<Park> parks = new ArrayList<Park>();
        parkRepository.findAll().forEach(park -> parks.add(park));
        return parks;
    }

    public Optional<Park> getById(int parkId){
        return parkRepository.findById(parkId);
    }

    public void save(Park park){
        parkRepository.save(park);
    }
}