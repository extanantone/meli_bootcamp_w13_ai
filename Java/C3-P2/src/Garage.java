import java.util.ArrayList;

public class Garage {
    private double id;
    private ArrayList<Vehiculo> vehiculos;

    public Garage(double id) {
        this.id = id;
        vehiculos = new ArrayList<Vehiculo>();
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void agregarVehiculo(Vehiculo v){
        vehiculos.add(v);
    }

    public void mostrarVehiculos(){
        vehiculos.stream().forEach(v-> {
            System.out.println(v.getMarca());
            System.out.println(v.getModelo());
            System.out.println(v.getCosto());
        });
    }

    public void ordenarPorMarca(){
        vehiculos.stream()
                .sorted((x,y) -> {
                    int result = x.getMarca().compareToIgnoreCase(y.getMarca());
                    return (result == 0) ? Double.compare(x.getCosto(), y.getCosto()) : result;
                })
                .forEach(Vehiculo::mostrarVehiculo);
    }

    public void ordenarPorCosto(){
        vehiculos.stream()
                .sorted((x,y) -> Double.compare(x.getCosto(), y.getCosto()))
                .forEach(Vehiculo::mostrarVehiculo);
    }

}
