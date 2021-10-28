package com.company;

import java.util.ArrayList;
import java.util.List;

public class RepoCliente {
    List<Cliente> clientes;

    public RepoCliente(){
        clientes = new ArrayList<>();
    }

    public void addCliente(Cliente cliente){
        clientes.add(cliente);
    }

    public void removeCliente(Cliente cliente){
        clientes.remove(cliente);
    }

    public Cliente getCliente(int idx){
        return clientes.get(idx);
    }
}
