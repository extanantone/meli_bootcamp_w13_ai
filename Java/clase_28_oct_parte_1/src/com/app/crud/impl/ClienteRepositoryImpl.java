package com.app.crud.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.app.crud.ClienteRepository;
import com.app.model.Cliente;
import com.app.model.Localizador;

public class ClienteRepositoryImpl implements ClienteRepository{

    private List<Cliente> clientes = new ArrayList<>();

    public ClienteRepositoryImpl(){

    }

    @Override
    public void addCliente(Cliente cliente) {
        if(getClienteByDni(cliente.getDni())==null){
            clientes.add(cliente);
        }
        
    }

    @Override
    public Cliente getClienteByDni(String dni) {
        return clientes.stream()
                .filter(cliente->cliente.getDni().equals(dni))
                    .findFirst().orElse(null);
    }

    @Override
    public void deleteCliente(String dni) {
        clientes.remove(getClienteByDni(dni));
        
    }

    @Override
    public List<Localizador> getLocalizadoresByCliente(String dni) {
        Cliente cliente = getClienteByDni(dni);
        if(cliente==null) return null;
        return cliente.getLocalizadores();
    }

    @Override
    public List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public int getNumberBoletosVendidos() {
        return clientes.stream()
        .mapToInt(cliente->cliente.getLocalizadores()
            .size()).sum();
    }

    @Override
    public double getAverageSellers() {
        return clientes.stream()
                .mapToDouble(Cliente::getAveragePackage)
                    .average().getAsDouble();
    }

    @Override
    public int getTotalPrice() {
        return clientes.stream().mapToInt(Cliente::getTotalPackage)
                .sum();
    }

    @Override
    public Map<String,Long> getClasificationByHotelName() {
        Map<String,Long> data= clientes.stream().map(Cliente::getClasificationByHotelName)
                .flatMap(map->map.entrySet().stream())
                .collect(
                    Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingLong(it->it.getValue()
                    )));
        return data;
    }

    public Map<String,Long> getClasificationByComida(){
        return clientes.stream()
                .flatMap(it->it.getClasificationByComida().entrySet().stream())
                .collect(
                    Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingLong(Map.Entry::getValue)
                ));
    }

    public Map<String,Long> getClasificationByAerolinea(){
        return clientes.stream()
                .flatMap(it->it.getClasifycationByBoletos().entrySet().stream())
                .collect(
                    Collectors.groupingBy(
                        Map.Entry::getKey,
                        Collectors.summingLong(Map.Entry::getValue)
                    )
                );
    }

    
}
