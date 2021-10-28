package JAVA.C3.P1.EJ3;

public interface Alimentable {
    public static String comerAnimal(Animal animal) {
        if (animal.getTipoAnimal() == 1) {
            return comerHierba();
        } else {
            return comerCarne();
        }
    }

    public static String comerHierba() {
        return "Como hierba.";
    }

    public static String comerCarne() {
        return "Como carne.";
    }
}
