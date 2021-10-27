package ejercicio1;

public class TechSupport extends Staff implements Supports{
    public TechSupport(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void trabajar() {
        System.out.println("Esta trabajando el TechSupport " + getNombre() + getApellido());
    }

    @Override
    public void darSoporte() {
        System.out.println("Esta brindando soporte el TechSupport " + getNombre() + getApellido());
    }
}
