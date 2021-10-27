package com.company;

public class Transferencia implements Transaccion {

    @Override
    public void transaccionOk() {
        System.out.println("Se realizó la transferencia");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizó la transferencia, no tiene permisos");
    }
}
