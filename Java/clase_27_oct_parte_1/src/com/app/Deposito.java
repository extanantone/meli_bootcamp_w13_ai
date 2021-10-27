package com.app;

public class Deposito implements Transaccionable{

    public Deposito(){
        
    }

    @Override
    public boolean transaccionOk(String rol) {
        return rol.equals("Ejecutivo");
    }

    
}
