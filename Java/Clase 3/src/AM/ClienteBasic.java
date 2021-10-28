package AM;

public class ClienteBasic extends Cliente implements Transaccion {
    public ClienteBasic(String nombre, String apellido, int nroDeCliente) {
        super(nombre, apellido, nroDeCliente);
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}