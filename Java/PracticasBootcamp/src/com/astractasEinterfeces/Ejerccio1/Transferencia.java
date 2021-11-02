package com.astractasEinterfeces.Ejerccio1;

public class Transferencia implements  ITransaccion{

    private double valor;
    private long cuentaOrigen;
    private long CuentaDestino;

    public Transferencia(double valor, long cuentaOrigen, long cuentaDestino) {
        this.valor = valor;
        this.cuentaOrigen = cuentaOrigen;
        CuentaDestino = cuentaDestino;
    }

    @Override
    public String transaccionOk() {
        return null;
    }

    @Override
    public String transaccionNoOk() {
        return null;
    }
}
