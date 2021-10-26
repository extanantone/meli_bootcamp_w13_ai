import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args){
        Persona fulano = new Persona();
        Persona juan = new Persona("Juan", 32, "34315958");
        Persona pedro = new Persona("Pedro", 21, "34123456", 71, 1.73);

        Persona.toString(pedro);

        int imc = pedro.calcularIMC();
        String nivelDePeso;
        String esMayorMenor;

        if (pedro.esMayorDeEdad()){
            esMayorMenor = "Es mayor de edad";
        } else {
            esMayorMenor = "Es menor de edad";
        }
        if (imc < 0){
            nivelDePeso = "Bajo peso";
        } else if (imc == 0){
            nivelDePeso = "Peso saludable";
        } else {
            nivelDePeso = "Sobrepeso";
        }
        System.out.printf("Nivel de peso: %s\n",nivelDePeso );
        System.out.println(esMayorMenor);




    }
}
