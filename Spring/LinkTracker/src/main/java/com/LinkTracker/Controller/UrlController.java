package com.LinkTracker.Controller;

import com.LinkTracker.DTO.UrlDto;
import com.LinkTracker.DTO.UrlResponseDto;
import com.LinkTracker.Model.Url;
import com.LinkTracker.Service.IUrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/url")
public class UrlController {

    private IUrlService iUrlService;

    public UrlController(IUrlService iUrlService){
        this.iUrlService = iUrlService;
    }


    @PostMapping
    public UrlResponseDto addUrl(@RequestBody UrlDto urlDto){
        return iUrlService.addUrl(urlDto);
    }

    @GetMapping("/redir")
    public ResponseEntity<?> redirecciona(@RequestParam(defaultValue = "1") int id,@RequestParam(defaultValue = "") String password){
        HttpHeaders http = new HttpHeaders();
        http.add("Location",iUrlService.getUrlByIdAndPassword(id,password));
        return new ResponseEntity<>(http, HttpStatus.FOUND);
    }

    @PostMapping("/inv/{id}")
    public ResponseEntity<?> invalidar(@PathVariable int id){
        iUrlService.invalidateUrl(id);
        return ResponseEntity.ok().build();
    }

}
