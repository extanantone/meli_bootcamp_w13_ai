package com.company;

public class RetiroEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó el retiro de efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizó el retiro de efectivo, no tiene permisos");
    }
}
