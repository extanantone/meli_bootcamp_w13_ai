package AM;

public class ClienteEjecutivo extends Cliente implements Transaccion {
    public ClienteEjecutivo(String nombre, String apellido, int nroDeCliente) {
        super(nombre, apellido, nroDeCliente);
    }

    @Override
    public void transaccionOk() {

    }

    @Override
    public void transaccionNoOk() {

    }
}