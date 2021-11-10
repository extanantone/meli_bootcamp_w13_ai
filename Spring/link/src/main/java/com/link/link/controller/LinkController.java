package com.link.link.controller;

import com.link.link.dto.LinkDTO;
import com.link.link.service.LinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class LinkController {

    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }


    @PostMapping("create")
    public LinkDTO create(@RequestBody LinkDTO link){
        return linkService.create(link);
    }

    @GetMapping("link/{linkId}")
    public void redirect(@PathVariable Integer linkId, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirect(linkId);
        if(link!=null){
            response.sendRedirect(link.getLink());
        }else{
            response.sendError(404);
        }
    }

    @GetMapping(value="link/{linkId}", params={"password"})
    public void redirect(@PathVariable Integer linkId, @RequestParam String password, HttpServletResponse response) throws IOException {
        LinkDTO link = linkService.redirect(linkId, password);
        if(link!=null){
            response.sendRedirect(link.getLink());
        }else{
            response.sendError(404);
        }
    }

    @GetMapping("metrics/{linkId}")
    public Integer metrics(@PathVariable Integer linkId){
        return linkService.metrics(linkId);
    }

    @DeleteMapping("invalidate/{linkId}")
    public void invalidate(@PathVariable Integer linkId){
        linkService.invalidate(linkId);
    }

}
