import java.util.List;
import java.util.Map;

public class Repo {
    private List<Localizador> localizadoresVendidos;
    private Map<String,Cliente> dniClientes;

    public Repo(List<Localizador> localizadoresVendidos, Map<String, Cliente> dniClientes) {
        this.localizadoresVendidos = localizadoresVendidos;
        this.dniClientes = dniClientes;
    }

    public void addLocalizadores(Localizador localizador){
        this.localizadoresVendidos.add(localizador);

    }
    public void addClientes(Cliente cliente){
        this.dniClientes.put(cliente.getDni(),cliente);

    }

    public List<Localizador> getLocalizadoresVendidos() {
        return localizadoresVendidos;
    }

    public void setLocalizadoresVendidos(List<Localizador> localizadoresVendidos) {
        this.localizadoresVendidos = localizadoresVendidos;
    }

    public Map<String, Cliente> getDniClientes() {
        return dniClientes;
    }

    public void setDniClientes(Map<String, Cliente> dniClientes) {
        this.dniClientes = dniClientes;
    }
}
