import java.util.ArrayList;

public class Garaje {
    private static int proximoId = 0;
    private int id;
    private ArrayList<Vehiculo> listaVehiculo;

    public Garaje(ArrayList<Vehiculo> listaVehiculo) {
        this.id = proximoId++;
        this.listaVehiculo = listaVehiculo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setListaVehiculo(ArrayList<Vehiculo> listaVehiculo) {
        this.listaVehiculo = listaVehiculo;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Vehiculo> getListaVehiculo() {
        return listaVehiculo;
    }
}
