package JAVA.C3.P1.EJ1;

public class Cobradores extends Cliente{
    @Override
    public boolean hacerTransaccion(Transaccionable transaccionable) {
        if (transaccionable instanceof RetiroEfectivo || transaccionable instanceof ConsultaSaldo) {
            return transaccionable.transaccionOk();
        } else {
            return transaccionable.transaccionNoOk();
        }
    }
}
