package Java_IV;

public class Reserva {
    private TipoReserva tipo;
    private int precio;

    public Reserva(TipoReserva tipo, int precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Reserva:" + "\n" +
                "tipo=" + tipo + "\n" +
                "precio=" + precio + "\n"
                ;
    }
}
