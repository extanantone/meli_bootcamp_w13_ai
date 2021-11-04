package com.example.calculadoracalorias.service;

import com.example.calculadoracalorias.entity.Ingrediente;
import com.example.calculadoracalorias.entity.Plato;
import com.example.calculadoracalorias.repository.PlatoRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    private final PlatoRepository platoRepository;

    public PlatoService(PlatoRepository platoRepository) {
        this.platoRepository = platoRepository;
    }

    public Plato obtenerPlato(String nombre) {
        return platoRepository.obtenerElementoPorNombre(nombre);
    }

    public List<Plato> obtenerPlatos(List<String> nombres) {
        return nombres.stream()
                .map(platoRepository::obtenerElementoPorNombre)
                .collect(Collectors.toList());
    }

    public Plato guardarPlato(Plato plato) {
        return platoRepository.guardarElemento(plato);
    }

    public int calcularTotalCalorias(Plato plato) {
        return plato.getIngredientes()
                .stream()
                .map(Ingrediente::getCalorias)
                .reduce(Integer::sum)
                .orElse(-1);
    }

    public String mostrarIngredientes(Plato plato) {
        StringBuilder sb = new StringBuilder();
        plato.getIngredientes().forEach(ingrediente -> sb.append(ingrediente.toString()));
        return sb.toString();
    }

    public String ingredienteConMayorCaloria(Plato plato) {
        Ingrediente ingMayorCaloria =
                plato.getIngredientes()
                        .stream()
                        .max(Comparator.comparingInt(Ingrediente::getCalorias))
                        .orElse(null);

        if (ingMayorCaloria == null) return "Error al procesar ingredientes.";
        return ingMayorCaloria.toString();
    }

    public String mostrarDetallesPlato(Plato plato) {
        return "\nPLATO: " + plato.getNombre() +
                "\nTotal calorias: " + calcularTotalCalorias(plato) +
                "\nIngredientes: " + mostrarIngredientes(plato) +
                "\nIngrediente con mas calorias: " + ingredienteConMayorCaloria(plato) +
                "\n";
    }

    public String mostrarDetallesPlatos(List<Plato> platos) {
        StringBuilder sb = new StringBuilder();
        platos.forEach(plato -> {
            if (plato != null) sb.append(mostrarDetallesPlato(plato));
        });
        return sb.toString();
    }
}
