package com.app.crud.impl;

import java.util.ArrayList;
import java.util.List;

import com.app.crud.CrudRepository;
import com.app.model.Cliente;

public class ClienteRepository implements CrudRepository<Cliente,String>{

    private List<Cliente> clientes;

    public ClienteRepository(){
        clientes = new ArrayList<>();
    }

    @Override
    public void add(Cliente cliente) {
        clientes.add(cliente);
        
    }

    @Override
    public List<Cliente> getAll() {
        return clientes;
    }

    @Override
    public Cliente getOne(String id) {
        return clientes.stream().filter(it->it.getDni().equals(id))
            .findFirst().orElse(null);
    }
    
}
