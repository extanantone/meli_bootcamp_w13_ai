package ejercicio1AdminCursos;

public class EmpleadoSoporte extends Persona{

    private String codigoEmpleado;

    private String area;


    public EmpleadoSoporte(String identificacion, String nombre, String codigoEmpleado, String area) {
        super(identificacion, nombre);
        this.codigoEmpleado = codigoEmpleado;
        this.area = area;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    @Override
    public String toString() {
        return super.toString() + ", codigo empleado : " + this.codigoEmpleado +
                ", área : " + this.area;
    }
}
