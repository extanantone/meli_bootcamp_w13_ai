package com.example.socialMeli.service;

import com.example.socialMeli.dto.RespuestaSimpleDTO;

public interface ISocialMeliService {
    public void cargarDatos();
    public RespuestaSimpleDTO seguir (int id_comprado, int id_vendedor);
    public RespuestaSimpleDTO contar (int id_vendedor);
}
