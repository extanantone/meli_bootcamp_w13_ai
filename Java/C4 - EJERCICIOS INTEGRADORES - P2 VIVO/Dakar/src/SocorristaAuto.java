public class SocorristaAuto extends Socorrista<Auto>{

    public SocorristaAuto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto, patente "+ vehiculo.getPatente());
    }
}
