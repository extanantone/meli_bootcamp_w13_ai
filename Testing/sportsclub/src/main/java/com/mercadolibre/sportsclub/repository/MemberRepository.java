package com.mercadolibre.sportsclub.repository;

import com.mercadolibre.sportsclub.model.MemberDTO;

import java.util.Set;

public interface MemberRepository {

    Set<MemberDTO> findAll();
}
