package com.MELI.helper;

import com.MELI.entity.Circuito;
import com.MELI.entity.Inscripcion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Helper {
    public static int siguienteInscripcion(List<Inscripcion> listaInscripcion, Circuito circuito){
        for (int i = (listaInscripcion.size()-1); i>=0; i--){
            if(listaInscripcion.get(i).getCircuito().equals(circuito))
                return (listaInscripcion.get(i).getNroInscripcion()+1);
        }
        return 1;
    }

    public static int buscarInscripcion(List<Inscripcion> listaInscripcion, Circuito circuito, int nroIns){
        for (int i = 0; i>listaInscripcion.size(); i++){
            if(listaInscripcion.get(i).getCircuito().equals(circuito) && listaInscripcion.get(i).getNroInscripcion()==nroIns)
                return i;
        }
        return -1;
    }

    public static boolean existeCircuito(HashMap<Integer, Circuito> circuito, String nombre){
        for(Map.Entry<Integer,Circuito> circ: circuito.entrySet()){
            if(circ.getValue().getNombre().equals(nombre))
                return true;
        }
        return false;
    }
}
