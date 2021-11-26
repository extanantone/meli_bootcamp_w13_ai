package com.example.socialMeli.utils;

import com.example.socialMeli.dto.CompradoresDTO;
import com.example.socialMeli.dto.SeguidoresDTO;
import com.example.socialMeli.model.Comprador;
import com.example.socialMeli.model.Producto;
import com.example.socialMeli.model.Publicacion;
import com.example.socialMeli.model.Vendedor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
@NoArgsConstructor
public class SocialMeliUtils {
    public Comprador utilizarEnElOrdenamiento(){
        String date1= "14-11-2021";
        String date2= "20-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date2);
        fechas.add(date1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);

        Comprador compra = new Comprador("comprador 1", 1);
        Vendedor vende = new Vendedor("Ximena",23);
        Vendedor vende2 = new Vendedor("Camilo",24);

        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");
        vende.getPublicaciones().add(new Publicacion(23,1, fecha1,prod,100,10000,false,0));
        vende2.getPublicaciones().add(new Publicacion(24,12, fecha2,prod,100,10000,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);
        return  compra;
    }
    public Comprador utilizarEnElOrdenamientoFechaPasada(){
        String date1= "14-10-2021";
        String date2= "20-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date2);
        fechas.add(date1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);

        Comprador compra = new Comprador("comprador 1", 1);
        Vendedor vende = new Vendedor("Ximena",23);
        Vendedor vende2 = new Vendedor("Camilo",24);

        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");
        vende.getPublicaciones().add(new Publicacion(23,1, fecha1,prod,100,10000,false,0));
        vende2.getPublicaciones().add(new Publicacion(24,12, fecha2,prod,100,10000,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);
        return  compra;
    }
    public List<String> devolverFechas(){
        String date2= "20-11-2021";
        String date1= "14-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date1);
        fechas.add(date2);
        return fechas;
    }
    public List<String> devolverFechasDesc(){
        String date2= "20-11-2021";
        String date1= "14-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date2);
        fechas.add(date1);
        return fechas;
    }
    public  Publicacion postQuemado(){
        String date2= "20-11-2021";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha2 = LocalDate.parse(date2, formatter);
        Producto prod = new Producto(1,"silla","gamer", "pollito","negro","nada");
        Publicacion pub = new Publicacion(23,1, fecha2,prod,100,10000,false,0);
        return  pub;
    }
}
