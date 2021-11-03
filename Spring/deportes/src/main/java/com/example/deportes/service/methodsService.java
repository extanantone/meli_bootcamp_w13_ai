package com.example.deportes.service;

import DTO.DTOPersona;
import com.example.deportes.model.Deporte;
import com.example.deportes.model.Persona;

import java.util.ArrayList;
import java.util.List;

public class methodsService {
    private List<Persona> ps= new ArrayList<Persona>();
    private List<Deporte> ds= new ArrayList<>();
    private Persona juan = new Persona("juan","mendoza", 16 );
    private Persona sofia = new Persona("sofia","moreno", 22 );
    private Deporte futbol = new Deporte("futbol", "basico");
    private Deporte baloncesto = new Deporte("baloncesto", "avanzado");
    private Deporte natacion = new Deporte("natacion", "intermedio");
    private Deporte ciclismo = new Deporte("ciclismo", "basico");
    private DTOPersona dto1 = new DTOPersona();
    private DTOPersona dto2 = new DTOPersona();

    public void llenarDatos(){
        this.ps.add(juan);
        this.ps.add(sofia);
        this.ds.add(futbol);
        this.ds.add(baloncesto);
        this.ds.add(natacion);
        this.ds.add(ciclismo);
    }
    public void llenarDTO(){
        this.dto1.setNombre(juan.getNombre());
        this.dto1.setApellido(juan.getApellido());
        this.dto1.setEdad(juan.getEdad());
        this.dto1.agregarDeporte(this.futbol);
        this.dto1.agregarDeporte(this.baloncesto);
        this.dto2.setNombre(sofia.getNombre());
        this.dto2.setApellido(sofia.getApellido());
        this.dto2.setEdad(sofia.getEdad());
        this.dto2.agregarDeporte(natacion);
        this.dto2.agregarDeporte(ciclismo);
    }
    public List<Deporte> devolverDeportes(){
        llenarDatos();
        return this.ds;
    }
    public String buscarDeporte( String nombre){
        llenarDatos();
        String retorno ="No existe";
        for (Deporte d:this.ds) {
            if(d.getNombre().equals(nombre)){
                retorno = d.getNivel();
            }
        }
        return retorno;
    }
    public DTOPersona getDto1(){
        llenarDatos();
        llenarDTO();
        return this.dto1;
    }
}
