package com.C4P2VIVO.LinkTracker.repository;

import com.C4P2VIVO.LinkTracker.dto.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkRepository implements ILinkRepository{
    private final List<LinkDTO> database = new ArrayList<>();
    @Override
    public LinkDTO save(LinkDTO link) {
        if(link.getLinkId() == null){
            link.setLinkId(database.size());
        }

        database.add(link);

        return link;
    }

    @Override
    public LinkDTO findLinkByLinkId(Integer linkId) {
        LinkDTO linkDTO = database.get(linkId);
        return linkDTO;
    }

    @Override
    public void invalidate(Integer linkId) {
        LinkDTO linkDTO = findLinkByLinkId(linkId);
        linkDTO.setActive(false);
    }
}
