public class Main {
    public static void main(String[] args) {
        Persona personaDefault = new Persona();
        Persona personaConstructorTresParametros = new Persona("Lautaro", 21, "42218782");
        Persona personaContructorTodosParametros = new Persona("Rocio", 22, "41000024", 61.3, 1.70);

        System.out.printf("La persona %s es mayor de edad? %s%n",
                personaContructorTodosParametros.toString(), personaContructorTodosParametros.esMAyorDeEdad());

        System.out.printf("IMC de la persona %s es: %s",
                personaContructorTodosParametros.toString(), mostrarIMC(personaContructorTodosParametros.calcularIMC()));
    }

    static String mostrarIMC(int imc) {
        switch (imc) {
            case -1:
                return "Bajo peso";
            case 0:
                return "Peso saludable";
            case 1:
               return "Sobrepeso";
            default:
                return "IMC incorrecto";
        }
    }
}
