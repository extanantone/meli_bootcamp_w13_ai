package com.mercadolibre.sportsclub.controller;

import com.mercadolibre.sportsclub.model.MemberDTO;
import com.mercadolibre.sportsclub.service.SportClubService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SportClubController {

    private final SportClubService sportClubService;

    public SportClubController(SportClubService sportClubService) {
        this.sportClubService = sportClubService;
    }

    @GetMapping("/calculateFee/{memberId}")
    public MemberDTO calculateFee(@PathVariable Long memberId) {
        return sportClubService.calculateFee(memberId);
    }
}
