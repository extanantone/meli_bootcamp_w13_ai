package com.mercadolibre.coderesponse.repository;

import com.mercadolibre.coderesponse.dto.LinkDTO;

public interface ILinkRepository {
    LinkDTO consultar(String linkID);
    LinkDTO guardar(LinkDTO mLinkDTO);
    void eliminar(LinkDTO mLinkDTO);
}
