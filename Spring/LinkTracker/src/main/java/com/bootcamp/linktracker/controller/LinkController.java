package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkCreationReqDTO;
import com.bootcamp.linktracker.dto.LinkCreationResDTO;
import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/link")
public class LinkController {

    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping()
    public ResponseEntity<LinkCreationResDTO> createLink(@RequestBody LinkCreationReqDTO linkCreationReqDTO) {
        return new ResponseEntity<>(
                linkService.createLink(linkCreationReqDTO),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{linkId}")
    public RedirectView redirect(@PathVariable int linkId) {
        String redirectURL = linkService.getLink(linkId).getLinkURL();
        linkService.countVisit(linkId);
        return new RedirectView(redirectURL);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<LinkDTO> getLinkMetrics(@PathVariable int linkId) {
        return new ResponseEntity<>(
                linkService.getLink(linkId),
                HttpStatus.OK
        );
    }
}
