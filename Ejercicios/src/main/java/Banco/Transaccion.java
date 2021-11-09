package Banco;

public interface Transaccion {
    public abstract void transaccionOK(String tipoTransaccion);
    public abstract void transaccionNoOk(String tipoTransaccion);
}
