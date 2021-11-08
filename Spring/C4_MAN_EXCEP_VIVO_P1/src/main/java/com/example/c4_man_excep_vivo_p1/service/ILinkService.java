package com.example.c4_man_excep_vivo_p1.service;

import com.example.c4_man_excep_vivo_p1.dto.InputLinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.LinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.MetricsDTO;
import org.springframework.http.ResponseEntity;

public interface ILinkService
{
    public LinkDTO createLink(InputLinkDTO link);

    public ResponseEntity<Void> redirectLink(Integer linkId);

    public MetricsDTO metricsLink(Integer linkId);

    public LinkDTO invalidateLink(Integer linkId);
}
