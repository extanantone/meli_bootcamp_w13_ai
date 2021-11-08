package com.LinkTracker.Service;

import com.LinkTracker.DTO.DtoUrlMetrics;
import com.LinkTracker.DTO.UrlDto;
import com.LinkTracker.DTO.UrlResponseDto;

public interface IUrlService {

    UrlResponseDto addUrl(UrlDto dto);

    String getUrlById(int id);

    void invalidateUrl(int id);

    String getUrlByIdAndPassword(int id, String password);

    DtoUrlMetrics getUrlMetricsById(int id);
}
