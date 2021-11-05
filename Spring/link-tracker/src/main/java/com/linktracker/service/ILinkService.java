package com.linktracker.service;

import com.linktracker.dto.LinkDTO;
import com.linktracker.dto.LinkInfoDTO;

public interface ILinkService {

    public LinkInfoDTO createLinkInfo(LinkDTO linkDTO);

    public String verifyLinkExistence(int linkId, String password);

    Object getAmountRedirects(int linkId);


    Object invalidateLink(int linkId);
}