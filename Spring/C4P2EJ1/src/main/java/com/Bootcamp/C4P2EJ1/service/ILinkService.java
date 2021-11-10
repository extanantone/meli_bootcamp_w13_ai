package com.Bootcamp.C4P2EJ1.service;

import com.Bootcamp.C4P2EJ1.dto.LinkDTO;

public interface ILinkService {
    public LinkDTO nuevoLink(LinkDTO linkDTO);

    public LinkDTO redireccionarLink(String password, LinkDTO linkDTO);

    public int estadisticaLink(LinkDTO linkDTO);

    public boolean eliminarLink(LinkDTO linkDTO);
}
