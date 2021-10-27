import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner entradaEscaner = new Scanner(System.in);

        List<Competidor> cChico = new ArrayList<Competidor>();
        List<Competidor> cMedio = new ArrayList<Competidor>();
        List<Competidor> cAvanzado = new ArrayList<Competidor>();

        Competidor comp1 = new Competidor(1234,"Ana","Lopez",19,1234567,9876543,"O+");
        cAvanzado.add(comp1);

        System.out.println("Ingrese DNI: ");
        int dni = entradaEscaner.nextInt();
        System.out.println("Ingrese nombre: ");
        String nombre = entradaEscaner.next();
        System.out.println("Ingrese apellido: ");
        String apellido = entradaEscaner.next();
        System.out.println("Ingrese edad: ");
        int edad = entradaEscaner.nextInt();
        System.out.println("Ingrese celular: ");
        int celular = entradaEscaner.nextInt();
        System.out.println("Ingrese número de emergencia: ");
        int numEmergencia = entradaEscaner.nextInt();
        System.out.println("Ingrese grupo sanguieo: ");
        String gsanguineo = entradaEscaner.next();

        Competidor comp = new Competidor(dni,nombre,apellido,edad,celular,numEmergencia,gsanguineo);

        for( int i = 0; i < cChico.size(); i++){
            if( cChico.get(i).getDni() == comp.getDni() ){
                System.out.println("El participante con DNI " +
                        comp.getDni() +
                        " ya se encuentra inscrito en el circuito chico.");
            }

        }

        for( int i = 0; i < cMedio.size(); i++){
            if( cMedio.get(i).getDni() == comp.getDni() ){
                System.out.println("El participante con DNI " +
                        comp.getDni() +
                        " ya se encuentra inscrito en el circuito medio.");
            }

        }

        for( int i = 0; i < cAvanzado.size(); i++){
            if( cAvanzado.get(i).getDni() == comp.getDni() ){
                System.out.println("El participante con DNI " +
                        comp.getDni() +
                        " ya se encuentra inscrito en el circuito avanzado.");
            }

        }

        System.out.println("Ingrese tipo circuito: 1-Chico; 2-Medio; 3-Avanzado ->");
        int tipoCircuito = entradaEscaner.nextInt();
        int numCompetidor = 0;
        switch (tipoCircuito){

            case 1:
                numCompetidor = cChico.size() + 1;
                comp.setNumParticipante(numCompetidor);

                if( comp.getEdad() < 18 ){
                    comp.setPagoInscripcion(1300);
                }else{
                    comp.setPagoInscripcion(1500);
                }

                cChico.add(comp);
                System.out.println("Competidor inscrito en Circuito Chico con número " +
                        cChico.get(numCompetidor-1).getNumParticipante());
                System.out.println("El participante debe pagar: $" + cChico.get(numCompetidor-1).getPagoInscripcion());
                break;
            case 2:
                numCompetidor = cMedio.size() + 1;
                comp.setNumParticipante(numCompetidor);

                if( comp.getEdad() < 18 ){
                    comp.setPagoInscripcion(2000);
                }else{
                    comp.setPagoInscripcion(2300);
                }

                cMedio.add(comp);
                System.out.println("Competidor inscrito en Circuito Médio con número " +
                        cMedio.get(numCompetidor-1).getNumParticipante());
                System.out.println("El participante debe pagar: $" + cMedio.get(numCompetidor-1).getPagoInscripcion());
                break;
            case 3:
                numCompetidor = cAvanzado.size() + 1;
                comp.setNumParticipante(numCompetidor);

                if( comp.getEdad() < 18 ){
                    System.out.println("El participante no puede competir por ser menor de edad");
                }else{
                    comp.setPagoInscripcion(2800);
                    cAvanzado.add(comp);
                    System.out.println("Competidor inscrito en Circuito Avanzado con número " +
                            cAvanzado.get(numCompetidor-1).getNumParticipante());
                    System.out.println("El participante debe pagar: $" + cAvanzado.get(numCompetidor-1).getPagoInscripcion());
                }

                break;
            default:
                System.out.println("¡Introdujo una opción incorrecta!");
        }
    }

}
