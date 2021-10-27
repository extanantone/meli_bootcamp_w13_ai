package com.app;

public class RetiroEfectivo implements Transaccionable{

    public RetiroEfectivo(){

    }

    @Override
    public boolean transaccionOk(String rol) {
        return rol.equals("Basic") || rol.equals("Colaborador");
    }
    
}
