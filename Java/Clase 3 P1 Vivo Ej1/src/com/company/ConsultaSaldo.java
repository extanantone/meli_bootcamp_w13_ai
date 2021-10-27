package com.company;

public class ConsultaSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("Se realizó la consulta de saldo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("No se realizó la consulta de saldo, no tiene permisos");
    }
}
