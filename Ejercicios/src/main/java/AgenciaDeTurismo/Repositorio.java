package AgenciaDeTurismo;

public class Repositorio {
    Localizador localizador;
    double totalConDescuento;

    public Repositorio(Localizador localizador) {
        this.localizador = localizador;
        this.calculoDescuento();
    }

    private void calculoDescuento() {
        this.totalConDescuento = this.localizador.sujeto.calcularDescuento(this.localizador);
    }

    public String imprimirCompra() {
        String factura = this.localizador.sujeto.datosPersonales();
        String reservas = "Reservas:\n";
        for (Reserva r : this.localizador.reservas) reservas += r.toString() + "\n";
        factura += reservas;
        factura += String.format("\nTotal a pagar: %f", this.totalConDescuento);
        return factura;
    }

    public double getTotalConDescuento() {
        return this.totalConDescuento;
    }
}
