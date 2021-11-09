package Banco;

public class Main {

    public static void main(String[] args) {
        Ejecutivo ejecutivo = new Ejecutivo();
        ejecutivo.deposito();
        ejecutivo.transaccionOK("Depósito");
        ejecutivo.transferencia();
        ejecutivo.transaccionNoOk("transferencia");

        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.transaccionOK("consulta");
        basic.pagarServicio("Agua");
        basic.transaccionOK("Pagar servicio");
        basic.retirarFvo(333.0);
        basic.transaccionNoOk("retirar efectivo");

        Cobrador cobrador = new Cobrador();
        cobrador.consultarSaldo();
        cobrador.transaccionNoOk("consultar saldo");
        cobrador.retirarFvo(333.0);
        cobrador.transaccionOK("retirar efectivo");

    }

}
