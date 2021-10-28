package ej1.interfaces;

public interface Transaccion {
    default boolean transaccionNoOk(){
        return true;
    };

    default boolean transaccionOk(){
        return false;
    };
}
