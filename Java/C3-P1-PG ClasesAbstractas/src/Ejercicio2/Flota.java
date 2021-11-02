package Ejercicio2;

import java.util.ArrayList;

public class Flota {
    private ArrayList<Nave> mListaDeNaves= new ArrayList<>();

    public Flota(){
        this.mListaDeNaves.add(new Nave());
    }

    public Flota(ArrayList<Nave> mListaDeNaves) {
        this.mListaDeNaves = mListaDeNaves;
    }

    public double getPromedioDeNaves(){
        return this.mListaDeNaves.stream()
                .mapToInt(Nave::getPuntuacion)
                .average()
                .getAsDouble();
    }
}
