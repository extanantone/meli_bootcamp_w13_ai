package com.company;

public class Cobradores extends Cliente{
    @Override
    void realizarOperacion(Transaccion transaccion) {
        System.out.println(">>>>>" + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        }
        else
            transaccion.transaccionNoOk();
    }
}
