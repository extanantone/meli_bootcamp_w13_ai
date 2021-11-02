package com.astractasEinterfeces.Ejerccio1;

public class Deposito implements  ITransaccion{

   private double valor;
   private long cuenta;

    public Deposito(double valor, long cuenta) {
        this.valor = valor;
        this.cuenta = cuenta;
    }

    @Override
    public String transaccionOk() {
        return "Transaccion Exitosa";
    }

    @Override
    public String transaccionNoOk() {
        return "No se puedu relizar el deposito ";
    }
}
