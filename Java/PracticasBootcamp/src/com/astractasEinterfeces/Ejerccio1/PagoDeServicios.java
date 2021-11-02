package com.astractasEinterfeces.Ejerccio1;

public class PagoDeServicios implements ITransaccion{

    private String servicio;
    private double valor;

    @Override
    public String transaccionOk() {
        return null;
    }

    @Override
    public String transaccionNoOk() {
        return null;
    }
}
