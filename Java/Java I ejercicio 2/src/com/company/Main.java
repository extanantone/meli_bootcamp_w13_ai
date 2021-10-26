package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args) {
	// write your code here

       


        Person sebastian = new Person(
                1019095,
                "jhoan",
                "lugo",
                27,
                3212669,
                3212349,
                "O+",
                0,
                0);

        Person jessica = new Person(
                1223232,
                "jessica",
                "camacho",
                25,
                3212349,
                3211099,
                "O-",
                0,
                0

        );

        Person andres = new Person(
                1223233,
                "andres",
                "camacho",
                25,
                3212349,
                3211099,
                "O-",
                0,
                2800

        );
////    setear usuarios en map de corredores, se guarda en un map para no tener dni repetidos

        HashMap<Integer,Person> corredores = new HashMap<>();

        corredores.put(sebastian.getDni(),sebastian);
        corredores.put(jessica.getDni(),jessica);
        corredores.put(andres.getDni(),andres);

///     tipos de inscripcion
///     0:chico,1:medio,2:avanzado

        List<Person> inscripcion_chico = new ArrayList<>();
        List<Person> inscripcion_medio = new ArrayList<>();
        List<Person>  inscripcion_avanzado = new ArrayList<>();

        inscripcion_avanzado.add(andres);

        int i;

        for(Map.Entry<Integer,Person> corredor:corredores.entrySet()) {
            Person persona = corredor.getValue();
            Scanner opcion = new Scanner(System.in);
            System.out.println("Elija una de las siguientes opciones para " + persona.getNombre() + ": 1:chico,2:medio,3:Avanzado,4:eliminar suscripcion");

            switch (opcion.nextInt()) {
                case 1:

                    if(persona.getEdad() < 18 ) {
                        persona.setSaldo(1300);
                    } else {
                        persona.setSaldo(1500);
                    };

                    inscripcion_chico.add(persona);
                    break;

                case 2:
                    System.out.println("aqui");
                    if(persona.getEdad() < 18 ) {
                        persona.setSaldo(1300);
                    } else {
                        persona.setSaldo(1500);
                    };

                    inscripcion_medio.add(persona);
                    break;
                case 3:
                    if(persona.getEdad() >= 18) {
                        persona.setSaldo(2800);

                        inscripcion_avanzado.add(persona);
                    }else {
                        System.out.println("No se permiten menores de edad");
                    };
                    break;
                case 4:

                    if(inscripcion_chico.contains(persona)) {
                        for (i = 0;i < inscripcion_chico.size();i++){
                            if(persona == inscripcion_chico.get(i)){
                                inscripcion_chico.remove(i);
                                continue;

                            };

                        };

                    }else if(inscripcion_medio.contains(persona)) {
                        for (i= 0;i < inscripcion_medio.size();i++){
                            if(persona == inscripcion_chico.get(i)){
                                inscripcion_medio.remove(i);
                                continue;
                            };

                        };
                    }else if(inscripcion_avanzado.contains(persona)){

                        for (i= 0;i < inscripcion_avanzado.size();i++){
                            if(persona == inscripcion_avanzado.get(i)){
                                inscripcion_avanzado.remove(i);
                                break;
                            }

                        };
                    }else {
                        System.out.println("persona no esta inscrita");
                    };
                    break;


                default:
                    System.out.println("opcion no valida");

            };
        };

        System.out.println("Personas inscritas en avanzado");
        for(i=0;i<inscripcion_avanzado.size();i++) {
            inscripcion_avanzado.get(i).setInscripcion(i+1);
            System.out.println(inscripcion_avanzado.get(i).toString());

        };





    }
}
