package com.C4P2.LinkTracker.Service;

import com.C4P2.LinkTracker.DTO.LinkDTO;
import com.C4P2.LinkTracker.Repository.ILinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl implements ILinkService {

    ILinkRepository linkRepo;

    public LinkServiceImpl(ILinkRepository linkRepo) {
        this.linkRepo = linkRepo;
    }

    @Override
    public int crearLink(LinkDTO link) {

        int nuevaKey = linkRepo.guardarLink(link);

        return nuevaKey;
    }

}
