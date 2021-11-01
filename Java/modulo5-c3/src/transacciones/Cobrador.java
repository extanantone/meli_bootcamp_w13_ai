package transacciones;

public class Cobrador extends Cliente implements RetiroDeEfectivo, ConsultaDeSaldo {
    @Override
    public double consultarSaldo() {
        double saldo = 7;
        boolean exito = false;
        System.out.println("Consultando saldo de cuenta...");
        if (exito) transaccionOk();
        else transaccionNoOk();
        return saldo;
    }

    @Override
    public void retirarEfectivo(double inMonto) {
        boolean exito = true;
        System.out.println(String.format("Intentando retirar %f...", inMonto));
        if (exito) transaccionOk();
        else transaccionNoOk();
    }
}
