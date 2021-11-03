import java.util.ArrayList;
import java.util.List;

public class Garaje {
    private Integer id;
    private List Vehiculos = new ArrayList();

    public Garaje(Integer id, List vehiculos) {
        this.id = id;
        Vehiculos = vehiculos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(List vehiculos) {
        Vehiculos = vehiculos;
    }
}
