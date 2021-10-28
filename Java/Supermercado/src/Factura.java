import java.util.List;

public class Factura {
    private Cliente cliente;
    private double totalCompra;
    private List<Item> items;

    public Factura(Cliente cliente, List<Item> items) {
        this.cliente = cliente;
        items.stream().forEach(item -> this.totalCompra += item.getCostoUnitario()*item.getCantidad());
        this.items = items;
    }

    @Override
    public String toString() {
        return "Factura{" +
                "cliente=" + cliente +
                ", totalCompra=" + totalCompra +
                ", items=" + items.toString() +
                '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra) {
        this.totalCompra = totalCompra;
    }
}
