package com.company;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class AgenciaTurismo {
    List<Localizador> repositorioCliente ;

    public AgenciaTurismo(List<Localizador> repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<Localizador> getRepositorioCliente() {
        return repositorioCliente;
    }

    public void setRepositorioCliente(List<Localizador> repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    //Metodos, con metodos pocos... Con metodos poco claros...
    public int cantidadLocalizadoresVendidos(){
        return repositorioCliente.size();
    }

    public int cantidadDeReservas(){
        int cantidadReservas = 0;
        for (Localizador l: repositorioCliente) {
            cantidadReservas +=l.getListaReserva().size();
        }

        return cantidadReservas;
    }

    public void diccionarioReservasClasificadasPorTipo(){
        long TInicio,tiempo;
        TInicio = System.currentTimeMillis();
        Map<String,Integer> diccionario = new HashMap<>();
        Stream<Object> i = repositorioCliente.stream().map(locali -> locali.getListaReserva()).flatMap(reservas -> reservas.stream()).map(x->x.getNombreReserva());//.mapToInt(x->x.getTipoReserva());
        i.forEach(elem->{
            try{
                diccionario.put(elem.toString(),diccionario.get(elem.toString())+1);
            }catch (Exception e){
                diccionario.put(elem.toString(),1);
            }
        });
        /*
        for (Localizador loca: repositorioCliente) {
            for (Reserva r:loca.getListaReserva()) {
                try{
                    diccionario.put(r.getNombreReserva(),diccionario.get(r.getNombreReserva())+1);
                }catch (Exception e){
                    diccionario.put(r.getNombreReserva(),1);
                }
            }
        }
        */
        diccionario.forEach((k,v)-> System.out.println("La key: "+k+", tiene un total de:"+v));

        tiempo = System.currentTimeMillis()-TInicio;
        double convercion = tiempo/1000.00;
        System.out.println("El tiempo es:"+convercion);
    }
}


