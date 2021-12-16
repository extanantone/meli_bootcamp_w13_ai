package model;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;

public class Mercado {
    //creamos 3 clientes
    Cliente cli1 = new Cliente(123L, "Ivan", "Arevalo");
    Cliente cli2 = new Cliente(662L, "Juan", "Guzman");
    Cliente cli3 = new Cliente(333L, "Nicolas", "Avellaneda");

    //agregamos a una collection
    List<Cliente> listaClientes = new ArrayList<Cliente>();

    public Mercado() {
        listaClientes.add(cli1);
        listaClientes.add(cli2);
        listaClientes.add(cli3);
    }

    public void verClientes() {
        //mostrando todos los clientes
        for (Cliente c : listaClientes) {
            System.out.println("_________________________");
            System.out.println("Dni: " + c.getDni());
            System.out.println("Nombre: " + c.getNombre());
            System.out.println("Apellido: " + c.getApellido());
            System.out.println("_________________________");
        }
    }

    public void borrarCliente(Long dniBorrado) {

        boolean bandera = false;

        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBorrado)) {
                listaClientes.remove(c);
                bandera = true;
                break;
            }
        }
        if (bandera == false) {
            System.out.println("No se encontró el cliente a borrar");
        }
        else {
            System.out.println("Cliente borrado correctamente");
        }
    }

    public void buscarCliente(Long dniBuscado) {
        boolean bandera = false;
        for (Cliente c : listaClientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println("----Cliente encontrado, sus datos son: ----");
                System.out.println("Dni: " + c.getDni());
                System.out.println("Nombre: " + c.getNombre());
                System.out.println("Apellido: " + c.getApellido());
                bandera = true;
                break;
            }
        }

        if (bandera == false) {
            System.out.println("Cliente no encontrado");
        }
    }

    public void crearFactura() {

    }
}
