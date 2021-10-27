package Parte1;

public class RetiroDeEfectivo implements Transaccionable{
    @Override
    public boolean transaccionOk() {
        return false; //re-Definir que hacer
    }

    @Override
    public boolean transaccionNoOk() {
        return false; //re-Definir que hacer
    }
}
