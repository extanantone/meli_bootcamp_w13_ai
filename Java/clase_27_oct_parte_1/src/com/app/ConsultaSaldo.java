package com.app;

public class ConsultaSaldo implements Transaccionable {

    public ConsultaSaldo(){

    }

    @Override
    public boolean transaccionOk(String rol) {
        return rol.equals("Basic") || rol.equals("Colaborador");
    }
    
}
