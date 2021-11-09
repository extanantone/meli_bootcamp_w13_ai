package Banco;

public class Basic implements ConsultaDeSaldo, PagarServicio, RetirarFvo {
    //realizan consulta de saldo, pago de servicios y retiro de fvo

    @Override
    public void consultarSaldo() {
        System.out.println("Consultando su saldo");
    }

    @Override
    public void pagarServicio(String tipo) {
        System.out.println("Pagar " + tipo);
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
