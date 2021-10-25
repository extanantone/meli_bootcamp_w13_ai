import java.util.HashMap;

public class Categoria {
    String nombre;
    int costoMayor;
    int costoMenor;
    int distancia;
    HashMap<Integer,Persona> participantes;

    public Categoria(String nombre,int distancia, int costoMayor, int costoMenor) {
        this.nombre = nombre;
        this.costoMayor = costoMayor;
        this.costoMenor = costoMenor;
        this.distancia = distancia;
        this.participantes = new HashMap<>();
    }

    public void setParticipante(int dni, Persona persona) {
        participantes.put(dni,persona);
        System.out.println("El costo de inscripcion es: " + (persona.getEdad()>17 ? costoMayor : costoMenor));
    }

    public HashMap<Integer, Persona> getParticipantes() {
        return participantes;
    }

    public void deleteParticipante(int dni){
        participantes.remove(dni);
        System.out.println("Se elimino el participante con dni: " + dni);
    }
}
