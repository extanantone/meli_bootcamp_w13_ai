package com.bootcamp.EJREPMessengers.repository;

import com.bootcamp.EJREPMessengers.model.AMensajero;
import com.bootcamp.EJREPMessengers.model.PalomaMensajera;
import com.bootcamp.EJREPMessengers.model.TelefonoCelular;
import com.bootcamp.EJREPMessengers.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class MensajeroRepository implements IMensajeroRepository {

    List<AMensajero> listaMensajeros = new ArrayList<>();

    public MensajeroRepository() {
        LocalDateTime oneHourAgo = LocalDateTime.now().minusHours(1);
        PalomaMensajera paloma1 = new PalomaMensajera("Soy la paloma 1");
        paloma1.setComida(2);
        paloma1.setUltimoDescanso(oneHourAgo);
        PalomaMensajera paloma2 = new PalomaMensajera("Soy la paloma 2");
        paloma2.setComida(20);
        paloma2.setUltimoDescanso(oneHourAgo);
        TelefonoCelular celular = new TelefonoCelular("Soy un teléfono");
        celular.setBateria(100);
        celular.setCantDatos(60);
        Telegrafo telegrafo = new Telegrafo("Soy un telégrafo");
        telegrafo.setEnchufado(true);
        listaMensajeros.add(paloma1);
        listaMensajeros.add(paloma2);
        listaMensajeros.add(celular);
        listaMensajeros.add(telegrafo);
    }

    @Override
    public List<AMensajero> buscarMensajeros() {
        return this.listaMensajeros;
    }

    @Override
    public String buscarMensajero(AMensajero aMensajero) {
        return aMensajero.convertirMensaje(aMensajero.getMensaje());
    }
}
