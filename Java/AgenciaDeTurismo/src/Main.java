import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();
        Reserva r1 = new Transporte();
        Reserva r2 = new BoletoViaje();
        Reserva r3 = new ReservaHotel();
        Reserva r4 = new ReservaComida();
        reservas.addAll(List.of(r1,r2,r3,r4));
        Cliente c1 = new Cliente(13565455, "Franco Tagliero", reservas);
        Localizador localizador = new Localizador(c1, reservas);
    }
}
