package com.company;

import java.lang.ref.Cleaner;
import java.util.List;
import java.util.stream.Collectors;

public class Repositorio {
    List<Factura> facturas;
    List<Cliente> clientes;

    public Repositorio(List<Factura> facturas, List<Cliente> clientes) {
        this.facturas = facturas;
        this.clientes = clientes;
    }

    public double agregarFactura(Factura factura){
        if(clientes.stream().noneMatch(c -> c.getDni().equals(factura.cliente.getDni()))){
            clientes.add(factura.cliente);
            System.out.println("Agregado cliente " + factura.cliente);
        }
        facturas.add(factura);
        return factura.getCostoFactura();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public void imprimirClientes(){
        clientes.forEach(System.out::println);
    }

    public void imprimirClienteBuscado(String dni){
        List<Cliente> clientesEncontrados = clientes.stream().filter(c -> c.getDni().equals(dni)).collect(Collectors.toList());
        if(clientesEncontrados.size() > 0){
            System.out.println("Se encontraron los siguientes clientes con ese DNI ");
            clientesEncontrados.forEach(System.out::println);
        }
        else
            System.out.println("No se encontró ningún cliente con el dni provisto");
    }
}
