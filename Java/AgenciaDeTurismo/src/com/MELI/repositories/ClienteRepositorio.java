package com.MELI.repositories;

import com.MELI.models.Cliente;
import com.MELI.models.Localizador;

import java.util.*;

public class ClienteRepositorio {
    Set<Cliente> clientes;

    public ClienteRepositorio() {
        this.clientes = new HashSet<>();
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }

}
