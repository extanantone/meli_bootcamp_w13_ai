package com.company.repository;

import com.company.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository <Factura>{

    List <Factura> listaFacturas = new ArrayList<Factura>();

    @Override
    public void save(Factura objeto) {
        listaFacturas.add(objeto);
    }

    @Override
    public void mostrarPantalla() {

        for (Factura factura : listaFacturas) {
            System.out.println(factura.toString());

        }

    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {

        boolean encontrado = false;

        for (Factura factura : listaFacturas) {
            if (!factura.getCodigo().equals(codigoBuscado)) continue;

            System.out.println("Factura encontrada, sus datos son:");
            System.out.println(factura.toString());
            return Optional.of(factura);
        }

        if (encontrado == false) {
            System.out.println("Factura no encontrada");
        }

        return Optional.empty();

    }

    @Override
    public void eliminar(Long codigoBorrado) {

        Optional<Factura> factura = this.buscar(codigoBorrado);

        if (factura.isEmpty()) {
            System.out.println("No se encontró la factura a borrar");
        }
        else {
            System.out.println("Factura borrada correctamente");
            listaFacturas.remove(factura.get());
        }

    }

    @Override
    public List<Factura> listar() {
        return listaFacturas;
    }
}
