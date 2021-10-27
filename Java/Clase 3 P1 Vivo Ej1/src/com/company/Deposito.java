package com.company;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó el depósito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("NO se realizó el depósito, no tiene permisos");
    }
}
