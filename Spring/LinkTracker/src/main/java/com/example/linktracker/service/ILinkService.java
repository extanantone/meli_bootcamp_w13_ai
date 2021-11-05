package com.example.linktracker.service;

import com.example.linktracker.dto.LinkRegisterDTO;

public interface ILinkService {
    Long saveLink(LinkRegisterDTO registerDTO);

    String getURL(Long id, String password);

    Boolean invalidateLink(Long id, String password);

    Long getVisits(Long id);
}
