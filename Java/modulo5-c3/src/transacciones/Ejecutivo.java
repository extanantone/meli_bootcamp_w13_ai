package transacciones;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    @Override
    public void depositar(double inMonto) {
        boolean exito = true; // Factor a implementar
        System.out.println(String.format("Depositando %f en cuenta...", inMonto));
        if (exito) transaccionOk();
        else transaccionNoOk();
    }

    @Override
    public void transferir(double inMonto, Cliente inDestinatario) {
        boolean exito = true; // Factor a implementar
        System.out.println(String.format("Transfiriendo %f...", inMonto));
        if (exito) transaccionOk();
        else transaccionNoOk();
    }
}
