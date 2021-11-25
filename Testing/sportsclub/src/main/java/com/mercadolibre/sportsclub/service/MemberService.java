package com.mercadolibre.sportsclub.service;

import com.mercadolibre.sportsclub.model.MemberDTO;

import java.util.Set;

public interface MemberService {

    void createMember(MemberDTO member);

    MemberDTO getMember(Long memberId);

    void updateMember(MemberDTO member);

    void deleteMember(Long memberId);

    Set<MemberDTO> getAllMembers();
}
