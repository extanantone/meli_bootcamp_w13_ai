package com.example.c4_man_excep_vivo_p1.controller;

import com.example.c4_man_excep_vivo_p1.dto.InputLinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.LinkDTO;
import com.example.c4_man_excep_vivo_p1.dto.MetricsDTO;
import com.example.c4_man_excep_vivo_p1.model.Link;
import com.example.c4_man_excep_vivo_p1.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController implements ILinkController
{
    @Autowired
    ILinkService linkService;

    @Override
    public LinkDTO createLink(InputLinkDTO inputLinkDTO)
    {
       return linkService.createLink(inputLinkDTO);
    }

    @Override
    public ResponseEntity<Void> redirectLink(Integer linkId)
    {
        return linkService.redirectLink(linkId);
    }

    @Override
    public MetricsDTO metricsLink(Integer linkId)
    {
        return linkService.metricsLink(linkId);
    }

    @Override
    public LinkDTO invalidateLink(Integer linkId)
    {
        return linkService.invalidateLink(linkId);
    }
}
