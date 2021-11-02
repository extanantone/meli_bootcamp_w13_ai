public class SocorristaMoto extends Socorrista<Moto>{

    public SocorristaMoto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto, patente "+ vehiculo.getPatente());
    }
}
