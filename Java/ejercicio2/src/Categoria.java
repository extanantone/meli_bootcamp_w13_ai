import java.util.HashMap;
import java.util.Map;

public abstract class Categoria {
    protected static EnumCategorias nombre;
    protected static Map<Integer, Participante> participantes;
    protected int proximoNumeroParticipanteAsignar = 0;


    abstract int inscribirParticipante(Participante p);

    abstract int calcularValorInscripcion(int edad);

    public void desinscribirParticipante(int numeroAsignado) {
        if (!participantes.containsKey(numeroAsignado)) return;
        participantes.remove(numeroAsignado);
        System.out.printf("El participante numero %s de la categoria Circuito %s fue desinscripto con exito.%n", numeroAsignado, nombre);
    }

    public String mostrarParticipantes() {
        if (participantes.isEmpty()) return "No hay participantes inscriptos!";

        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Map.Entry<Integer, Participante> p : participantes.entrySet()) {
            sb.append("(Numero Asignado: ");
            sb.append(p.getKey()).append(", Datos: ").append(p.getValue().toString());
            sb.append(")");
        }
        sb.append("]");
        return sb.toString();
    }
}
