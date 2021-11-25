package com.mercadolibre.sportsclub.service;

import com.mercadolibre.sportsclub.model.MemberDTO;

public interface SportClubService {

    MemberDTO calculateFee(Long memberId);
}
