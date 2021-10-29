import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private List<Localizadores> lista;
    private Long dni;
    private String nombre,apellido;
    private boolean descuento = false;
    public Cliente(Long dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.lista = new ArrayList<Localizadores>();
    }

    public List<Localizadores> getLista() {
        return lista;
    }

    public void setLista(Localizadores lista) {
        this.lista.add(lista);
        if(this.lista.size() == 2)this.descuento = true;
    }

    public Long getDni() {
        return dni;
    }

    public void setDni(Long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void aplicarDescuento(){
        if(this.descuento){
            Localizadores localizador = this.lista.get(this.lista.size()-1);
            localizador.setCosto(localizador.getCosto()*0.95);
        }
    }
}
