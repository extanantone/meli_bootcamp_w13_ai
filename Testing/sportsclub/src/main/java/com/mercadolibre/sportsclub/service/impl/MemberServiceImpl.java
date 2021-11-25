package com.mercadolibre.sportsclub.service.impl;

import com.mercadolibre.sportsclub.model.MemberDTO;
import com.mercadolibre.sportsclub.repository.MemberDAO;
import com.mercadolibre.sportsclub.repository.MemberRepository;
import com.mercadolibre.sportsclub.service.MemberService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    private final MemberRepository memberRepository;

    public MemberServiceImpl(MemberDAO memberDAO, MemberRepository memberRepository) {
        this.memberDAO = memberDAO;
        this.memberRepository = memberRepository;
    }

    @Override
    public void createMember(MemberDTO member) {
        memberDAO.save(member);
    }

    @Override
    public MemberDTO getMember(Long memberId) {
        return memberDAO.findById(memberId);
    }

    @Override
    public void updateMember(MemberDTO member) {
        memberDAO.save(member);
    }

    @Override
    public void deleteMember(Long memberId) {
        memberDAO.delete(memberId);
    }

    @Override
    public Set<MemberDTO> getAllMembers() {
        return this.memberRepository.findAll();
    }
}
