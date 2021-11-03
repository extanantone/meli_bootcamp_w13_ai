package AgenciaDeTurismo;

import java.util.ArrayList;

public class Cliente {
    String nombre;
    String apellido;
    String dni;
    ArrayList<Localizador> localizadores;


    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    public String datosPersonales() {
        return String.format("Nombre: %s - Apellido: %s - Dni: %s",
                this.nombre, this.apellido, this.dni);
    }

    public double calcularDescuento(Localizador localizador) {
        double totalConDesc = localizador.total;
        if (this.localizadores.size() >= 3) {
            totalConDesc*=0.95;
        }

        int cantTipoReserva[] = {0, 0, 0, 0};
        for(Reserva r : localizador.reservas) {
            cantTipoReserva[r.tipo-1]++;
        }
        boolean todasReservadas = true;
        for(int i = 0; i < 4; i++) {
            if (cantTipoReserva[i] == 0) todasReservadas = false;
        }
        if (todasReservadas) totalConDesc*=0.90;

        if (cantTipoReserva[0] >= 2 || cantTipoReserva[2] >= 2) totalConDesc*=0.95;

        return totalConDesc;
    }

}

