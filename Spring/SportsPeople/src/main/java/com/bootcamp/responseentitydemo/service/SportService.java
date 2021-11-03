package com.bootcamp.responseentitydemo.service;

import com.bootcamp.responseentitydemo.entity.Sport;

import java.util.ArrayList;
import java.util.List;

public class SportService {

    List<Sport> sports;

    public SportService() {
        sports = new ArrayList<>();
        sports.add(new Sport("Basketball", "Amateur"));
        sports.add(new Sport("Football", "Professional"));
        sports.add(new Sport("Volleyball", "Amateur"));
    }

    public List<Sport> getAllSports() {
        return sports;
    }

    public Sport getSportByName(String name) {
        Sport result = null;
        for (Sport sport: sports) {
            if (sport.getName().equals(name)) {
                result = sport;
                break;
            }
        }
        return result;
    }
}
