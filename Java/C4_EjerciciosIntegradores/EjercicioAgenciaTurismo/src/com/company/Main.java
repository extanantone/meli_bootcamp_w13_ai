package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static List<Localizador> prepararPrueba(){
        List<Localizador> repositorioCliente = new ArrayList<>();

        Localizador l = new Localizador();

        List<Reserva> listaReservas = new ArrayList<>();
        Reserva r;

        r = new ReservaBoletos();
        listaReservas.add(r);
        r = new ReservaHotel();
        listaReservas.add(r);
        r = new ReservaHotel();
        listaReservas.add(r);
        r = new ReservaTransporte();
        listaReservas.add(r);
        r = new ReservaComida();
        listaReservas.add(r);
        listaReservas.add(r);

        l.setListaReserva(listaReservas);
        repositorioCliente.add(l);
        repositorioCliente.add(l);
        return repositorioCliente;
    }

    public static void mostrarResultados(List<Localizador> repositorioCliente){
        Map<String, Integer> resumenReservas = new HashMap<String, Integer>();
        int i = 1;
        for (Localizador l:repositorioCliente) {
            System.out.println("Entre");
            List<Reserva> listaReserva = l.getListaReserva();

            System.out.println("Buscando en su viaje numero"+i);
            i++;
            for (Reserva r: listaReserva) {
                try{
                    resumenReservas.put(r.getNombreReserva(),resumenReservas.get(r.getNombreReserva())+1);
                }catch (NullPointerException e){
                    resumenReservas.put(r.getNombreReserva(),1);
                }
            }
            //resumenReservas.forEach((k,v)-> System.out.println("Tipo reserva:"+k+", la cantidad:"+v));
        }
        System.out.println("Revisando descuentos");
        int descuento = 0;
        if (repositorioCliente.size()>=2){
            descuento = 5;
            System.out.println("Usted tiene un descuento de 5% porque adquirio 2 o mas localizadores");
        }
        try{
            if (resumenReservas.get("boletos")>0 && resumenReservas.get("hotel")>0 && resumenReservas.get("comida")>0 && resumenReservas.get("transporte")>0 ){
                descuento+=10;
                System.out.println("Usted tiene un descuento del 10% ya que adquirio al menos un paquete completo");
            }
        }catch (NullPointerException e){

        } finally {
            try {
                if (resumenReservas.get("boletos")>=2 || resumenReservas.get("hotel")>=2){
                    descuento+=5;
                    System.out.println("Usted tiene un descuento del 5%, por adquirir reservas de boletos o de hotel en cantidad");
                }
            }catch (NullPointerException e){

            } finally {
                System.out.println("Su descuento es de: "+descuento);
            }
        }
    }

    public static void main(String[] args) {
        //Preparo parametros de prueba
        List<Localizador> repositorioCliente = prepararPrueba();
        System.out.println("Las reservas del cliente son las siguientes:");
        AgenciaTurismo agencia = new AgenciaTurismo(repositorioCliente);
        agencia.diccionarioReservasClasificadasPorTipo();
        //mostrarResultados(repositorioCliente);


    }
}
