package ejerciciodeportista.bootcamp.services;

import ejerciciodeportista.bootcamp.models.Deporte;
import ejerciciodeportista.bootcamp.models.Persona;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Services {
    static List<Persona> personaList;
    static List<Deporte> deporteList;

    public Services(){
        deporteList = new ArrayList<>();
        deporteList.add(new Deporte("Futbol", "Profesional"));
        deporteList.add(new Deporte("Rugby", "Intermedio"));
        deporteList.add(new Deporte("Tenis", "Amateur"));

        personaList = new ArrayList<>();
        personaList.add(new Persona("Luis", "Lopez", 34, deporteList.get(0)));
        personaList.add(new Persona("Pablo", "Borgogno", 30, deporteList.get(1)));
        personaList.add(new Persona("Adrian", "Miguel", 28, deporteList.get(2)));
    }

    public List<Deporte> getDeporteList() {
        return deporteList;
    }

    public List<Persona> getDeportistas(){
        return personaList.stream()
                          .filter(p -> p.getDeporte() != null)
                          .collect(Collectors.toList());
    }

    public String getNivelDeporte(String name){
        return deporteList.stream()
                          .filter(d -> d.getNombre().equals(name))
                          .map(Deporte::getNivel)
                          .findFirst()
                          .orElse(null);

    }
}
