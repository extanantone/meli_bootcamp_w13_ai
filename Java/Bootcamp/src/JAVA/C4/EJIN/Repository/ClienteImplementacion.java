package JAVA.C4.EJIN.Repository;

import JAVA.C4.EJIN.Model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ClienteImplementacion implements CRUDInterface<Cliente> {
    private List<Cliente> listaCliente = new ArrayList<>();

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
        Cliente clienteEliminar;
        clienteEliminar
                = listaCliente.stream()
                .filter(cliente -> cliente.getDni() == dni)
                .findAny().orElse(null);
        listaCliente.remove(clienteEliminar);
    }

    @Override
    public void consultaGeneral() {
        listaCliente.forEach(System.out::println);
    }

    @Override
    public void consultaParticular(Integer dni) {
        List<Cliente> clienteEncontrado = listaCliente.stream()
                .filter(cliente -> cliente.getDni() == dni)
                .collect(Collectors.toList());
        if (!clienteEncontrado.isEmpty()) {
            System.out.println(clienteEncontrado);
        } else {
            System.out.println("No existe un cliente con ese DNI.");
        }
    }

    @Override
    public List<Cliente> traerLista() {
        return listaCliente;
    }
}
