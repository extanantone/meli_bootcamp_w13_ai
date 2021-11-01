package transacciones;

public interface Transaccion {
    public default void transaccionOk() {
        System.out.println("Transacción completada con éxito");
    }
    public default void transaccionNoOk() {
        System.out.println("Transacción incompleta");
    }
}
