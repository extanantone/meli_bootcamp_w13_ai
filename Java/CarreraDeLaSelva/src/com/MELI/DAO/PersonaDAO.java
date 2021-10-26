package com.MELI.DAO;

import com.MELI.entity.Circuito;
import com.MELI.entity.Inscripcion;
import com.MELI.entity.Persona;

import java.util.HashMap;
import java.util.List;

public interface PersonaDAO {

    public void crearCircuito(HashMap<Integer, Circuito> listCircuito, Circuito circuito);
    public void crearInscripcion(List<Inscripcion> listaInscripcion, Persona persona, Circuito circuito, double costo);
    public List<Inscripcion> mostrarInscripcion(List<Inscripcion> listaInscripcion, Circuito circuito);
    public void desinscribir(List<Inscripcion> listaInscripcion, Circuito circuito, int nroInscripcion);
    public void montoInscripcion(Circuito circuito, int edad);
}
