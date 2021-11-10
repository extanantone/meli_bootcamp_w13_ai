package com.example.linktracker.controller;

import com.example.linktracker.exceptions.BadRequestException;
import com.example.linktracker.exceptions.NotFoundException;
import com.example.linktracker.model.Link;
import com.example.linktracker.dto.LinkDTO;
import com.example.linktracker.service.IlinkTrackerService;
import com.example.linktracker.service.LinkTrackerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/link")
public class LinkTrackerController {


    private IlinkTrackerService linkTrackerService;

    public LinkTrackerController(IlinkTrackerService linkTrackerService) {
        this.linkTrackerService = linkTrackerService;
    }

    @PostMapping()
    public ResponseEntity<LinkDTO> createUrl (@RequestBody Link url) {


        //// validar url

        return new ResponseEntity(linkTrackerService.createLink(url), HttpStatus.OK);

    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable("linkId") String linkId, @RequestParam("pass") String password) throws NotFoundException {


        String link = linkTrackerService.getLink(Integer.parseInt(linkId),password);
        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create(link)).build();
    }

    @GetMapping()
    public  ResponseEntity<List<LinkDTO>> getLink () {
        return new ResponseEntity<>(linkTrackerService.linkList(),HttpStatus.FOUND);
    }

    @PostMapping("/invalidate/{linkId}")
    public  ResponseEntity<LinkDTO> invalidate (@PathVariable("linkId") String linkId) throws NotFoundException {

        return new ResponseEntity<>(linkTrackerService.invalidate(Integer.parseInt(linkId)),HttpStatus.OK);

    }


}
