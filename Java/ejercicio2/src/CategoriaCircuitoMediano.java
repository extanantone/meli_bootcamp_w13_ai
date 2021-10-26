import java.util.HashMap;

public class CategoriaCircuitoMediano extends Categoria {

    public CategoriaCircuitoMediano() {
        Categoria.nombre = EnumCategorias.MEDIANO;
        Categoria.participantes = new HashMap<>();
    }

    @Override
    int inscribirParticipante(Participante p) {
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
        return edad < 18 ? 2000 : 2300;
    }
}
