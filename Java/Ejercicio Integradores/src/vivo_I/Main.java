package vivo_I;

import vivo_I.descuento.CantLocalizador;
import vivo_I.descuento.Descuento;
import vivo_I.descuento.FullPaquete;
import vivo_I.descuento.ReservaBoleto;
import vivo_I.reserva.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        /// 1:hotel,2:boleto,3:transporte,4:comida



        HashMap<String,List<Reserva>> reservas = new HashMap<>();


        Localizador newLocalizador = new Localizador("1", "sebastian", "lugo", 1500D,1);



        List<Descuento> descuentos = List.of(
                new CantLocalizador(),
                new FullPaquete(),
                new ReservaBoleto()
        );




        // caso 1

        reservas.put("1",List.of(new Hotel(),new Hotel()));
        reservas.put("2",List.of(new Boleto(),new Boleto()));
        reservas.put("3",List.of(new Transporte()));
        reservas.put("4",List.of(new Comida()));
        newLocalizador.setReservas(reservas);

        for (Descuento desc: descuentos) {
            newLocalizador.setTotal(newLocalizador.getTotal() - desc.aplicardescuento(newLocalizador));
        }
        System.out.println("-------- caso 1");
        System.out.println(newLocalizador.toString());



        /// caso 2


        Localizador newLocalizador2 = new Localizador("2", "andres", "lugo", 1500D,1);
        reservas = new HashMap<>();

        reservas.put("1",List.of(new Hotel(),new Hotel()));
        reservas.put("2",List.of(new Boleto(),new Boleto()));



        newLocalizador2.setReservas(reservas);

        for (Descuento desc: descuentos) {
            newLocalizador2.setTotal(newLocalizador2.getTotal() - desc.aplicardescuento(newLocalizador2));
        }

        System.out.println("-------- caso 2");
        System.out.println(newLocalizador2.toString());


        // caso 3

        Localizador newLocalizador3 = new Localizador("1", "sebastian", "lugo", 1500D,3);




        for (Descuento desc: descuentos) {

            newLocalizador3.setTotal(newLocalizador3.getTotal() - desc.aplicardescuento(newLocalizador3));
        }

        System.out.println("-------- caso 3");
        System.out.println(newLocalizador3.toString());


    }
}
