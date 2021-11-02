public class Participante {
    private String nombre;
    private ObjetoJuego naves;
    private int puntaje;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ObjetoJuego getNaves() {
        return naves;
    }

    public void setNaves(ObjetoJuego naves) {
        this.naves = naves;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }
}
