package com.company;

public class Main {

    public static void main(String[] args) {
        Cliente ejecutivo = new Ejecutivo();
        Cliente cobrador = new Cobradores();
        Cliente basic = new Basic();

        ejecutivo.realizarOperacion(new Deposito());
        ejecutivo.realizarOperacion(new RetiroEfectivo());

        cobrador.realizarOperacion(new Transferencia());
        cobrador.realizarOperacion(new PagoServicios());

        basic.realizarOperacion(new PagoServicios());
    }
}
