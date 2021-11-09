package ClasesAbstractasEInterfaces.Asteroides;


public class Nave extends Entidad implements Puntuable{

    public Nave (String nombre, int posX, int posY){
        super(nombre, posX, posY);
    }

    @Override
    public double calcularDistancia(int x, int y) {
        return Math.sqrt(Math.pow(getPosX() - x,2) + Math.pow(getPosY() - y,2));
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
