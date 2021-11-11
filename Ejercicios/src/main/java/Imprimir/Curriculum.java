package Imprimir;

public class Curriculum extends Documento {

    String habilidades[] = {"Pensamiento creativo", "Resolucion de problemas", "Comunicación efectiva", "Trabajo en equipo", "Colaboración", "Toma de decisiones", "Liderazgo",
            "Negociación"};

    DatosDeLaPersona datosDeLaPersona = new DatosDeLaPersona(36291965, "Blenki", "Gomez", "Programadorx");

    @Override
    public void imprimir() {
        System.out.println("Imprimiendo curriculum de " + datosDeLaPersona);

    }
}
