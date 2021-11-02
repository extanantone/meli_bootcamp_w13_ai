import java.util.List;

public class Flota extends ObjetoJuego{
    private List<ObjetoJuego> naves;

    public Flota(List<ObjetoJuego> naves) {
        this.naves = naves;
    }

    public List<ObjetoJuego> getNaves() {
        return naves;
    }

    public void setNaves(List<ObjetoJuego> naves) {
        this.naves = naves;
    }

    @Override
    public double calcularDistancia(double x, double y) {
        double distancia = 0;
        for(ObjetoJuego nave:naves){
            distancia+=nave.calcularDistancia(x, y);
        }
        return distancia / naves.size();
    }
}
