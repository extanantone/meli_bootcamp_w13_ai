package com.bootcamp.responseentitydemo.service;

import com.bootcamp.responseentitydemo.entity.Person;
import com.bootcamp.responseentitydemo.dto.PersonDTO;

import java.util.ArrayList;
import java.util.List;

public class PeopleService {

    List<Person> people;

    public PeopleService() {
        SportService SPORTSERVICE = new SportService();
        people = new ArrayList<>();
        people.add(new Person("Laura", "Suárez", 22, SPORTSERVICE.getAllSports().get(0)));
        people.add(new Person("Juan", "Pérez", 20, SPORTSERVICE.getAllSports().get(1)));
        people.add(new Person("Lucas", "García", 33, SPORTSERVICE.getAllSports().get(1)));
        people.add(new Person("Johanna", "Hausmann", 40, SPORTSERVICE.getAllSports().get(2)));
    }

    public List<PersonDTO> getAllPeople() {
        List<PersonDTO> result = new ArrayList<>();
        for (Person person: people) {
            PersonDTO personDTO = new PersonDTO();
            personDTO.setFullName(person.getFirstName() + " " + person.getLastName());
            personDTO.setSportName(person.getSport().getName());
            result.add(personDTO);
        }
        return result;
    }

}
