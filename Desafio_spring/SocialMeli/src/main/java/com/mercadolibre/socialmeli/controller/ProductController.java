package com.mercadolibre.socialmeli.controller;

import com.mercadolibre.socialmeli.dto.PublicationDTO;
import com.mercadolibre.socialmeli.dto.PublicationsFollowDTO;
import com.mercadolibre.socialmeli.service.ISocialService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {
    final
    ISocialService socialService;

    public ProductController(ISocialService socialService) {
        this.socialService = socialService;
    }

    @PostMapping("/post")
    ResponseEntity<Boolean> addPublicationDTO(@Valid @RequestBody PublicationDTO publicationDTO){
        Boolean publicationsAdd = socialService.addPublication(publicationDTO);
        if(!publicationsAdd) return new ResponseEntity<>(publicationsAdd, HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(publicationsAdd, HttpStatus.OK);
    }

    @GetMapping("/followed/{user_id}/list")
    ResponseEntity<PublicationsFollowDTO> latestSellerPublication(@PathVariable Integer user_id){
        PublicationsFollowDTO publications = socialService.latestPublications(user_id);
        if (publications==null) return new ResponseEntity<>(publications,HttpStatus.BAD_REQUEST);
        return new ResponseEntity<>(publications,HttpStatus.OK);
    }

    @GetMapping(value = "/followed/{user_id}/list",params = "order")
    PublicationsFollowDTO sortPublicationsSellers(
           @PathVariable Integer user_id,
           @RequestParam (defaultValue = "date_desc") String order){
        return socialService.sortPublicationsSellers(user_id,order);
    }

}
