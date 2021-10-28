package com.company.repository;

import com.company.model.Cliente;
import com.company.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements Crud<Factura>{
    List<Factura> listFactura = new ArrayList<Factura>();
    @Override
    public void save(Factura obj) {
        listFactura.add(obj);
    }

    @Override
    public void view() {
        for (Factura f: listFactura){
            System.out.println(f.toString());
        }
    }

    @Override
    public Optional<Factura> search(Long id) {
        boolean flag = false;

        for (Factura f: listFactura){
            if (f.getCodigo().equals(id)){
                flag= true;
                System.out.println("Factura encontrado");
                System.out.println(f.toString());
                return Optional.of(f);
            }
        }

        if (flag == false) System.out.println("Factura no encontrado");

        return Optional.empty();
    }

    @Override
    public void delete(Long id) {
        Optional<Factura> dni = this.search(id);

        if (!dni.isEmpty()) {
            System.out.println("Factura borrado");
            listFactura.remove(dni.get());
            this.view();
        } else System.out.println("Factura incorrecto");
    }

    @Override
    public List<Factura> get() {
        return null;
    }
}
