package JAVA.C4.EJIN.Model;

import JAVA.C4.EJIN.Repository.CRUDInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cliente implements CRUDInterface<Cliente> {
    private int dni;
    private String nombre;
    private String apellido;
    private List<Cliente> listaCliente = new ArrayList<>();

    public Cliente(int dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente, " +
                "DNI: " + dni +
                ", nombre: " + nombre +
                ", apellido: " + apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    @Override
    public void alta(Cliente cliente) {
        if (!listaCliente.contains(cliente)) {
            listaCliente.add(cliente);
        } else {
            System.out.println("La lista de clientes ya contiene al cliente: " + cliente);
        }
    }

    @Override
    public void baja(Integer dni) {
        listaCliente.remove(listaCliente.stream()
                .filter(cliente -> getDni() == dni)
                .collect(Collectors.toList()));
    }

    @Override
    public void consultaGeneral() {
        listaCliente.forEach(System.out::println);
    }

    @Override
    public void consultaParticular(Integer dni) {
        List<Cliente> clienteEncontrado = listaCliente.stream()
                                                        .filter(cliente -> getDni() == dni)
                                                        .collect(Collectors.toList());
        if (!clienteEncontrado.isEmpty()) {
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("No existe un cliente con ese DNI.");
        }
    }
}
