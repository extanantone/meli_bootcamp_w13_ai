import java.util.ArrayList;

public class Cliente {

    private int dni;
    private String nombreYApellido;
    private ArrayList<Reserva> reservas;

    public Cliente(int dni, String nombreYApellido, ArrayList<Reserva> reservas) {
        this.dni = dni;
        this.nombreYApellido = nombreYApellido;
        this.reservas = reservas;
        this.aplicarDescuento();
    }

    private void aplicarDescuento() {
        this.reservas.stream().filter(
                reserva ->
        )
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombreYApellido() {
        return nombreYApellido;
    }

    public void setNombreYApellido(String nombreYApellido) {
        this.nombreYApellido = nombreYApellido;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }
}
