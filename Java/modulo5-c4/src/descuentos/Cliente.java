package descuentos;

import java.util.ArrayList;

public class Cliente {
    String nombre;
    String apellido;
    String dni;
    ArrayList<Localizador> localizadores;

    public Cliente(String inNombre, String inApellido, String inDni) {
        this.nombre = inNombre;
        this.apellido = inApellido;
        this.dni = inDni;
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador inLocalizador) {
        this.localizadores.add(inLocalizador);
    }

    public String datosPersonales() {
        return String.format("Nombre: %s - Apellido: %s - DNI: %s",
                this.nombre, this.apellido, this.dni);
    }

    public double calcularDescuento(Localizador inLocali) {
        double totalConDesc = inLocali.total;
        if (this.localizadores.size() >= 3) {
            totalConDesc*=0.95;
        }

        int cantTipoReserva[] = {0, 0, 0, 0};
        for(Reserva r : inLocali.reservas) {
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
