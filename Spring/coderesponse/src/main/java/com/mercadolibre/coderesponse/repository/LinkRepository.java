package com.mercadolibre.coderesponse.repository;


import com.mercadolibre.coderesponse.dto.LinkDTO;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.spi.LocaleNameProvider;

@Repository
public class LinkRepository implements ILinkRepository{
    private final Map<String, LinkDTO> repository= new HashMap<>();

    @Override
    public LinkDTO consultar(String linkID) {
        return repository.get(linkID);
    }

    @Override
    public LinkDTO guardar(LinkDTO mLinkDTO) {
        LinkDTO nLinkDTO= repository.put(mLinkDTO.getLink(), mLinkDTO);
        return mLinkDTO;
    }

    @Override
    public void eliminar(LinkDTO mLinkDTO) {
        repository.remove(mLinkDTO.getLink());
    }
}
