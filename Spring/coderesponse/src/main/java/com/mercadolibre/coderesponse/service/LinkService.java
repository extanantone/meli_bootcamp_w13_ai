package com.mercadolibre.coderesponse.service;

import com.mercadolibre.coderesponse.dto.LinkDTO;
import com.mercadolibre.coderesponse.repository.ILinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{
    @Autowired
    ILinkRepository mILinkRepository;

    @Override
    public LinkDTO create(LinkDTO mLinkDTO) {
        return null;
    }

    @Override
    public LinkDTO redirect(LinkDTO mLinkDTO) {
        return null;
    }

    @Override
    public LinkDTO redirect(LinkDTO mLinkDTO, String pass) {
        return null;
    }

    @Override
    public LinkDTO metrics(LinkDTO mLinkDTO) {
        return null;
    }

    @Override
    public void invalidate(int linkID) {

    }
}
