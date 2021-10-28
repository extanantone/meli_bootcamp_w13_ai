import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private long dni;
    private String nombre;
    private List<Localizador> localizadores;

    public Cliente(long dni, String nombre) {
        this.dni = dni;
        this.nombre = nombre;
        this.localizadores = new ArrayList<Localizador>();
    }
    public void addLocalizador(Localizador loca){
        localizadores.add(loca);
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
