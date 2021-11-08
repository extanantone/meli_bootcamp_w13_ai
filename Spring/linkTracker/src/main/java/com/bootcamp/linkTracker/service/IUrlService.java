package com.bootcamp.linkTracker.service;

import com.bootcamp.linkTracker.dto.UrlDTO;
import com.bootcamp.linkTracker.dto.UrlMetricsDTO;
import com.bootcamp.linkTracker.dto.UrlResponseDTO;

public interface IUrlService {
    UrlResponseDTO addUrl(UrlDTO dto);

    String getUrlById(int id);

    void invalidateUrl(int id);

    String getUrlByIdAndPassword(int id, String password);

    UrlMetricsDTO getUrlMetricsById(int id);
}
