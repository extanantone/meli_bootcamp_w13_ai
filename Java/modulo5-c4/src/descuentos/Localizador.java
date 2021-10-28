package descuentos;

import java.util.ArrayList;

public class Localizador {
    ArrayList<Reserva> reservas;
    Cliente sujeto;
    double total;

    public Localizador(ArrayList<Reserva> inReservas, Cliente inSujeto, double inTotal) {
        this.reservas = inReservas;
        this.sujeto = inSujeto;
        this.total = inTotal;
        this.sujeto.addLocalizador(this);
    }
}
