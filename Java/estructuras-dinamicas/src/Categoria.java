import java.util.*;

public class Categoria {

    String nombre;
    List<Participante> participantes = new ArrayList<Participante>();

    public Categoria(String nombre) {
        this.nombre = nombre;
    }
}
