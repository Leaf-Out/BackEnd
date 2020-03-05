package eci.ieti.leafOut.backEnd.service.impl;

import eci.ieti.leafOut.backEnd.persistence.ParkRepository;
import eci.ieti.leafOut.backEnd.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ParkServiceImpl implements ParkService {

    @Autowired
    private ParkRepository parkRepository;
}
