public class Participante {
    private String nombre;
    private Nave nave;

    public Participante (String inNombre, Nave inNave) {
        this.nombre = inNombre;
        this.nave = inNave;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Nave getNave() {
        return this.nave;
    }

    public void incPuntajeDeNave() {
        this.nave.incPuntos();
    }

    public Integer getPuntajeDeNave() {
        return this.nave.getPuntos();
    }
}
