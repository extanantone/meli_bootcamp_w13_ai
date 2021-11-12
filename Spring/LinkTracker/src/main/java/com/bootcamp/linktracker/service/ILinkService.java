package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.LinkCreationReqDTO;
import com.bootcamp.linktracker.dto.LinkCreationResDTO;
import com.bootcamp.linktracker.dto.LinkDTO;

public interface ILinkService {

    public LinkCreationResDTO createLink(LinkCreationReqDTO linkCreationReqDTO);

    public LinkDTO getLink(int id);

    public void countVisit(int id);
}
