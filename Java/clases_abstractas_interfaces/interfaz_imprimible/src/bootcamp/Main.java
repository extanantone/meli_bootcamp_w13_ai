package bootcamp;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Imprimible documento;

        documento = new Informe("Este es el cuerpo de mi informe", 20,
                                "Alejandro Ferrero", "Nicolas Suarez");

        Imprimible.imprimir(documento);

        documento = new LibroPDF(216, "Jorge Luis Borges", "El Aleph", "Ficcion moderna");
        Imprimible.imprimir(documento);

        Persona p = new Persona("Juan Ferrero", 23, 40001002L, "Bv San Juan 510, Córdoba");
        List<String> hab = new ArrayList<>();
        hab.add("Cocinar");
        hab.add("Programar en C y Python");
        hab.add("Idiomas: Ingles y Ruso");
        documento = new Curriculum(p, hab);
        Imprimible.imprimir(documento);

    }
}
