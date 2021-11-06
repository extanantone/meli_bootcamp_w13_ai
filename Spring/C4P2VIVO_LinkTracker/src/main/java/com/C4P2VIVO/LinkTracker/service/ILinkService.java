package com.C4P2VIVO.LinkTracker.service;

import com.C4P2VIVO.LinkTracker.dto.LinkDTO;

public interface ILinkService {
    LinkDTO create(LinkDTO link);
    LinkDTO redirect(Integer linkId);
    LinkDTO redirect(Integer linkId, String password);
    LinkDTO metrics(Integer linkdId);
    void invalidate(Integer linkId);
}
