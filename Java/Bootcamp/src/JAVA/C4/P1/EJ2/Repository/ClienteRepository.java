package JAVA.C4.P1.EJ2.Repository;

import JAVA.C4.P1.EJ2.Model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class ClienteRepository implements CRUDInterface<Cliente> {
    List<Reserva> listaReservas = new ArrayList<>();
    List<Cliente> listaCliente = new ArrayList<>();
    List<Localizador> listaLocalizador = new ArrayList<>();

    @Override
    public void alta(Cliente cliente) {
        if (!listaCliente.contains(cliente)) {
            listaCliente.add(cliente);
        } else {
            System.out.println("La reserva ya existe.");
        }
    }

    @Override
    public void mostrarGeneral() {
        listaReservas.forEach(System.out::println);
    }

    @Override
    public void mostrarParticular(Integer dni) {
        listaCliente.stream()
                .filter(c -> c.getDni() == dni)
                .findAny()
                .orElse(null);
    }

    @Override
    public List<Cliente> devolverLista() {
        return this.listaCliente;
    }

    public List<Localizador> localizadorxCliente(Integer dni) {
        return listaLocalizador.stream()
                .filter(localizador -> localizador.getCliente().getDni() == dni)
                .collect(Collectors.toList());
    }

    public List<Reserva> reservasXCliente(List<Localizador> listaLoc) {
        return listaLoc.stream()
                .map(localizador -> localizador.getListaReservas()).flatMap(List::stream).collect(Collectors.toList());
    }

    public double DescDosLocalizadores(List<Localizador> loc) {
        int dniCliente = loc.get(0).getCliente().getDni();
        List<Localizador> loc2 = localizadorxCliente(dniCliente);
        double descuento = 0;
        if (loc2.size() >= 2) {
            descuento = 0.05;
        }
        return descuento;
    }

    public double paqueteCompleto(List<Reserva> res) {
        double descuento = 0;
        if (res.stream().anyMatch(r -> r instanceof ReservaHotel)
                && res.stream().anyMatch(r -> r instanceof ReservaTransporte)
                && res.stream().anyMatch(r -> r instanceof ReservaComida)
                && res.stream().anyMatch(r -> r instanceof ReservaHotel)
                && res.stream().anyMatch(r -> r instanceof ReservaBoletoViaje)) {
            descuento = 0.1;
        }
        return descuento;
    }

    public double DescDosReservas(List<Reserva> res) {
        double descuento = 0;
        if (res.stream().filter(r -> r instanceof ReservaHotel).count() >= 2
                || res.stream().filter(r -> r instanceof ReservaBoletoViaje).count() >= 2) {
            descuento = 0.05;
        }
        return descuento;
    }

    public double calcularDescuentoTotal(List<Localizador> listaLocalizadores) {
        double cantLocalizadores = listaLocalizadores.size();
        double totalSinDescuento = cantLocalizadores * listaLocalizadores.stream().mapToDouble(l -> l.calcularTotal()).sum();

        double descuento = 0;
        descuento += DescDosLocalizadores(listaLocalizadores);
        descuento += paqueteCompleto(listaLocalizadores.stream().map(localizador -> localizador.getListaReservas()).flatMap(List::stream).collect(Collectors.toList()));
        descuento += DescDosReservas(listaLocalizadores.stream().map(localizador -> localizador.getListaReservas()).flatMap(List::stream).collect(Collectors.toList()));
        return totalSinDescuento = totalSinDescuento - (totalSinDescuento * descuento);
    }


}
