package com.company;

import java.util.*;

public class Colecciones {

    public static void main(String[] args) {

        List<Persona> participantes = new ArrayList<>();

        participantes.add(new Persona(1111, "Danuit", "petro", 34, "304-580", "343-34", "A+"));
        participantes.add(new Persona(2222, "David", "Osio", 18, "232-23", "2333-44", "A+"));
        participantes.add(new Persona(4444, "Carlos", "Cardenas", 34, "234-543", "43-433", "O+"));
        participantes.add(new Persona(5555, "Frant", "Jimenez", 20, "234-543", "43-564", "AB+"));
        participantes.add(new Persona(66666, "Sergio", "Cuervo", 16, "234-789", "45-6543", "O+"));
        participantes.add(new Persona(77777, "Ana", "Quiñones", 25, "273-543", "34-5432", "O+"));
        participantes.add(new Persona(88888, "Maria", "Salazar", 30, "234-896", "56-6433", "A-"));
        participantes.add(new Persona(999999, "Claudia", "Usuga", 17, "344-675", "34-5432", "O-"));
        participantes.add(new Persona(33111233, "Felipe", "Vened", 15, "345-764", "34-2444", "AB-"));

        Map<Long,Persona> circuitoChico = new HashMap();
        Map<Long,Persona> ciruitoMedio = new HashMap<>();
        Map<Long,Persona> circuitoAvanzado = new HashMap<>();

      Scanner scanner = new Scanner(System.in);
        int numeroParticipante = 1;
        for (Persona p : participantes) {

            boolean estado = true;
            do {
                System.out.println("Escoja a que categoria Ingresa el participante "+p.getNombre()+"\n 1-Circuito Chico \n 2-Circuito Medio \n 3-Circuito Avanzado \n 4-No inscribir");
                int opcion = scanner.nextInt();
                if (opcion == 1) {
                    p.setNumeroParticioante(numeroParticipante);
                    circuitoChico.put(p.getDni(), p);
                    estado = false;
                } else if (opcion == 2) {
                    p.setNumeroParticioante(numeroParticipante);
                    ciruitoMedio.put(p.getDni(), p);
                    estado = false;
                } else if (opcion == 3) {
                    if (p.getEdad() > 18) {
                        p.setNumeroParticioante(numeroParticipante);
                        circuitoAvanzado.put(p.getDni(), p);
                        estado = false;
                    } else {
                        System.out.println("No tiene  la edad para la catgoria");
                       // scanner = new Scanner(System.in);
                    }

                } else {
                    estado = false;
                }

            }while(estado);
            numeroParticipante++;

        }

        System.out.println("-----Participante Inscritos a Circuito Chico------\n");
        for (Map.Entry<Long,Persona> par : circuitoChico.entrySet()) {
            System.out.println("Participante: "+par.getValue().getNombre() + " "+ par.getValue().getApellido() + " "+"Numero de inscripcion "+par.getValue().getNumeroParticioante());
        }

        System.out.println("-----Participante a Retirar------\n");
        System.out.println("Dni de Participante a Retirar");
        long dni = scanner.nextInt();

        if(circuitoChico.containsKey(dni)){
            circuitoChico.remove(dni);
        }else
        if(ciruitoMedio.containsKey(dni)){
            ciruitoMedio.get(dni);

        }else if(circuitoAvanzado.containsKey(dni)){
            circuitoAvanzado.remove(dni);
        }

        System.out.println("-----Cuanto paga el Participante------\n");
        for (Persona p: participantes) {

            if(circuitoChico.containsKey(p.getDni())){
                if(p.getEdad() < 18){
                    System.out.println("El participante "+ p.getNombre() +" Debe  Pagar:$1300");
                }else{
                    System.out.println("El participante "+ p.getNombre() +" Debe  Pagar:$1500");
                }
            }else
            if(ciruitoMedio.containsKey(p.getDni())){
                if(p.getEdad() < 18){
                    System.out.println("El participante "+ p.getNombre() +" Debe  Pagar:$2000");
                }else{
                    System.out.println("El participante "+ p.getNombre() +" Debe  Pagar:$2300");
                }
            }else if(circuitoAvanzado.containsKey(p.getDni())){
                    System.out.println("El Participante "+ p.getNombre() +" Debe Pagar:$2800");
            }

        }

    }

}





