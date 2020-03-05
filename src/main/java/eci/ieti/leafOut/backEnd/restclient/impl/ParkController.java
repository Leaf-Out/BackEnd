package eci.ieti.leafOut.backEnd.restclient.impl;


import eci.ieti.leafOut.backEnd.service.ParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/Parks")
public class ParkController {

    @Autowired
    private ParkService parkServices;
}
