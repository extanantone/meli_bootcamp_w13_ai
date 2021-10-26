public class Main {
    public static void main(String[] args) {
        Persona persona0  = new Persona();
        Persona persona1 = new  Persona("carlos", 33, 1733320, 68, 1.70);
        Persona persona2 = new Persona("david", 30, 2312342);

        System.out.println("Es mayor de edad "+ persona1.esMayorDeEdad());
        int indicePersona1 = persona1.calcularMC();
        String Result = indicePersona1 == -1 ? "Bajo Peso" : (indicePersona1 == 0 ? " Peso saludable" : "Sobrepeso");
        System.out.println("Su indice Coporal es " + Result);

    }
}
