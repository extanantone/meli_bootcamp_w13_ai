package com.mercadolibre.coderesponse.service;

import com.mercadolibre.coderesponse.dto.LinkDTO;

public interface ILinkService {
    LinkDTO create(LinkDTO mLinkDTO);
    LinkDTO redirect(LinkDTO mLinkDTO);
    LinkDTO redirect(LinkDTO mLinkDTO, String pass);
    LinkDTO metrics(LinkDTO mLinkDTO);
    void invalidate(int linkID);
}
