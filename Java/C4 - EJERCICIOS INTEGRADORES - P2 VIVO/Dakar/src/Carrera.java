import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre,  List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculos = vehiculos.size();
        this.vehiculos = vehiculos;
        this.socorristaAuto = new SocorristaAuto("Socorrista de autos");
        this.socorristaMoto = new SocorristaMoto("Socorrista de motos");
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculos() {
        return cantidadDeVehiculos;
    }

    public void setCantidadDeVehiculos(int cantidadDeVehiculos) {
        this.cantidadDeVehiculos = cantidadDeVehiculos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        this.vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        this.cantidadDeVehiculos++;
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        this.vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        this.cantidadDeVehiculos++;
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        this.vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        int index_vehiculo = -1;
        for(int index = 0; index < this.vehiculos.size(); index++){
            if (this.vehiculos.get(index).getPatente().equals(patente)){
                index_vehiculo = index;
            }
        }

        if (index_vehiculo != -1){
            this.vehiculos.remove(index_vehiculo);
        }
    }

    public Vehiculo ganador(){
        double maxValue = 0;
        Vehiculo vehiculoGanador = null;
        for (Vehiculo vehiculo:this.vehiculos) {
            double value = vehiculo.getVelocidad() * (vehiculo.getAceleracion() / 2)
                    /
                    (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (value >= maxValue) {
                vehiculoGanador = vehiculo;
                maxValue = value;
            }
        }

        return vehiculoGanador;
    }

    public void socorrerAuto(String patente){
        int index_vehiculo = -1;
        for(int index = 0; index < this.vehiculos.size(); index++){
            if (this.vehiculos.get(index).getPatente().equals(patente)){
                index_vehiculo = index;
            }
        }

        if (index_vehiculo != -1){
            this.getSocorristaAuto().socorrer((Auto)this.vehiculos.get(index_vehiculo));
        }
    }

    public void socorrerMoto(String patente){
        int index_vehiculo = -1;
        for(int index = 0; index < this.vehiculos.size(); index++){
            if (this.vehiculos.get(index).getPatente().equals(patente)){
                index_vehiculo = index;
            }
        }

        if (index_vehiculo != -1){
            this.getSocorristaMoto().socorrer((Moto)this.vehiculos.get(index_vehiculo));
        }
    }
}
