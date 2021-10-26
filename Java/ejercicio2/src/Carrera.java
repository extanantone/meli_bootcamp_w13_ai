import java.util.HashMap;
import java.util.Map;

public class Carrera {
    protected Map<EnumCategorias, Categoria> categorias;
    protected Map<String, Integer> inscriptos;

    public Carrera() {
        categorias = new HashMap<>();
        inscriptos = new HashMap<>();
        categorias.put(EnumCategorias.CHICO, new CategoriaCircuitoChico());
        categorias.put(EnumCategorias.MEDIANO, new CategoriaCircuitoMediano());
        categorias.put(EnumCategorias.AVANZADO, new CategoriaCircuitoAvanzado());
    }

    public void inscribirParticipante(Participante participante, EnumCategorias categoria) {
        if (!verificarInscriptosRepetidos(participante)) return;
        int numeroAsignado = categorias.get(categoria).inscribirParticipante(participante);
        inscriptos.put(participante.getDni(), numeroAsignado);
    }

    private boolean verificarInscriptosRepetidos(Participante participante) {
        if (inscriptos.containsKey(participante.getDni())) {
            System.out.println("Esta persona ya se encuentra inscripta a una categoria.");
            return false;
        }
        return true;
    }

    public void mostrarParticipantesDeCategoria(EnumCategorias categoria) {
        System.out.println(categorias.get(categoria).mostrarParticipantes());
    }

    public void desinscribirParticipante(String dni) {
        if (!inscriptos.containsKey(dni)) {
            System.out.printf("No se encontro ningun perticipante con el dni %s %n", dni);
            return;
        }

        int numeroAsignado = inscriptos.get(dni);
        for (Categoria c : categorias.values()) {
            c.desinscribirParticipante(numeroAsignado);
        }
        inscriptos.remove(dni);
    }
}
