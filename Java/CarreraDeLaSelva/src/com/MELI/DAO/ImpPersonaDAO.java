package com.MELI.DAO;

import com.MELI.entity.Circuito;
import com.MELI.entity.Inscripcion;
import com.MELI.entity.Persona;
import com.MELI.helper.Helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ImpPersonaDAO implements PersonaDAO{

    public void crearCircuito(HashMap<Integer, Circuito> listCircuito, Circuito circuito){
        listCircuito.put((listCircuito.size()+1),circuito);
    }

    public void crearInscripcion(List<Inscripcion> listaInscripcion, Persona persona, Circuito circuito, double costo){
        int nroIns = Helper.siguienteInscripcion(listaInscripcion, circuito);
        Inscripcion ins = new Inscripcion(nroIns,persona,circuito,costo);
        listaInscripcion.add(ins);
    }

    public List<Inscripcion> mostrarInscripcion(List<Inscripcion> listaInscripcion, Circuito circuito){
        List<Inscripcion> listSelector = new LinkedList<>();
        for(Inscripcion ins: listaInscripcion){
            if(ins.getCircuito().equals(circuito))
                listSelector.add(ins);
        }
        return listSelector;
    }

    public void desinscribir(List<Inscripcion> listaInscripcion, Circuito circuito, int nroInscripcion){
        int indexIns = Helper.buscarInscripcion(listaInscripcion,circuito,nroInscripcion);
        if(indexIns>-1){
            listaInscripcion.remove(indexIns);
        }
        else{
            System.err.println("Nro de Inscripción no encontrada en circuito seleccionado.");
        }
    }

    public void montoInscripcion(Circuito circuito, int edad){
        if(edad<18) {
            if(circuito.getCostoMenor()>0)
                System.out.println("Monto de la inscripción: " + circuito.getCostoMenor());
            else
                System.out.println("Los menores no pueden inscribirse a la categoría "+circuito.getNombre());
        }else
            System.out.println("Monto de la inscripción: "+circuito.getCostoMayor());
    }
}
