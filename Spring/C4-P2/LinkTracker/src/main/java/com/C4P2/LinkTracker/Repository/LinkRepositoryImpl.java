package com.C4P2.LinkTracker.Repository;

import com.C4P2.LinkTracker.DTO.LinkDTO;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository
public class LinkRepositoryImpl implements ILinkRepository{

    HashMap<Integer, LinkDTO> baseLinks = new HashMap<>();

    @Override
    public int guardarLink(LinkDTO link) {
        baseLinks.put(baseLinks.size(), link);

        return (baseLinks.size() - 1);
    }
}
