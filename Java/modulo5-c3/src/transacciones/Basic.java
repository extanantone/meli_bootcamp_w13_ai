package transacciones;

public class Basic extends Cliente implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo {

    @Override
    public double consultarSaldo() {
        double saldo = 0;
        boolean exito = false;
        System.out.println("Consultando saldo de cuenta...");
        if (exito) transaccionOk();
        else transaccionNoOk();
        return saldo;
    }

    @Override
    public void pagarServicio(String inServicio) {
        boolean exito = false;
        System.out.println(String.format("Pagando %s...", inServicio));
        if (exito) transaccionOk();
        else transaccionNoOk();
    }

    @Override
    public void retirarEfectivo(double inMonto) {
        boolean exito = true;
        System.out.println(String.format("Intentando retirar %f...", inMonto));
        if (exito) transaccionOk();
        else transaccionNoOk();
    }
}
