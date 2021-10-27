package com.app;

public interface Transaccionable{
    
    boolean transaccionOk(String rol);

    default boolean transaccionNoOk(String rol){
        return !transaccionOk(rol);
    };
}