import java.util.List;

public class Repositorio_cliente {
    private List<Viajero> viajeros;

    public Repositorio_cliente(List<Viajero> viajeros) {
        this.viajeros = viajeros;
    }

    public List<Viajero> getViajeros() {
        return viajeros;
    }

    public void setViajeros(List<Viajero> viajeros) {
        this.viajeros = viajeros;
    }
}
