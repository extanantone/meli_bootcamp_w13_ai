package estructurales.decorator;

public class DecoradorBase implements Notificable{

    Notificable notificable;

    public DecoradorBase(Notificable notificable) {
        this.notificable = notificable;
    }

    @Override
    public void notificar(String mensaje) {
        notificable.notificar(mensaje);
    }
}
