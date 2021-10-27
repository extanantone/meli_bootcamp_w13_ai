package com.app;

public class PagoServicios implements Transaccionable{

    @Override
    public boolean transaccionOk(String rol) {
        return rol.equals("Basic");
    }
    
}
