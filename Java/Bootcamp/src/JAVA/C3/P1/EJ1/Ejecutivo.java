package JAVA.C3.P1.EJ1;

public class Ejecutivo extends Cliente {
    @Override
    public boolean hacerTransaccion(Transaccionable transaccionable) {
        if (transaccionable instanceof Transferencia || transaccionable instanceof Deposito) {
            return transaccionable.transaccionOk();
        } else {
            return transaccionable.transaccionNoOk();
        }
    }
}
