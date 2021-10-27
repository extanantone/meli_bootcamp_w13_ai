package ejercicio1;

public class MaintenanceStaff extends Staff {

    public MaintenanceStaff(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public void trabajar(){
        System.out.println("Esta trabajando el MaintenanceStaf " + getNombre() + getApellido());
    }

}
