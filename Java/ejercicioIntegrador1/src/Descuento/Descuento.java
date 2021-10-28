package Descuento;

import Interfaces.Descontable;
import Localizador.Localizador;
import Localizador.RepositorioLocalizador;
import Reservas.Reserva;
import Reservas.ReservaPaqueteCompleto;

import java.util.List;
import java.util.stream.Collectors;

public class Descuento {

    public void aplicarDescuento(Localizador localizador,
                                 RepositorioLocalizador reposotorio) {
        descuentoDosHotelesOBoletos(localizador.getReservas());
        descuentoPaqueteCompleto(localizador);
        descuentoPorDosLocalizadoresAntiguos(reposotorio, localizador);
    }

    private void descuentoDosHotelesOBoletos(List<Reserva> reservas) {
        List<Descontable> r = reservas.stream().filter(reserva -> reserva instanceof Descontable)
                .map(reserva -> (Descontable) reserva).collect(Collectors.toList());

        if (r.size() == 2) r.forEach(Descontable::aplicarDescuento);
    }

    private void descuentoPaqueteCompleto(Localizador localizador) {
        double costoTotal = localizador.getCostoTotal();
        boolean existePaqueteTotal = localizador.getReservas().stream()
                .filter(reserva -> reserva instanceof ReservaPaqueteCompleto)
                .count() >= 1L;
        if (existePaqueteTotal) localizador.setCostoTotal(costoTotal - (costoTotal * 0.1));
    }

    private void descuentoPorDosLocalizadoresAntiguos(RepositorioLocalizador reposotorio,
                                                      Localizador localizador) {
        if (!reposotorio.getRepositorio().containsKey(localizador.getCliente())) return;

        boolean comproDosLocalizadores = reposotorio.getRepositorio().get(localizador.getCliente()).size() >= 2;
        if (comproDosLocalizadores) localizador.setCostoTotal(
            localizador.getCostoTotal() - localizador.getCostoTotal() * 0.05);
    }
}
