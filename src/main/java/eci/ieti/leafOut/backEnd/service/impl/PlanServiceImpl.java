package eci.ieti.leafOut.backEnd.service.impl;


import eci.ieti.leafOut.backEnd.persistence.PlanRepository;
import eci.ieti.leafOut.backEnd.service.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepository planRepository;




}
