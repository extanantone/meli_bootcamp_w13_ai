package bootcamp.modelo;

import java.util.List;
import java.util.stream.Collectors;

public class Factura {

    private Cliente cliente; //cliente que hace la compra
    private List<Item> listaItems;
    private double totalCompra;
    private Long id;

    public Factura(Cliente cliente, List<Item> listaItems, Long id) {
        this.cliente = cliente;
        this.listaItems = listaItems;
        this.totalCompra = 0;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Factura " + id + '\n' +
                " - cliente: " + cliente + '\n' +
                " - items: " + toStringItems() + '\n' +
                " - total: " + totalCompra;
    }

    public String toStringItems(){
        return this.listaItems.stream().map((x) -> x.getNombre()).collect(Collectors.joining(","));
    }

    public void calcularCostoTotal(){
        this.totalCompra = this.listaItems.stream().mapToDouble((x) -> x.getCostoUnitario()*x.getCantidadComprada()).reduce(Double::sum).orElse(-1);
    }

    //busca el item dentro de la lista de items comprados y lo retorna si lo encuentra. null en caso contrario.
    public Item buscarItem(int codigoItem){
        List<Item> itemBuscado = this.listaItems.stream().filter((x) -> x.getCodigo() == codigoItem).collect(Collectors.toList());
        if(itemBuscado.size() == 0){
            return null;
        }
        return itemBuscado.get(0);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
