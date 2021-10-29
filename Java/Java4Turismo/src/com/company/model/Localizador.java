package com.company.model;

import com.company.model.item.ItemLocalizador;
import com.company.model.promocion.Promocion;

import java.util.List;

public class Localizador {
    List<Promocion> promociones;
    List<ItemLocalizador> items;
    Cliente cliente;
    double porcentajeDescuento;
    double precio;
    double precioConDescuento;

    public Localizador(
            List<Promocion> promociones,
            Paquete paquete,
            Cliente cliente) {
        this.promociones = promociones;
        this.items = paquete.getItems();
        this.cliente = cliente;
        cliente.addLocalizador(this);

        this.precio = this.calcularValorTotal();
        this.porcentajeDescuento = this.calcularPorcentajeDesucuento();
        this.precioConDescuento = this.calcularPrecioConDescuento();
    }

    private  double calcularValorTotal() {
        double result = 0;
        for (ItemLocalizador item:
             this.items) {
            result += item.getPrecio();
        }
        return result;
        //return this.items.stream()
        //        .collect( Collectors.summingDouble(ItemLocalizador::getPrecio) );
    }

    private double calcularPorcentajeDesucuento() {
        double descuento = 0;
        for (Promocion promocion:
                this.promociones) {
            descuento += promocion.getDescuento();
        }
        return descuento;
        //return this.promociones.stream()
        //        .collect( Collectors.summingDouble(Promocion::getDescuento) );
    }

    private double calcularPrecioConDescuento() {
        return   this.precio -
                (this.precio * this.porcentajeDescuento) / 100;
    }

    @Override
    public String toString() {
        return "Localizador{" +
                ", precio=" + precio +
                "porcentajeDescuento=" + porcentajeDescuento +
                ", precioConDescuento=" + precioConDescuento +
                '}';
    }
}
