package com.example.repaso.repository;

import com.example.repaso.model.Celular;
import com.example.repaso.model.Mensajero;
import com.example.repaso.model.Paloma;
import com.example.repaso.model.Telegrafo;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MensajeRepository implements IMensajeRepository
{
    private Map<Long, Mensajero> mensajeroMap;

    public MensajeRepository()
    {
        this.mensajeroMap = new HashMap<>();
        this.mensajeroMap.put(0L, new Paloma());
        this.mensajeroMap.put(1L, new Celular());
        this.mensajeroMap.put(2L, new Paloma());
        this.mensajeroMap.put(3L, new Telegrafo());
        this.mensajeroMap.put(4L, new Paloma());
    }

    @Override
    public Map<Long, Mensajero> mensajeroMap()
    {
        return mensajeroMap;
    }

    @Override
    public Mensajero getMensajero(Long id)
    {
        return mensajeroMap.get(id);
    }
}
