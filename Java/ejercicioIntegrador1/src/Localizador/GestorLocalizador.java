package Localizador;

import Descuento.Descuento;
import Modelos.Cliente;
import Reservas.Reserva;

import java.util.List;

public class GestorLocalizador {

    private static final RepositorioLocalizador repo = new RepositorioLocalizador();

    public static Localizador comprarLocalizador(Cliente cliente, List<Reserva> reservas) {
        Localizador localizador = new Localizador(cliente, reservas);
        Descuento descuento = new Descuento();
        descuento.aplicarDescuento(localizador, repo);
        repo.agregarLocalizador(cliente, localizador);
        return localizador;
    }
}
