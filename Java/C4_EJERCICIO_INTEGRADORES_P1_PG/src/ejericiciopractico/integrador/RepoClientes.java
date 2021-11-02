package ejericiciopractico.integrador;

import java.util.HashMap;
import java.util.Map;

public class RepoClientes implements Crud<Cliente>{
    private static final Map<String,Cliente> listaclientes = new HashMap<>();

    @Override
    public boolean crear(Cliente dato) {
        if(listaclientes.containsKey(dato.getDni()))
            return false;
        else
        {
            listaclientes.put(dato.getDni(),dato);
            return true;
        }
    }

    @Override
    public boolean modificar(Cliente dato) {
        if(!listaclientes.containsKey(dato.getDni()))
            return false;
        else
        {
            listaclientes.put(dato.getDni(),dato);
            return true;
        }

    }

    @Override
    public boolean delete(Cliente dato) {
        if(!listaclientes.containsKey(dato.getDni()))
            return false;
        else
        {
            listaclientes.remove(dato.getDni());
            return true;
        }
    }

    @Override
    public Cliente consultar(String uuid) {
        return listaclientes.get(uuid);
    }

    @Override
    public void consultaGeneral() {
        System.out.println("la lista de clientes actuales es: ");
        for(Map.Entry<String,Cliente> dato:listaclientes.entrySet())
        {
            System.out.println(dato.getValue());
        }
    }
}
