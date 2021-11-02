package ejericiciopractico.integrador;

import java.util.HashMap;
import java.util.Map;

public class RepoItems implements Crud<Item> {

    private static final Map<String,Item> listaItems = new HashMap<>();

    @Override
    public boolean crear(Item dato) {
        if(listaItems.containsKey(dato.getCodigo()))
            return false;
        else
        {
            listaItems.put(dato.getCodigo(),dato);
            return true;
        }
    }

    @Override
    public boolean modificar(Item dato) {
        if(!listaItems.containsKey(dato.getCodigo()))
            return false;
        else
        {
            listaItems.put(dato.getCodigo(),dato);
            return true;
        }
    }

    @Override
    public boolean delete(Item dato) {
        if(!listaItems.containsKey(dato.getCodigo()))
            return false;
        else
        {
            listaItems.remove(dato.getCodigo());
            return true;
        }
    }

    @Override
    public Item consultar(String uuid) {
        return listaItems.get(uuid);
    }

    @Override
    public void consultaGeneral() {
        System.out.println("la lista de items de la tienda es: ");
        for(Map.Entry<String,Item> dato:listaItems.entrySet())
        {
            System.out.println(dato.getValue());
        }
    }
}
