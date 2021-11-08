package com.bootcamp.linkTracker.controller;

import com.bootcamp.linkTracker.dto.UrlMetricsDTO;
import com.bootcamp.linkTracker.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/metrics")
public class UrlMetricsController {

    @Autowired
    private IUrlService iUrlService;



    @GetMapping("/{idUrl}")
    public UrlMetricsDTO getMetricsByUrlId(@PathVariable int idUrl){
        return iUrlService.getUrlMetricsById(idUrl);
    }

}
