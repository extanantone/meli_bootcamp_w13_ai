package com.mercadolibre.Interfaz;

import com.mercadolibre.Enumeradores.Descuento;
import com.mercadolibre.Implementacion.Localizador;

public interface IDescuento {
     void calcularDescuento(Localizador localizador, Descuento descuento);
}
