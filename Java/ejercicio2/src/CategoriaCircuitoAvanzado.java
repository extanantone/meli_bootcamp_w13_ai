import java.util.HashMap;

public class CategoriaCircuitoAvanzado extends Categoria {
    public CategoriaCircuitoAvanzado() {
        nombre = EnumCategorias.AVANZADO;
        Categoria.participantes = new HashMap<>();
    }

    @Override
    int inscribirParticipante(Participante p) {
        if (p.getEdad() < 18) {
            System.out.println("No se permiten menores de edad en el Circuito Avanzado.");
        }

        int numeroAsignado = proximoNumeroParticipanteAsignar;
        participantes.put(numeroAsignado, p);
        proximoNumeroParticipanteAsignar++;

        System.out.printf(
                "Participante inscripto a Circuito Chico y tiene %s años, el monto a abonar es %s",
                p.getEdad(),
                calcularValorInscripcion(p.getEdad())
        );

        return numeroAsignado;
    }

    @Override
    int calcularValorInscripcion(int edad) {
        return 2800;
    }
}
