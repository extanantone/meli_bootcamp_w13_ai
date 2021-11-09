package ClasesAbstractasEInterfaces.Asteroides;

public class Entidad {
    private String nombre;
    private int posX;
    private int posY;
    private Long puntuacion = (long)0;

    public Entidad(String nombre){
        this.nombre = nombre;
    }

    public Entidad(String nombre, int posX, int posY) {
        this.nombre = nombre;
        this.posX = posX;
        this.posY = posY;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPosX() {
        return posX;
    }


    public int getPosY() {
        return posY;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }
}
