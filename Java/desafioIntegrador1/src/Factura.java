import java.util.ArrayList;

public class Factura {
    Cliente cliente;
    ArrayList<Item> items;
    double total;

    public Factura(Cliente cliente, ArrayList<Item> items, double total) {
        this.cliente = cliente;
        this.items = new ArrayList<>();
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
