package Java_IV;

import java.util.ArrayList;

public class RepositorioCliente {
    private ArrayList<Cliente> listaCliente = new ArrayList<>();

    public void addCliente(Cliente cliente) {
        listaCliente.add(cliente);
    }

}
