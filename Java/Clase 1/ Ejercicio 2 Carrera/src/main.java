import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class main {
    public static void main(String[] args) {
        List<Persona> participantes = new ArrayList<>();
        participantes.add(new Persona(404344300, "Jhon", "Doe", 25, 351341533, 023403456, "A+" ));
        participantes.add(new Persona(40674300, "Pepe", "De", 17, 351341534, 0303423456, "0-" ));
        participantes.add(new Persona(5, "Pepa", "Do", 56, 351345334, 03034343456, "A+" ));
        participantes.add(new Persona(453455430, "Jose", "POe", 21, 351315334, 0304343456, "B+" ));
        participantes.add(new Persona(403453451, "Lucas", "LOLe", 15, 351415334, 787678456, "AB+" ));

        Map<Integer, Persona> Circuito_chico = new HashMap<>();
        Map<Integer, Persona> Circuito_medio = new HashMap<>();
        Map<Integer, Persona> Circuito_avanzado = new HashMap<>();

        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getEdad() < 18 ){
                if (participantes.get(i).getDni() % 2 == 0){
                    Circuito_chico.put(Circuito_chico.size() + 1, participantes.get(i));
                }else {
                    Circuito_medio.put(Circuito_medio.size() + 1, participantes.get(i));
                }
            }else {
                switch (participantes.get(i).getDni() % 3){
                    case 0: Circuito_chico.put(Circuito_chico.size() + 1, participantes.get(i)); break;
                    case 1: Circuito_medio.put(Circuito_medio.size() + 1, participantes.get(i)); break;
                    case 2: Circuito_avanzado.put(Circuito_avanzado.size() + 1, participantes.get(i)); break;
                }


            }
        }
        for (Map.Entry<Integer, Persona> participante : Circuito_chico.entrySet() ){
            int price;
            if (participante.getValue().getEdad() > 18){
                price = 1500;
            }else {
                price = 1300;
            }
            System.out.println("Circuito chico " + participante.getKey() + " Participante " + participante.getValue() + " Pagara " + price + " pesos");
        }

        for (Map.Entry<Integer, Persona> participante : Circuito_medio.entrySet() ){
            int price;
            if (participante.getValue().getEdad() > 18){
                price = 2300;
            }else {
                price = 2000;
            }
            System.out.println("Circuito medio " + participante.getKey() + " Participante " + participante.getValue() + " Pagara " + price + " pesos");
        }

        for (Map.Entry<Integer, Persona> participante : Circuito_avanzado.entrySet() ){
            System.out.println("Circuito avanzado " + participante.getKey() + " Participante " + participante.getValue() + " Pagara 2800");
        }


        Circuito_chico.remove(1);
        System.out.println("--------------------------------------------");

        for (Map.Entry<Integer, Persona> participante : Circuito_chico.entrySet() ){
            int price;
            if (participante.getValue().getEdad() > 18){
                price = 1500;
            }else {
                price = 1300;
            }
            System.out.println("Circuito chico " + participante.getKey() + " Participante " + participante.getValue() + " Pagara " + price + " pesos");
        }

        for (Map.Entry<Integer, Persona> participante : Circuito_medio.entrySet() ){
            int price;
            if (participante.getValue().getEdad() > 18){
                price = 2300;
            }else {
                price = 2000;
            }
            System.out.println("Circuito medio " + participante.getKey() + " Participante " + participante.getValue() + " Pagara " + price + " pesos");
        }

        for (Map.Entry<Integer, Persona> participante : Circuito_avanzado.entrySet() ){
            System.out.println("Circuito avanzado " + participante.getKey() + " Participante " + participante.getValue() + " Pagara 2800");
        }




    }
}
 