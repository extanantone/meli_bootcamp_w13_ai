package ejericiciopractico.e2;

public class EntidadEspacial {
    private String nombre;
    private int posX;
    private int posY;
    private Long puntuacion = (long)0;

    public EntidadEspacial(){}

    public EntidadEspacial(String nombre){
        this.nombre = nombre;
    }



    public EntidadEspacial(String nombre, int posX, int posY) {
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

    public void setPosX(int posX) {
        this.posX = posX;
    }

    public int getPosY() {
        return posY;
    }

    public void setPosY(int posY) {
        this.posY = posY;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    protected void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }
}
