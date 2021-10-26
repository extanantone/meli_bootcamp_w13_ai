package java2;

import com.company.Participante;
import jdk.swing.interop.SwingInterOpUtils;

import java.util.HashMap;

public class Main {
    public static void main(String[] args){


        HashMap<Integer, String> nombreIMC = new HashMap<>();
        nombreIMC.put(-1,"Bajo peso");
        nombreIMC.put(0, "Peso saludable");
        nombreIMC.put(1, "Sobrepeso");

        Persona personaUno = new Persona();
        Persona personaDos = new Persona("Maria",30,"1234");
        Persona personaTres = new Persona("Pepe", 24, "112233",60,176);

        System.out.println("Información de la persona");
        System.out.println();

        String imc = nombreIMC.get(personaTres.calcularIMC());
        System.out.println("Calculo de IMC: "+imc);
        System.out.println("Mayor de edad: "+personaTres.esMayorDeEdad());
        System.out.println("Información personal: "+personaTres.returnPersona());
    }
}
