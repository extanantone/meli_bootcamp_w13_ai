package com.sportsapp.service.impl;

import com.sportsapp.model.People;
import com.sportsapp.model.Sport;
import com.sportsapp.service.SportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportServiceImpl implements SportService {

    private List<Sport> sports = List.of(
            new Sport("futball",1),
            new Sport("tenis",2),
            new Sport("nado",3)

    );


    @Override
    public List<Sport> getSports() {
        return sports;
    }

    @Override
    public Sport getSportByName(String name) {
        return sports.stream().filter(i->i.getName().equals(name)).findFirst().orElse(null);
    }
}
