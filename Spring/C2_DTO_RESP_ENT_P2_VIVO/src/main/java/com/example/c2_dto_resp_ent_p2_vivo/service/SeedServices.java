package com.example.c2_dto_resp_ent_p2_vivo.service;

import com.example.c2_dto_resp_ent_p2_vivo.model.Deporte;
import com.example.c2_dto_resp_ent_p2_vivo.model.Persona;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeedServices
{
    public static List<Deporte> CreateDeportes()
    {
        Deporte basketball = new Deporte("Basketball", "Medio");
        Deporte futbol = new Deporte("Futbol", "Medio");
        Deporte tenis = new Deporte("Tenis", "Avanzado");
        return List.of(basketball, futbol, tenis);
    }

    public static List<Persona> CreatePersonas()
    {
        List<Deporte> deportes = SeedServices.CreateDeportes();
        Persona david = new Persona("David", "Orejuela", 24, deportes);
        Persona daniel = new Persona("Daniel", "Puerta", 24, deportes);
        return List.of(david, daniel);
    }
}
