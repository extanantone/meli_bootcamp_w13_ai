package com.link.service;

import com.link.dtos.DtoUrlMetrics;
import com.link.dtos.UrlDto;
import com.link.dtos.UrlResponseDto;

public interface IUrlService {

    UrlResponseDto addUrl(UrlDto dto);

    String getUrlById(int id);

    void invalidateUrl(int id);

    String getUrlByIdAndPassword(int id, String password);

    DtoUrlMetrics getUrlMetricsById(int id);
}
