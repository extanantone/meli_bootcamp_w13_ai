package Banco;

public class Ejecutivo implements Deposito, Transferencia{
    //realizan depósitos y transferencias

    @Override
    public void deposito() {
        System.out.println("deposito");
    }

    @Override
    public void transferencia() {
        System.out.println("Realizando transferencia");
    }

    @Override
    public void transaccionOK(String tipoTransaccion) {
        System.out.println( tipoTransaccion + " realizadx con éxito");
    }

    @Override
    public void transaccionNoOk(String tipoTransaccion){
        System.out.println("La transaccion " + tipoTransaccion + " no se pudo realizar");
    }
}
