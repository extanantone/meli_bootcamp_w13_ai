import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args){
        List<Competidor> cChico = new ArrayList<Competidor>();
        List<Competidor> cMedio = new ArrayList<Competidor>();
        List<Competidor> cAvanzado = new ArrayList<Competidor>();

        Competidor comp1 = new Competidor(0, 1234,"Ana","Lopez",19,1234567,9876543,"O+");
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
    }

}
