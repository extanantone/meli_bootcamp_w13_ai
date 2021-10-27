import java.util.*;

public class Garaje {
    private static final int count = 0;
    private int id;
    private List<Vehiculo> vehiculos;

    public Garaje(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public int getId() {
        return id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    @Override
    public String toString() {
        String vehiculos_string="";
        for (Vehiculo item :this.vehiculos){
            vehiculos_string+="Marca: " + item.getMarca() + " - Modelo: "+ item.getModelo() +" - Costo: "+item.getCosto()+"\n";
        }
        return "Garaje\nid: " + this.id +"\nVehiculos:\n"+vehiculos_string;
    }
}
