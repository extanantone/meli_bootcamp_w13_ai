package com.LinkTracker.Controller;

import com.LinkTracker.DTO.DtoUrlMetrics;
import com.LinkTracker.DTO.UrlResponseDto;
import com.LinkTracker.Service.IUrlService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlMetricsController {

    private IUrlService iUrlService;

    public UrlMetricsController(IUrlService iUrlService){
        this.iUrlService = iUrlService;
    }

    @GetMapping("/metricas/{idUrl}")
    public DtoUrlMetrics getMetricsByUrlId(@PathVariable int idUrl){
        return iUrlService.getUrlMetricsById(idUrl);
    }

}
