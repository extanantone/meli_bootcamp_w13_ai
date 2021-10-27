package PracticaLibreClasesAbstractas;

public class Main {
    public static void main(String[] args) {

        Planta planta = new Planta();
        AnimalCarnivoro c = new AnimalCarnivoro();
        planta.alimentarse();
        c.alimentarse();
    }
}
