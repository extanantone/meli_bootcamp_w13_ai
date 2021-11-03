package com.bootcamp.deportistas.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@Getter
@Setter
public class RepositorioService {
    private List<Deporte> listaDeportes;
    private List<Persona> listaPersonas;

    public RepositorioService() {
        this.listaPersonas = new ArrayList<>();
        this.listaDeportes = new ArrayList<>();

        this.listaDeportes.addAll(List.of(new Deporte("Futbol", Nivel.ALEVIN),
                                          new Deporte("Basketball", Nivel.ESTRELLA),
                                          new Deporte("Rugby", Nivel.JUVENIL),
                                          new Deporte("Voley", Nivel.PROFESIONAL),
                                          new Deporte("Hockey", Nivel.JUVENIL)));

        this.listaPersonas.add(new Persona("Ariel", "Suarez", 30));
        this.listaPersonas.add(new Persona("Susana", "Perez", 24));
        this.listaPersonas.add(new Persona("Martin", "Rolon", 44));
        this.listaPersonas.add(new Persona("Miguel", "Hernandez", 32));

        this.listaPersonas.get(0).empezarDeporte(this.listaDeportes.get(0));
        this.listaPersonas.get(1).empezarDeporte(this.listaDeportes.get(1));
        this.listaPersonas.get(2).empezarDeporte(this.listaDeportes.get(2));
        this.listaPersonas.get(3).empezarDeporte(this.listaDeportes.get(3));
    }

    public Nivel buscarDeporte(String nombreDeporte){
        List<Deporte> deportesRet = this.listaDeportes.stream()
                                        .filter(x -> x.getNombre().equalsIgnoreCase(nombreDeporte)).collect(Collectors.toList());
        if(deportesRet.size() > 0) {
            return deportesRet.get(0).getNivel();
        }
            return null;
    }

    public void agregarDeporte(Deporte deporte){
        this.listaDeportes.add(deporte);
    }

    public void registrarPersona(Persona persona){
        this.listaPersonas.add(persona);
    }


}
