package Banco;

public class Cobrador implements RetirarFvo, ConsultaDeSaldo{
    //realizan retiro de fvo y consulta de saldos

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando su saldo");
    }

    @Override
    public void retirarFvo(Double monto) {
        System.out.println("vas a retirar " + monto);
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
