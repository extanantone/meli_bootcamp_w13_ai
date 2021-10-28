package agenciaDeViajes;

import java.util.ArrayList;
import java.util.stream.Stream;

public class Localizador {
    private Cliente cliente;
    private double costoTotal;
    private ArrayList<Reserva> reservas;

    public Localizador(Cliente cliente, ArrayList<Reserva> reservas) {
        this.cliente = cliente;
        this.reservas = reservas;
        cliente.addLocalizador();
    }


    public Localizador(Cliente cliente) {
        this.cliente = cliente;
        this.reservas = new ArrayList<Reserva>();
        costoTotal = 0;
    }

    public void addReserva(Reserva r) {
        reservas.add(r);
    }

    public double getCostoTotal() {
        double costo = 0;

        int reservaBoletos = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaBoletos")).toArray().length;
        int reservaComida = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaComida")).toArray().length;
        int reservaHoteles = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaHoteles")).toArray().length;
        int reservaTransporte = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaTransporte")).toArray().length;

        for (Reserva r : reservas) {
            if ((r.tipoReserva() == "ReservaHoteles" && reservaHoteles > 1) || (r.tipoReserva() == "ReservaBoletos" && reservaBoletos > 1)) {
                costo += r.costo()*95/100;
            } else {
                costo += r.costo();
            }
        }

        // calculo de descuentos

        if (reservaBoletos > 0 &&
                reservaComida > 0 &&
                reservaHoteles > 0 &&
                reservaTransporte > 0) {
            costo = costo * 90 / 100;
        }

        if (cliente.getTieneDescuento()) {
            costo = costo * 95 / 100;
        }

        return costo;
    }

    public String toString() {
        String s = "Paquete del cliente " + cliente.toString() + "\n";

        int reservaBoletos = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaBoletos")).toArray().length;
        int reservaComida = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaComida")).toArray().length;
        int reservaHoteles = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaHoteles")).toArray().length;
        int reservaTransporte = reservas.stream().filter(r -> (r.tipoReserva() == "ReservaTransporte")).toArray().length;

        s += "Reservas de boletos de viaje: " + reservaBoletos + "\n" +
                "Reservas de comida: " + reservaComida + "\n" +
                "Reservas de hoteles: " + reservaHoteles + "\n" +
                "Reservas de transporte: " + reservaTransporte + "\n";
        return s + "Total: " + getCostoTotal();
    }
}
