package models;

import java.io.IOException;
import java.util.Scanner;

public class SerieGeneral extends Prototipo{
    Integer aSumar = -1;

    public SerieGeneral(Integer aSumar) {
        this.aSumar = aSumar;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el valor inicial de la serie: ");
            Integer valorInicial = Integer.parseInt( scanner.nextLine());
            establecerInicio(valorInicial);
        }
    }

    @Override
    public void valorSiguiente() {
        if(aSumar == -1){
            System.out.println("Ingrese el tipo de sumatoria a realizar: ");
            try (Scanner scanner = new Scanner(System.in)) {
                aSumar = Integer.parseInt( scanner.nextLine());
                this.valorSerie = valorSerie + aSumar;
            }
        } else{
            this.valorSerie = valorSerie + aSumar;
        }
    }
}
