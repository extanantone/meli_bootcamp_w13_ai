package JAVA.C3.P1.EJ1;

public class Transferencia implements Transaccionable{

    @Override
    public boolean transaccionOk() {
        return true;
    }

    @Override
    public boolean transaccionNoOk() {
        return false;
    }
}
