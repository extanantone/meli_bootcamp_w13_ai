package Java_III.I;

public interface Transaccion {
    default void transaccionOk(){}
    default void transaccionNoOk(){}
}
