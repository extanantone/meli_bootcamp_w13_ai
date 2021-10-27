package ejericiciopractico.e2;

/**
 * La nave simple obtiene punutaicon
 */
public class NaveSimple extends EntidadEspacial implements Puntuable{

    public NaveSimple(String nombre, int posX, int posY) {
        super(nombre, posX, posY);
    }

    @Override
    public double calcularDistancia(int targetX, int targetY) {
        return Math.sqrt(Math.pow(getPosX() - targetX,2) + Math.pow(getPosY() - targetY,2));
    }

    @Override
    public void puntuar() {
        setPuntuacion(getPuntuacion()+1);
    }

    @Override
    public Long obtenerPuntuacion() {
        return getPuntuacion();
    }

    @Override
    public String obtenerIdentificacion() {
        return getNombre();
    }
}
