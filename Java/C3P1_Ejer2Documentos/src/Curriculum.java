import java.util.Arrays;

public class Curriculum extends Documento{
    String nombre;
    String[] habilidades;

    public Curriculum(String nombre, String[] habilidades) {
        this.nombre = nombre;
        this.habilidades = habilidades;
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                "nombre='" + nombre + '\'' +
                ", habilidades=" + Arrays.toString(habilidades) +
                '}';
    }
}
