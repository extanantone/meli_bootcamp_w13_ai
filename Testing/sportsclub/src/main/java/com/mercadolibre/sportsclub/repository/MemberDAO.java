package com.mercadolibre.sportsclub.repository;

import com.mercadolibre.sportsclub.model.MemberDTO;

public interface MemberDAO {

    MemberDTO findById(Long memberId);

    void save(MemberDTO member);

    boolean delete(Long memberId);

    boolean exists(MemberDTO stu);
}
