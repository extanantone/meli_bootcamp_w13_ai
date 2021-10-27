package com.company;

public class Ejecutivo extends Cliente{
    @Override
    void realizarOperacion(Transaccion transaccion) {
        System.out.println(">>>>>" + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
        if(transaccion instanceof Deposito || transaccion instanceof Transferencia){
            transaccion.transaccionOk();
        }
        else
            transaccion.transaccionNoOk();
    }
}
