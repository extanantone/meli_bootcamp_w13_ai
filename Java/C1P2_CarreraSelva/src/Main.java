import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Competidor> cChico = new ArrayList<Competidor>();
        List<Competidor> cMedio = new ArrayList<Competidor>();
        List<Competidor> cAvanzado = new ArrayList<Competidor>();

        Competidor comp1 = new Competidor(1234,"Ana","Lopez",19,1234567,9876543,"O+");
        cAvanzado.add(comp1);

        for( int i = 0; i < cChico.size(); i++){
            if( cChico.get(i).getDni() == comp1.getDni() ){
                System.out.println("El participante con DNI " +
                        comp1.getDni() +
                        " ya se encuentra inscrito en el circuito chico.");
            }

        }

        for( int i = 0; i < cMedio.size(); i++){
            if( cMedio.get(i).getDni() == comp1.getDni() ){
                System.out.println("El participante con DNI " +
                        comp1.getDni() +
                        " ya se encuentra inscrito en el circuito medio.");
            }

        }

        for( int i = 0; i < cAvanzado.size(); i++){
            if( cAvanzado.get(i).getDni() == comp1.getDni() ){
                System.out.println("El participante con DNI " +
                        comp1.getDni() +
                        " ya se encuentra inscrito en el circuito avanzado.");
            }

        }

        int tipoCircuito = 3;
        int numCompetidor = 0;
        switch (tipoCircuito){

            case 1:
                numCompetidor = cChico.size() + 1;
                comp1.setNumParticipante(numCompetidor);

                if( comp1.getEdad() < 18 ){
                    comp1.setPagoInscripcion(1300);
                }else{
                    comp1.setPagoInscripcion(1500);
                }

                cChico.add(comp1);
                System.out.println("Competidor inscrito en Circuito Chico con número " +
                        cChico.get(numCompetidor-1).getNumParticipante());
                System.out.println("El participante debe pagar: $" + cChico.get(numCompetidor-1).getPagoInscripcion());
                break;
            case 2:
                numCompetidor = cMedio.size() + 1;
                comp1.setNumParticipante(numCompetidor);

                if( comp1.getEdad() < 18 ){
                    comp1.setPagoInscripcion(2000);
                }else{
                    comp1.setPagoInscripcion(2300);
                }

                cMedio.add(comp1);
                System.out.println("Competidor inscrito en Circuito Médio con número " +
                        cMedio.get(numCompetidor-1).getNumParticipante());
                System.out.println("El participante debe pagar: $" + cMedio.get(numCompetidor-1).getPagoInscripcion());
                break;
            case 3:
                numCompetidor = cAvanzado.size() + 1;
                comp1.setNumParticipante(numCompetidor);

                if( comp1.getEdad() < 18 ){
                    System.out.println("El participante no puede competir por ser menor de edad");
                }else{
                    comp1.setPagoInscripcion(2800);
                    cAvanzado.add(comp1);
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
