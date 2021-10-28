package com.app.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Cliente {

    private String nombre;
    private String dni;
    private List<Localizador> localizadores;
    private int discount;

    public Cliente(String nombre,String dni){
        this.nombre = nombre;
        this.dni = dni;
        localizadores = new ArrayList<>();
        discount = 0;
    }

    public void addLocalizador(Localizador localizador){
        localizadores.add(localizador);
        if(localizadores.size()==2) discount += 5;
        localizador.applyDiscount(discount);
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Cliente)) return false;
        Cliente cliente = (Cliente) obj;
        return dni!=null && cliente.getDni()!=null && dni.equals(cliente.getDni());
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public double getAveragePackage(){
        return localizadores.stream()
                .mapToDouble(Localizador::getPriceWithDiscount)
                    .average().getAsDouble();
    }

    public int getTotalPackage(){
        return (int) localizadores.stream()
                .mapToDouble(Localizador::getPriceWithDiscount).sum();
    }

    public Map<String,Long> getClasificationByHotelName(){
        return localizadores.stream().map(Localizador::getHotelName)
                .collect(
                    Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                    ));
    }

    public Map<String,Long> getClasificationByComida(){

        return localizadores.stream()
                    .flatMap(it->it.getComidas().stream())
                    .collect(
                        Collectors.groupingBy(
                            Function.identity(),
                            Collectors.counting()
                        ));
    }

    public Map<String,Long> getClasifycationByBoletos(){
        return localizadores.stream().map(Localizador::getAerolinea)
                .collect(
                    Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                    )
                );
    }

}
