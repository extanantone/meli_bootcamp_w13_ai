package INTERFACESP1VIVO;

public interface Depositable extends Transacciones {
    @Override
    void transaccionOk();

    @Override
    void transaccionNotOk();
}
