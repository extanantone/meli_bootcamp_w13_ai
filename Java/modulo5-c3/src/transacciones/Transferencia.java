package transacciones;

public interface Transferencia extends Transaccion {
    public void transferir(double inMonto, Cliente inDestinatario);
}
