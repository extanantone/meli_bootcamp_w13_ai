package JAVA.C3.P1.EJ1;

public class Basic extends Cliente {
    @Override
    public boolean hacerTransaccion(Transaccionable transaccionable) {
        if (transaccionable instanceof ConsultaSaldo || transaccionable instanceof PagoServicio || transaccionable instanceof RetiroEfectivo) {
            return transaccionable.transaccionOk();
        } else {
            return transaccionable.transaccionNoOk();
        }
    }
}
