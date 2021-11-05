package com.link.controller;

import com.link.dtos.DtoUrlMetrics;
import com.link.service.IUrlService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class UrlMetricsController {

    private IUrlService iUrlService;

    public UrlMetricsController(IUrlService iUrlService){
        this.iUrlService = iUrlService;
    }

    @GetMapping("/{idUrl}")
    public DtoUrlMetrics getMetricsByUrlId(@PathVariable int idUrl){
        return iUrlService.getUrlMetricsById(idUrl);
    }

}
