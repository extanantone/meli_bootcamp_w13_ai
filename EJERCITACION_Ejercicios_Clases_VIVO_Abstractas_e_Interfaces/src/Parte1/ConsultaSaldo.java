package Parte1;

public class ConsultaSaldo implements Transaccionable{


    @Override
    public boolean transaccionOk() {
        return false; //re-Definir que hacer
    }

    @Override
    public boolean transaccionNoOk() {
        return false; //re-Definir que hacer
    }
}
