package com.MELI;

import com.MELI.models.Circuito;
import com.MELI.models.Inscripcion;
import com.MELI.models.Participante;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Participante participanteAInscribir;

        Circuito chico = new Circuito("Chico", 2, 1300, 1500);
        Circuito medio = new Circuito("Medio", 5, 2000, 2300);
        Circuito avanzado = new Circuito("Avanzado", 10, 0, 2800);

        List<Participante> participantes = new ArrayList<>();
        Participante p1 = new Participante(32234234, "Vanesa","Garro", 291523749, 30, 293814912, "A+" );
        Participante p2 = new Participante(36327762, "Sofia","Perez", 291523749, 18, 293814912, "0+" );
        Participante p3 = new Participante(42352932, "Sebastian","Gomez", 291523749, 12, 293814912, "A-" );
        participantes.add(p1);
        participantes.add(p2);
        participantes.add(p3);



        //Prueba
        inscripcion(p1,chico);
        inscripcion(p2, medio);
        inscripcion(p3, avanzado);
        inscripcion(p1, avanzado);
        inscripcion(p2, chico);

        System.out.println("¿Que accion desea realizar?" +
                "\n 1- Inscribir un participante" +
                "\n 2- Mostrar Inscriptos" +
                "\n 3- Desinscribir un participante"
        );
        int accionARealizar = scanner.nextInt();

        switch (accionARealizar){
            case 1:
                System.out.println("Ingrese el Circuito al que se inscribe:" +
                        "\n 1- Chico" +
                        "\n 2- Medio" +
                        "\n 3- Avanzado");
                int tipoCircuito = scanner.nextInt();

                System.out.println("Ingrese el DNI del Participante");
                int dni = scanner.nextInt();

                //Verificamos que el participante este cargado
                boolean participante = participantes.stream().filter(x -> x.getDni() == dni).findFirst().isPresent();

                if(!participante) {
                    participanteAInscribir = new Participante();
                    System.out.print("\tNombre: ");
                    participanteAInscribir.setNombre(scanner.next());

                    System.out.print("\tApellido: ");
                    participanteAInscribir.setApellido(scanner.next());

                    System.out.print("\tDni: ");
                    participanteAInscribir.setDni(scanner.nextInt());

                    System.out.print("\tEdad: ");
                    participanteAInscribir.setEdad(scanner.nextInt());

                    System.out.print("\tCelular: ");
                    participanteAInscribir.setCelular(scanner.nextInt());

                    System.out.print("\tNumero de emergencia: ");
                    participanteAInscribir.setNumEmergencia(scanner.nextInt());

                    System.out.print("\tGrupo Sanguineo: ");
                    participanteAInscribir.setFactorSanguineo(scanner.next());

                    participantes.add(participanteAInscribir);

                } else {
                    participanteAInscribir = participantes.stream().filter(x -> x.getDni() == dni).findFirst().get();
                }

                switch (tipoCircuito){
                    case 1:
                        inscripcion(participanteAInscribir, chico);
                        break;
                    case 2:
                        inscripcion(participanteAInscribir, medio);
                        break;
                    case 3:
                        inscripcion(participanteAInscribir, avanzado);
                        break;
                    default:
                        System.out.println("La opcion ingresada es incorrecta");
                }
                break;
            case 2:
                System.out.println("Ingrese el Circuito al que se inscribe:" +
                        "\n 1 - Chico" +
                        "\n 2 - Medio" +
                        "\n 3 - Avanzado");
                int tipoDeCircuito = scanner.nextInt();
                if(tipoDeCircuito == 1) {
                    mostrarInscriptos(chico);
                } else if(tipoDeCircuito == 2) {
                    mostrarInscriptos(medio);
                } else {
                    mostrarInscriptos(avanzado);
                }
                break;
            case 3:
                System.out.println("Ingrese el Circuito al que se desinscribe:" +
                        "\n 1 - Chico" +
                        "\n 2 - Medio" +
                        "\n 3 - Avanzado"
                );

                int tipoDeCircuitoADesinscribir = scanner.nextInt();
                if(tipoDeCircuitoADesinscribir > 0 && tipoDeCircuitoADesinscribir < 4) {

                    System.out.println("Ingrese el Documento del participante: ");

                    int dniPartAEliminar = scanner.nextInt();
                    Participante part = participantes.stream().filter(x -> x.getDni() == dniPartAEliminar).findFirst().orElse(null);

                    if (tipoDeCircuitoADesinscribir == 1) {
                        desinscribirParticipante(chico, part);
                    } else if (tipoDeCircuitoADesinscribir == 2) {
                        desinscribirParticipante(medio, part);
                    } else {
                        desinscribirParticipante(avanzado, part);
                    }
                } else
                {
                    System.out.println("El circuito no existe");
                }
                break;
            default:
                    System.out.println("La opcion ingresada es incorrecta");
            }


    }

    private static void inscripcion(Participante participanteAInscribir, Circuito circuito) {
        Participante part = circuito.getParticipantes().stream().filter(x -> x.getDni() == participanteAInscribir.getDni()).findFirst().orElse(null);
        Inscripcion inscripcion;
        if(part == null) {
            participanteAInscribir.setnInscripcion(circuito.getParticipantes().size() + 1);
            circuito.addParticipantes(participanteAInscribir);

            if(participanteAInscribir.getEdad() < 18 && circuito.getTipo() != "Avanzado") {
                inscripcion = new Inscripcion(circuito, participanteAInscribir, circuito.getCostoMenor());
                System.out.println("El participante " + participanteAInscribir.getApellido() + " se ha inscripto correctamente, el costo de la inscripcion es: " + inscripcion.getValorInscripcion());
            }

            else if(participanteAInscribir.getEdad() >= 18){
                inscripcion = new Inscripcion(circuito, participanteAInscribir, circuito.getCostoMayor());
                System.out.println("El participante " + participanteAInscribir.getApellido() + " se ha inscripto correctamente, el costo de la inscripcion es: " + inscripcion.getValorInscripcion());
            }

            else {
                System.out.println("Los participantes menores no se pueden inscribir en el Circuito Avanzado");
            }

        } else {
            System.out.println("Disculpe el participante " + part.getApellido() + " ya se encuentra inscripto");
        }
    }
    private static void mostrarInscriptos(Circuito circuito){
        System.out.println("---------------------Inscriptos al Circuito " + circuito.getTipo() + "---------------------");
        System.out.println(circuito.getParticipantes());
    }
    private static void desinscribirParticipante(Circuito circuito, Participante participante) {
        boolean isInscripto = circuito.getParticipantes().stream().filter(x -> x.getDni() == participante.getDni()).findFirst().isPresent();
        System.out.println(participante);
        System.out.println(isInscripto);
        if(participante != null && isInscripto) {
            circuito.desinscribirParticipante(participante);
            System.out.println("El participante se desinscribio exitosamente");
            System.out.println(circuito.getParticipantes());
        } else {

            System.out.println("El participante no existe en ese circuito");
        }
    }

}
