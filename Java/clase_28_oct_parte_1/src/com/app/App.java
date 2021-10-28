package com.app;

import java.util.ArrayList;
import java.util.List;

import com.app.crud.ClienteRepository;
import com.app.crud.impl.ClienteRepositoryImpl;
import com.app.model.Cliente;
import com.app.model.Localizador;

public class App {
    public static void main(String[] args) {
        ClienteRepository repository = new ClienteRepositoryImpl();
        Cliente cliente = new Cliente("Juan", "1000");
        cliente.addLocalizador(new Localizador(true, 2, "hotelName", true,List.of("Pasta","Lasagna","Huevos"), true, 2,"Avianca", true, 100));
        repository.addCliente(cliente);
        Cliente cliente2 = new Cliente("Luis", "1001");
        cliente2.addLocalizador(new Localizador(true, 1, "hotelName", true, List.of("Pasta"),true, 1,"Avianca" ,true, 200));
        repository.addCliente(cliente2);

        System.out.println("Total ventas: "+repository.getTotalPrice());
        System.out.println("Promedio ventas: "+repository.getAverageSellers());

        System.out.println(repository.getClasificationByHotelName());
        System.out.println(repository.getClasificationByComida());
        System.out.println(repository.getClasificationByAerolinea());
    }
}
