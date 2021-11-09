package com.SpringRecapitulando.LinkTracker.service;

import com.SpringRecapitulando.LinkTracker.dto.LinkCreateDTO;
import com.SpringRecapitulando.LinkTracker.dto.LinkDTO;
import com.SpringRecapitulando.LinkTracker.entity.Link;

public interface ILinkService {
    public LinkDTO findLink(int linkId);
    public LinkDTO createLink(LinkCreateDTO link);
    public boolean invalidateLink(int id);
    public LinkDTO addView(int linkId, String pass);
}
