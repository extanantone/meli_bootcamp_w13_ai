package com.socialmeli.demo.util;

import com.socialmeli.demo.model.Comprador;
import com.socialmeli.demo.model.Producto;
import com.socialmeli.demo.model.Publicacion;
import com.socialmeli.demo.model.Vendedor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
public class TestUtilGenerator {
    public Comprador ordenamiento(){
        String date1= "17-11-2021";
        String date2= "27-11-2021";
        List<String> fechas = new ArrayList<>();
        //añade las fechas de prueba
        fechas.add(date2);
        fechas.add(date1);
        //formatea el codigo
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);
        //vendedores de pruebas
        Comprador compra = new Comprador("comprador 1", 1);
        Vendedor vende = new Vendedor("Pepito",50);
        Vendedor vende2 = new Vendedor("Pepita",40);

        //Nuevo producto
        Producto newPrduct = new Producto(1,"mesa","cocina", "rimax","plata","mesa de campo");
        vende.getPublicaciones().add(new Publicacion(50,10, fecha1,newPrduct,50,1000,false,0));
        vende2.getPublicaciones().add(new Publicacion(40,20, fecha2,newPrduct,50,1000,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);
        return  compra;
    }
    public Comprador ordenamientoPost(){
        String date1= "17-10-2021";
        String date2= "21-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date2);
        fechas.add(date1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha1 = LocalDate.parse(date1, formatter);
        LocalDate fecha2 = LocalDate.parse(date2, formatter);

        Comprador compra = new Comprador("comprador 2", 2);
        Vendedor vende = new Vendedor("Pepito",15);
        Vendedor vende2 = new Vendedor("Pepita",16);

        Producto prod = new Producto(1,"Mesa","Comer", "Rimax","Blanco","Ninguno");
        vende.getPublicaciones().add(new Publicacion(15,15, fecha1,prod,100,500,false,0));
        vende2.getPublicaciones().add(new Publicacion(16,19, fecha2,prod,100,500,false,0));
        compra.getSiguiendo().add(vende);
        compra.getSiguiendo().add(vende2);
        return  compra;
    }
    public  Publicacion postPrueba(){
        String date2= "27-11-2021";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d-MM-yyyy");
        LocalDate fecha2 = LocalDate.parse(date2, formatter);
        Producto prod = new Producto(1,"plato","porcelana", "corona","bambu","ninguna");
        Publicacion pub = new Publicacion(20,1, fecha2,prod,100,2000,false,0);
        return  pub;
    }
    public List<String> devolverFechas(){
        String date2= "27-11-2021";
        String date1= "17-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date1);
        fechas.add(date2);
        return fechas;
    }
    public List<String> fechasOrdenadas(){
        String date2= "27-11-2021";
        String date1= "17-11-2021";
        List<String> fechas = new ArrayList<>();
        fechas.add(date2);
        fechas.add(date1);
        return fechas;
    }

}
