package com.example.c4_man_excep_vivo_p1.mapper;

import com.example.c4_man_excep_vivo_p1.dto.MetricsDTO;
import com.example.c4_man_excep_vivo_p1.model.Link;
import org.springframework.stereotype.Component;

@Component
public class MetricsMapper
{
    public MetricsDTO linkToMetricsDTO(Link link)
    {
        MetricsDTO metricsDTO = new MetricsDTO();
        metricsDTO.setRedirectCount(link.getClickCounter());
        return metricsDTO;
    }
}
