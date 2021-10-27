package com.company;

public class Basic extends Cliente{
    @Override
    void realizarOperacion(Transaccion transaccion) {
        System.out.println(">>>>>" + this.getClass().getName().substring(this.getClass().getName().lastIndexOf(".") + 1));
        if(transaccion instanceof ConsultaSaldo || transaccion instanceof PagoServicios ||transaccion instanceof RetiroEfectivo){
            transaccion.transaccionOk();
        }
        else
            transaccion.transaccionNoOk();
    }
}
