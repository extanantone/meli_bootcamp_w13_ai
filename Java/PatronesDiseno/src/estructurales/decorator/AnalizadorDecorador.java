package estructurales.decorator;

public class AnalizadorDecorador extends DecoradorBase{

    public AnalizadorDecorador(Notificable notificable) {
        super(notificable);
    }

    @Override
    public void notificar(String mensaje) {
        super.notificar(leer(mensaje));
    }

    private String leer(String mensaje){
        return mensaje + " he sido leido para evitar traiciones";
    }
}
