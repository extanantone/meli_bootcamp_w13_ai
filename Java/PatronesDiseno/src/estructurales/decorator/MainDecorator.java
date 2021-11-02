package estructurales.decorator;

public class MainDecorator {
    public static void main(String[] args) {
        String mensaje = "hola ricardo";

        DecoradorBase notificador = new DecoradorBase(new AnalizadorDecorador(new CodificarNotificacion(new ElementoBaseNotificacion())));
        DecoradorBase notificador2 = new DecoradorBase(new CodificarNotificacion(new ElementoBaseNotificacion()));

        notificador.notificar(mensaje);
        notificador2.notificar(mensaje);



    }
}
