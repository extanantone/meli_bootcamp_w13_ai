package Java_IV;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Descuentos {
    private RepositorioLocalizadores repoLocalizadores;

    public Descuentos(RepositorioLocalizadores repoLocalizadores) {
        this.repoLocalizadores = repoLocalizadores;
    }

    public double aplicarDescuentos(Localizador localizador) {
        Cliente cliente = localizador.getCliente();
        ArrayList<Reserva> listaReservas = localizador.getListaReservas();
        double montoInicial = listaReservas.stream().reduce(0, (acc, cv) -> acc + cv.getPrecio(), Integer::sum);
        double porcentajeDescuento = descuentoPorLocalizadores(cliente) +
                descuentoPorPaquete(listaReservas) +
                descuentoPorDobles(listaReservas);
        return montoInicial * (100 - porcentajeDescuento) / 100 ;
    }

    private int descuentoPorLocalizadores(Cliente cliente) {
        return repoLocalizadores.getListaLocalizador().stream()
                .reduce(0, (acc, cv) -> cv.getCliente().equals(cliente) ? acc + 1 : acc, Integer::sum)
                > 1 ? 5 : 0;
    }

    private int descuentoPorPaquete(ArrayList<Reserva> paquete) {
        List<TipoReserva> listaPaqueteCompleto = new ArrayList<>(Arrays.asList(TipoReserva.values()));
        for (Reserva cv : paquete) {
            listaPaqueteCompleto.removeIf(tipo -> tipo.equals(cv.getTipo()));
        }
        return listaPaqueteCompleto.size() == 0 ? 10 : 0;
    }

    private int descuentoPorDobles(ArrayList<Reserva> paquete) {
        int reservasHotel = 0;
        int boletosViaje = 0;
        for (Reserva cv : paquete) {
            if (cv.getTipo() == TipoReserva.HOTEL) {
                reservasHotel++;
            }
            if (cv.getTipo() == TipoReserva.BOLETOS) {
                boletosViaje++;
            }
        }
        return reservasHotel > 1 && boletosViaje > 1 ? 5 : 0;
    }

}
