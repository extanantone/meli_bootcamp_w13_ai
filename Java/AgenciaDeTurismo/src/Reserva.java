public class Reserva{
    private double precio;
    private enum tipoReserva {HOTEL, TRANSPORTE, COMIDA, BEBIDA};

    public Reserva(double precio) {
        this.precio = precio;
    }
}
