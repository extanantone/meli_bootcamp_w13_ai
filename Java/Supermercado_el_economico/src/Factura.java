import java.util.List;

public class Factura {
    private Long codigo;
    private Cliente cliente;
    private List<Item> listaDeItems;
    private  double total;

    public Factura(Long codigo, Cliente cliente, List<Item> listaDeItems, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.listaDeItems = listaDeItems;
        this.total = total;
    }

    public Factura() {
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }

    public void setListaDeItems(List<Item> listaDeItems) {
        this.listaDeItems = listaDeItems;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
