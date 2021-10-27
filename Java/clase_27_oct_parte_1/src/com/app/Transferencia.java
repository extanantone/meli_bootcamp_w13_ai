package com.app;

public class Transferencia implements Transaccionable{

    public Transferencia(){
        
    }

    @Override
    public boolean transaccionOk(String rol) {
        return rol.equals("Ejecutivo");
    }
    
}
