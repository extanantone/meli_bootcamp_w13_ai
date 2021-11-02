package JAVA.C4.P1.EJ2.Repository;

import JAVA.C4.P1.EJ2.Model.Localizador;
import JAVA.C4.P1.EJ2.Model.Reserva;

import java.util.ArrayList;
import java.util.List;

public class LocalizadorRepository implements CRUDInterface<Localizador> {
    List<Localizador> listaLocalizadores = new ArrayList<>();

    @Override
    public void alta(Localizador localizador) {
        if (!listaLocalizadores.contains(localizador)) {
            listaLocalizadores.add(localizador);
        } else {
            System.out.println("El localizador ya se encuentra agregado.");
        }
    }

    @Override
    public void mostrarGeneral() {
        listaLocalizadores.forEach(System.out::println);
    }

    @Override
    public void mostrarParticular(Integer identificador) {
        System.out.println(listaLocalizadores.stream()
                .filter(i -> i.getIdentificador() == identificador)
                .findAny()
                .orElse(null));
    }

    @Override
    public List<Localizador> devolverLista() {
        return this.listaLocalizadores;
    }


}
