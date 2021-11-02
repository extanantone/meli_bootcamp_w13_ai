package com.ejerciciosIntegradores.Integrador1.modelAgenciaTurismo;

import com.ejerciciosIntegradores.Integrador1.Interfaces.IReserva;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Localizador {

   private Viajero viajero;
   private IReserva reserva;
   private double precioTotal;
   static List<Object> objects = new ArrayList<>();


   public Localizador(Viajero viajero, IReserva reserva) {
      this.viajero = viajero;
      this.reserva = reserva;
      precioTotal = reserva.getPrecio();
   }

   public Viajero getViajero() {
      return viajero;
   }

   public void setViajero(Viajero viajero) {
      this.viajero = viajero;
   }

   public IReserva getReserva() {
      return reserva;
   }

   public void setReserva(IReserva reserva) {
      this.reserva = reserva;
   }

   public void descuentosCompra(Repositorio repositorio){

      String comprasArray[] = reserva.getCompra().split(",");
      List<String> compras = new ArrayList<>(Arrays.asList(comprasArray));

      int cont =0;
      for (Localizador localizador: repositorio.getLocalizadors()) {
         if(localizador.getViajero().getDni()==this.viajero.getDni()){
            cont++;
         }
      }

      double descuenta = 0;
      if(cont >=2){
         descuenta += 0.05;
      }

      if(reserva.getCompra().contains("Hotel")&&reserva.getCompra().contains("Transporte")&&reserva.getCompra().contains("Comida")&&reserva.getCompra().contains("Boleto")){
        // System.out.println("Descuenta 10%");
         descuenta += 0.10;
      }

      if(compras.stream().filter(a->a.equals("Hotel")).count()>1 || compras.stream().filter(a->a.equals("Boleto")).count()>1 ){
         descuenta += 0.05;
      }
      if(descuenta>0){
         precioTotal -= (reserva.getPrecio()*descuenta);
      }


   }

   public double getPrecioTotal() {
      return precioTotal;
   }

   public void setPrecioTotal(double precioTotal) {
      this.precioTotal = precioTotal;
   }
}
