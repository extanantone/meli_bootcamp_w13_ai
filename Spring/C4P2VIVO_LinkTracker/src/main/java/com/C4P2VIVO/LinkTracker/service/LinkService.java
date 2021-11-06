package com.C4P2VIVO.LinkTracker.service;

import com.C4P2VIVO.LinkTracker.dto.LinkDTO;
import com.C4P2VIVO.LinkTracker.repository.LinkRepository;
import org.springframework.stereotype.Service;

@Service
public class LinkService implements ILinkService{

    private final LinkRepository linkRepository;

    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @Override
    public LinkDTO create(LinkDTO link) {
        return linkRepository.save(link);
    }

    @Override
    public LinkDTO redirect(Integer linkId) {
        LinkDTO link = linkRepository.findLinkByLinkId(linkId);
        if( link != null && link.getActive())
            link.sumCount();

        return link;
    }

    @Override
    public LinkDTO redirect(Integer linkId, String password) {
        LinkDTO link = linkRepository.findLinkByLinkId(linkId);
        if( link != null && link.getActive()){
            if(link.getPassword() != null && link.getPassword().equals(password)){
                link.sumCount();
            }else {
                link = null;
            }
        }
        return link;
    }

    @Override
    public LinkDTO metrics(Integer linkdId) {
        LinkDTO link = linkRepository.findLinkByLinkId(linkdId);
        return link;
    }

    @Override
    public void invalidate(Integer linkId) {
        linkRepository.invalidate(linkId);
    }
}
