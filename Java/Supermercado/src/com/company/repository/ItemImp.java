package com.company.repository;
import com.company.model.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository <Item>{

    List <Item> listaItems = new ArrayList<Item>();

    @Override
    public void save(Item objeto) {
        listaItems.add(objeto);
    }

    @Override
    public void mostrarPantalla() {
        for (Item item : listaItems) {
            System.out.println(item.toString());
        }
    }

    @Override
    public Optional<Item> buscar(Long codigoBuscado) {

        boolean encontrado = false;
        for (Item item : listaItems) {
            if (!item.getCodigo().equals(codigoBuscado)) continue;

            System.out.println("Item encontrado, sus datos son");
            System.out.println(item.toString());
            return Optional.of(item);
        }

        if (!encontrado) {
            System.out.println("Item no encontrado");
        }
         return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Item> item = this.buscar(codigoBorrado);

        if (item.isEmpty()) {
            System.out.println("No se encontró el item a borrar");
            return;
        }
        System.out.println("Item borrado correctamente");
        listaItems.remove(item.get());
    }

    @Override
    public List<Item> listar() {
        return listaItems;
    }
}
