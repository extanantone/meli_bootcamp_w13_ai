package JAVA.C4.EJIN.Repository;

import JAVA.C4.EJIN.Model.Cliente;
import JAVA.C4.EJIN.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ItemImplementacion implements CRUDInterface<Item> {
    private List<Item> listaItem = new ArrayList<>();

    @Override
    public void alta(Item item) {
        listaItem.add(item);
    }

    @Override
    public void baja(Integer codigo) {
        Item itemEliminar;
        itemEliminar
                = listaItem.stream()
                .filter(item -> item.getCodigo() == codigo)
                .findAny().orElse(null);
        listaItem.remove(itemEliminar);
    }

    @Override
    public void consultaGeneral() {
        listaItem.forEach(System.out::println);
    }

    @Override
    public void consultaParticular(Integer codigo) {
        System.out.println(listaItem.stream()
                .filter(item -> item.getCodigo() == codigo)
                .collect(Collectors.toList()));
    }

    public double costoTotal(List<Item> listaItems) {
        double totalCompra;
        return totalCompra = listaItems.stream()
                .mapToDouble(i -> i.getCostoUnitario() * i.getCantidadComprada())
                .sum();
    }

    @Override
    public List<Item> traerLista() {
        return listaItem;
    }
}
