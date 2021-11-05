package com.link.controller;

import com.link.dtos.UrlDto;
import com.link.dtos.UrlResponseDto;
import com.link.service.IUrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/link")
public class UrlController {

    private IUrlService iUrlService;

    public UrlController(IUrlService iUrlService){
        this.iUrlService = iUrlService;
    }


    @PostMapping
    public UrlResponseDto addUrl(@RequestBody UrlDto dto){
        return iUrlService.addUrl(dto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> redirect(@PathVariable int id,@RequestParam(defaultValue = "") String password){
        HttpHeaders h = new HttpHeaders();
        h.add("Location",iUrlService.getUrlByIdAndPassword(id,password));
        return new ResponseEntity<>(h, HttpStatus.MOVED_PERMANENTLY);
    }

    @PostMapping("/invalidate/{id}")
    public ResponseEntity<?> ivalidate(@PathVariable int id){
        iUrlService.invalidateUrl(id);
        return ResponseEntity.ok().build();
    }

}
