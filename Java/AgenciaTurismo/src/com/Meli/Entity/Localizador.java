package com.Meli.Entity;

import java.util.List;
import java.util.stream.Collectors;

public class Localizador {
    private Cliente cliente;
    private List<Beneficio> beneficios;
    private double total;

    public Localizador(Cliente cliente, List<Beneficio> beneficios, RepositorioLocalizador repositorio) {
        this.cliente = cliente;
        this.beneficios = beneficios;
        this.total = beneficios.stream().collect(Collectors.summingDouble(Beneficio::totalBeneficio));
        repositorio.add(this);

    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Beneficio> getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(List<Beneficio> beneficios) {
        this.beneficios = beneficios;

    }

    public double getTotal() {
        return total;
    }
}
