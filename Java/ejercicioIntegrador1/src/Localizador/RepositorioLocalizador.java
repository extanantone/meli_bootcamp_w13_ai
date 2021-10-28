package Localizador;

import Modelos.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepositorioLocalizador {
    private Map<Cliente, List<Localizador>> repositorio;

    public RepositorioLocalizador() {
        repositorio = new HashMap<>();
    }

    public Map<Cliente, List<Localizador>> getRepositorio() {
        return repositorio;
    }

    public void agregarLocalizador(Cliente cliente, Localizador localizador) {
        if (!repositorio.containsKey(cliente)) {
            repositorio.put(cliente, new ArrayList<>());
        }
        repositorio.get(cliente).add(localizador);
    }
}
