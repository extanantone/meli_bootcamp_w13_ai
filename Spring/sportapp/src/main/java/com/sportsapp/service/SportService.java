package com.sportsapp.service;

import com.sportsapp.model.Sport;

import java.util.List;

public interface SportService {

    List<Sport> getSports();

    Sport getSportByName(String name);
}
