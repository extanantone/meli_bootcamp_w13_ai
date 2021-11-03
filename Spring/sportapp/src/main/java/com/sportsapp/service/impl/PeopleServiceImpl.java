package com.sportsapp.service.impl;

import com.sportsapp.model.People;
import com.sportsapp.model.Sport;
import com.sportsapp.service.PeopleService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeopleServiceImpl implements PeopleService {
    private List<People> peoples = List.of(
            new People("Juan","Diaz",12,new Sport("futball",1)),
            new People("David","Palacios",20,new Sport("tenis",2)),
            new People("Daniel","Santos",20,new Sport("nado",3))

            );

    public List<People> getPeoples(){
        return peoples;
    }
}
