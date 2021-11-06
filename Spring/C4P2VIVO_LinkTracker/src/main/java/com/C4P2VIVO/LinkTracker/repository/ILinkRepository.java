package com.C4P2VIVO.LinkTracker.repository;

import com.C4P2VIVO.LinkTracker.dto.LinkDTO;

public interface ILinkRepository {
    LinkDTO save(LinkDTO link);

    LinkDTO findLinkByLinkId(Integer linkId);

    void invalidate(Integer linkId);
}
