package bootcamp;

import java.util.List;

public class Curriculum implements Imprimible{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("---- Curriculum ----");
        System.out.println(this.persona.toString());
        for (String habilidad : this.habilidades) {
            System.out.println(" · " + habilidad);
        }
    }
}
