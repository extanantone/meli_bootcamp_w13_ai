package com.bootcamp.linktracker.service;

import com.bootcamp.linktracker.dto.CreateLinkInDTO;
import com.bootcamp.linktracker.dto.CreateLinkOutDTO;
import com.bootcamp.linktracker.dto.CreateLinkPassInDTO;
import com.bootcamp.linktracker.dto.LinkStatisticsDTO;
import com.bootcamp.linktracker.exception.URLInvalidException;


public interface ILinkService {

    LinkStatisticsDTO getLinkStatistics(Long linkId);

    CreateLinkOutDTO createLink(CreateLinkInDTO linkDTO) ;

    CreateLinkOutDTO createLink(CreateLinkPassInDTO linkDTO);

    CreateLinkOutDTO getUrl(Long linkId);

    CreateLinkOutDTO disableLink(Long linkId);

    CreateLinkOutDTO enableLink(Long linkId);

    CreateLinkOutDTO setPass(Long linkId, String pass);

    LinkStatisticsDTO plusRedirects(Long linkId);

}
