package com.company.repository;
import com.company.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClientImp implements Crud<Cliente>{
    List<Cliente> listClientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente cliente) {
        listClientes.add(cliente);

    }

    @Override
    public void view() {
        for (Cliente c: listClientes){
            System.out.println(c.toString());
        }
    }

    @Override
    public Optional<Cliente> search(Long dniSearchValue) {
        boolean flag = false;

        for (Cliente c: listClientes){
            if (c.getDni().equals(dniSearchValue)){
                flag= true;
                System.out.println("Cliente encontrado");
                System.out.println("Dni "+c.getDni() + " Nombre:" + c.getNombre() + "Apellido" + c.getApellido());
                return Optional.of(c);
            }
        }

        if (flag == false) System.out.println("Cliente no encontrado");

        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Optional<Cliente> dni = this.search(id);

        if (!dni.isEmpty()) {
            System.out.println("DNI borrado");
            listClientes.remove(dni.get());
            this.view();
        } else System.out.println("DNI incorrecto");
    }

    @Override
    public List<Cliente> get() {
        return null;
    }
}
