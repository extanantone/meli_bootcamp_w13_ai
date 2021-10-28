package descuentos;

public class Repositorio {
    Localizador locali;
    double totalConDesc;

    public Repositorio(Localizador inLocali) {
        this.locali = inLocali;
        this.calculoDescuento();
    }

    private void calculoDescuento() {
        this.totalConDesc = this.locali.sujeto.calcularDescuento(this.locali);
    }

    public String imprimirCompra() {
        String factura = this.locali.sujeto.datosPersonales()+"\n";
        String msgReservas = "Reservas:\n";
        for(Reserva r : this.locali.reservas) msgReservas+=r.toString()+"\n";
        factura+=msgReservas;
        factura+=String.format("Total a pagar: %f", this.totalConDesc);
        return factura;
    }

    public double getTotalConDesc() {
        return this.totalConDesc;
    }
}
