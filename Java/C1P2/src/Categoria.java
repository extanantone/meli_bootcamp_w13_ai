import java.util.HashMap;
import java.util.Map;

public class Categoria {
    private final String tipo;
    private final int valorMenorEdad;
    private final int valorMayorEdad;
    private HashMap<Integer, Persona> registeredList = new HashMap<>();

    public Categoria(String tipo, int valorMenorEdad, int valorMayorEdad) {
        this.tipo = tipo;
        this.valorMenorEdad = valorMenorEdad;
        this.valorMayorEdad = valorMayorEdad;
    }

    public String getTipo() {
        return tipo;
    }

    public int getValorMenorEdad() {
        return valorMenorEdad;
    }

    public int getValorMayorEdad() {
        return valorMayorEdad;
    }

    public HashMap<Integer, Persona> getRegisteredList() {
        return registeredList;
    }

    public void inscribirParticipante(Persona persona) {
        int valorInscripcion;
        if (persona.getEdad() < 18) {
            valorInscripcion = this.valorMenorEdad;
        } else {
            valorInscripcion = this.valorMayorEdad;
        }
        registeredList.put(registeredList.size() + 1, persona);
        System.out.printf("El participante %s %s, DNI: %f, se a inscripto exitosamente a la carrera de categoria Circuito %s abonando un valor de $%d\n",
                persona.getNombre(),
                persona.getApellido(),
                persona.getDni(),
                this.getTipo(),
                valorInscripcion);
    }

    public void mostrarParticipantes() {
        for (Map.Entry<Integer, Persona> p : this.getRegisteredList().entrySet()) {
            Integer numero = p.getKey();
            String nombre = p.getValue().getNombre();
            String apellido = p.getValue().getApellido();
            Double dni = p.getValue().getDni();
            System.out.printf("El participante %s %s, con DNI: %f, tiene el numero de inscripción: %d", nombre, apellido, dni, numero);
        }
    }
    // public void desinscribirParticipante(double dni){
    // }

    // public int montoInscripcion(Persona p){
    // }
}
