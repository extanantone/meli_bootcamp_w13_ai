package com.starwars.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.starwars.model.Personaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonajeRepositoryImpl implements IPersonajeRepository{

    private ObjectMapper mapper= new ObjectMapper();

    private List<Personaje> personajes;

    public PersonajeRepositoryImpl(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(getClass().getClassLoader().getResourceAsStream("starwars_characters.json")));
            String s;
            String result = "";
            while ((s = in.readLine()) != null) {
                result = result + s;
            }
            System.out.println(result);
            personajes = mapper.readerForListOf(Personaje.class).readValue(result);
            System.out.println(personajes);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public List<Personaje> getPersonajesByName(String name) {
        return personajes.stream().filter(i->i.getName().toLowerCase()
                .contains(name.toLowerCase())).collect(Collectors.toList());
    }


}
