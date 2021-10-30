package Supermercado;

import java.util.HashMap;

public class ListaClientes implements CRUD<Cliente, Integer>{

    HashMap<Integer,Cliente> listaClientes = new HashMap<>();

    @Override
    public String toString() {
        return "ListaClientes{" +
                "listaClientes=" + listaClientes +
                '}';
    }

    public HashMap<Integer, Cliente> getListaClientes() {
        return listaClientes;
    }

    @Override
    public void alta(Cliente data) {
        listaClientes.put(data.getDni(),data);
    }

    @Override
    public Cliente consulta(Integer dni) {
        return listaClientes.get(dni);
    }

    @Override
    public void modificacion(Cliente data) {
        listaClientes.put(data.getDni(),data);
    }

    @Override
    public Cliente baja(Integer dni) {
        return listaClientes.remove(dni);
    }
}
