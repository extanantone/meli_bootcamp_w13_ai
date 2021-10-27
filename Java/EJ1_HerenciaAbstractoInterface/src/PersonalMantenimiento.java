public class PersonalMantenimiento extends Personal {

    public PersonalMantenimiento(String nombre, String apellido, String legajo, String seEncargaDe) {
        super(nombre, apellido, legajo, seEncargaDe);
    }

    @Override
    public void seEncargaDe(){
        System.out.println("Se encarga de limpiar y ordenar el establecimiento");
    }
}
