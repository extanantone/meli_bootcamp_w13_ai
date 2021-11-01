package com.mercadolibre.Enumeradores;

public enum Descuento {
   PAQUETE_COMPLETO(10),
   LOCALIZADORES(5),
   RESERVAS_BOLETOS(5);

   private int porcentajeDescuento;

   Descuento(int descuento){
      this.porcentajeDescuento = descuento;
   }

   public int getPorcentajeDescuento() {
      return porcentajeDescuento;
   }

   public void setPorcentajeDescuento(int porcentajeDescuento) {
      this.porcentajeDescuento = porcentajeDescuento;
   }
}
