import java.util.List;

public class Localizador {
    private Cliente cliente;
    private PackTuristico packTuristicos;
    private Double descuentoTotal;
    private Double valorTotal;

    public Localizador(Cliente cliente, PackTuristico packTuristicos, Double descuentoTotal, Double valorTotal) {
        this.cliente = cliente;
        this.packTuristicos = packTuristicos;
        this.descuentoTotal = descuentoTotal;
        this.valorTotal = valorTotal;
    }

    @Override
    public String toString() {
        return "Localizador:\n" +
                "Cliente: " + cliente +"\n"+
                "Paquete turistico: " + packTuristicos +"\n"+
                "Descuento: " + descuentoTotal +"%\n"+
                "Total: " + valorTotal +"\n";
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public PackTuristico getPackTuristicos() {
        return packTuristicos;
    }

    public void setPackTuristicos(PackTuristico packTuristicos) {
        this.packTuristicos = packTuristicos;
    }

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(Double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }


}
