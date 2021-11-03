package AgenciaDeTurismo;

import java.util.ArrayList;

public class Localizador {

    ArrayList<Reserva> reservas;
    Cliente sujeto;
    double total;

    public Localizador(ArrayList<Reserva> reservas, Cliente sujeto, double total) {
        this.reservas = reservas;
        this.sujeto = sujeto;
        this.total = total;
        this.sujeto.addLocalizador(this);
    }
}
