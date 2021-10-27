package bootcamp.ejercicio2;

import bootcamp.ejercicio2.interfaces.Imprimible;

public abstract class Documento implements Imprimible {


    @Override
    public void imprimir() {
        System.out.println("");
    }
}
