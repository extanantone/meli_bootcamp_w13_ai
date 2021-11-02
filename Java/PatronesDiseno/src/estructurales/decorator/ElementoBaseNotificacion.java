package estructurales.decorator;

public class ElementoBaseNotificacion implements Notificable{

    @Override
    public void notificar(String mensaje) {
        System.out.println("notifico al destinatario el siguiente mensaje: " + mensaje);
    }
}
