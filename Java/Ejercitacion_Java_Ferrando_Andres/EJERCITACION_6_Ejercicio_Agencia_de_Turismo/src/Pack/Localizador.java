package Pack;

import Reservas.Reserva;

import java.util.ArrayList;

public class Localizador {

    private int nroLocalizador;
    ArrayList<Reserva> arrayReservas = new ArrayList();

    public Localizador(int nroLocalizador, ArrayList reservas) {
        this.nroLocalizador = nroLocalizador;
        this.arrayReservas = reservas;
    }

    public int getNroLocalizador() {
        return nroLocalizador;
    }

    public void setNroLocalizador(int nroLocalizador) {
        this.nroLocalizador = nroLocalizador;
    }

    public ArrayList getArrayReservas() {
        return arrayReservas;
    }

    public void setArrayReservas(ArrayList arrayReservas) {
        this.arrayReservas = arrayReservas;
    }

    public void agregarReserva(Reserva reserva)
    {
        arrayReservas.add(reserva);
        System.out.println("Reserva creada y agregada");
    }
}

