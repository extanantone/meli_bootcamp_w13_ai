package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Flota implements Apuntable {
    public List<Nave> naves;

    public Flota() {
        this.naves = new ArrayList<>();
    }

    public Flota(List<Nave> naves) {
        this.naves = naves;
    }

    @Override
    public double getDistance(int targetX, int targetY) {
        double result = 0.0;
        for (Nave nave : this.naves) result += nave.getDistance(targetX, targetY);
        return result/this.naves.size();
    }
}
