package com.astractasEinterfeces.Ejerccio1;

public class RetiroDeEfectivo implements ITransaccion {

    private long valor;

    public RetiroDeEfectivo(long valor) {
        this.valor = valor;
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
