package estructurales.decorator;

/**
 * El compilador no obliga a sobreescribir los metodos de la interface a los que heredan del decorador base,
 * pero para que se peuda decorar el metodo se debe sobreescribir los metodos de la interface
 */
public class CodificarNotificacion extends DecoradorBase{


    public CodificarNotificacion(Notificable notificable) {
        super(notificable);
    }

    @Override
    public void notificar(String mensaje) {
        super.notificar(codificar(mensaje));
    }

    private String codificar(String mensaje){
        return mensaje + " he sido codificado ";
    }
}
