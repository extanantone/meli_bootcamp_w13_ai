import java.util.ArrayList;
import java.util.List;

public class Garage {

    private Integer codGarage;
    private List<Vehiculo> vehiculos = new ArrayList<Vehiculo>();

    public Garage(Integer codGarage) {
        this.codGarage = codGarage;
    }

    public Integer getCodGarage() {
        return codGarage;
    }

    public void setCodGarage(Integer codGarage) {
        this.codGarage = codGarage;
    }

    public void agregarVehiculoAGarage(Vehiculo vehiculo){
        this.vehiculos.add(vehiculo);
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    @Override
    public String toString() {
        return "Garage{" +
                "codGarage=" + codGarage +
                ", vehiculos=" + vehiculos +
                '}';
    }
}
