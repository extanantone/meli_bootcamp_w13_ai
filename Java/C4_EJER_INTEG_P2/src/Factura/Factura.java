package Factura;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.StringJoiner;


public class Factura
{
    private Long codigo;

    public Long getCodigo()
    {
        return codigo;
    }

    public void setCodigo(Long codigo)
    {
        this.codigo = codigo;
    }

    private Cliente cliente;
    private List<Item> items;
    private double totalCompra;

    public Factura(Long codigo, Cliente cliente, @NotNull List<Item> items)
    {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.totalCompra = items.stream().mapToDouble(Item::getCostoUnitario).sum();
    }

    public Cliente getCliente()
    {
        return cliente;
    }

    public void setCliente(Cliente cliente)
    {
        this.cliente = cliente;
    }

    public List<Item> getItems()
    {
        return items;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    public double getTotalCompra()
    {
        return totalCompra;
    }

    public void setTotalCompra(double totalCompra)
    {
        this.totalCompra = totalCompra;
    }

    @Override
    public String toString()
    {
        final StringBuilder sb = new StringBuilder("Factura\n{");
        sb.append("codigo=").append(codigo);
        sb.append("\n, cliente=").append(cliente);
        sb.append("\n, items=").append(items);
        sb.append("\n, totalCompra=").append(totalCompra);
        sb.append("\n}");
        return sb.toString();
    }
}
