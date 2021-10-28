package AM;

public class ClienteCobrador extends Cliente implements Transaccion {
    public ClienteCobrador(String nombre, String apellido, int nroDeCliente) {
        super(nombre, apellido, nroDeCliente);
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}