package com.C4P2.LinkTracker.Controller;


import com.C4P2.LinkTracker.DTO.LinkDTO;
import com.C4P2.LinkTracker.Service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.xml.sax.EntityResolver;

@RestController
public class LinkController {

    ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<String> postLink (@RequestBody LinkDTO link)
    {
        int nuevaKey = linkService.crearLink(link);

        return new ResponseEntity<>(
                "El linkID es: " + nuevaKey,
                HttpStatus.OK);
    }


}
