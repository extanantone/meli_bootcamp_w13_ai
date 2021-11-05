package com.company;


import com.company.model.Agencia;
import com.company.model.Cliente;
import com.company.model.Localizador;
import com.company.model.Paquete;
import com.company.model.item.*;
import com.company.model.promocion.Completa;
import com.company.model.promocion.HotelX2;
import com.company.model.promocion.LocalizadorX2;
import com.company.model.promocion.Promocion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan");

        List<ItemLocalizador> items = new ArrayList<>();
        items.add(new Boleto());
        items.add(new Comida());
        items.add(new Transporte());
        items.add(new ReservaHotel());

        Paquete paquete = new Paquete(items);

        List<Promocion> promociones1 = Agencia.getPromociones(cliente, paquete);
        Localizador localizador1 = new Localizador(promociones1, paquete,  cliente);
        System.out.println(localizador1);

        List<Promocion> promociones2 = Agencia.getPromociones(cliente, paquete);
        Localizador localizador2 = new Localizador(promociones2, paquete,  cliente);
        System.out.println(localizador2);

        List<Promocion> promociones3 = Agencia.getPromociones(cliente, paquete);
        Localizador localizador3 = new Localizador(promociones3, paquete,  cliente);
        System.out.println(localizador3);


        paquete.addItem(new ReservaHotel());
        List<Promocion> promociones4 = Agencia.getPromociones(cliente, paquete);
        Localizador localizador4 = new Localizador(promociones4, paquete,  cliente);
        System.out.println(localizador4);

    }
}
