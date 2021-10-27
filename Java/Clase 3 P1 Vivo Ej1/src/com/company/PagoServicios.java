package com.company;

public class PagoServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó el pago de servicios");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizó el pago de servicios, no tiene permisos");
    }
}
