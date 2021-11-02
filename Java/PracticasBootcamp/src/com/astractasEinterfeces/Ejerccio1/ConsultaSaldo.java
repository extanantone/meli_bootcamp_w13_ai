package com.astractasEinterfeces.Ejerccio1;

public class ConsultaSaldo implements ITransaccion{

    private long cuenta;

    public ConsultaSaldo(long cuenta) {
        this.cuenta = cuenta;
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
