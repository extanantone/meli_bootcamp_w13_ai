package com.mercadolibre.sportsclub.service.impl;

import com.mercadolibre.sportsclub.model.ActivityDTO;
import com.mercadolibre.sportsclub.model.MemberDTO;
import com.mercadolibre.sportsclub.repository.MemberDAO;
import com.mercadolibre.sportsclub.service.SportClubService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportClubServiceImpl implements SportClubService {

    private final MemberDAO memberDAO;

    public SportClubServiceImpl(MemberDAO memberDAO) {
        this.memberDAO = memberDAO;
    }

    @Override
    public MemberDTO calculateFee(Long memberId) {
        MemberDTO member = memberDAO.findById(memberId);

        double totalFee = calculateTotalFee(member.getActivities());
        String message = buildCustomMessage(totalFee);
        member.setTotalFee(totalFee);
        member.setMessage(message);
        return member;
    }

    private String buildCustomMessage(double totalFee) {
        return totalFee < 2000 ? "Congratulations! You are a silver member." : "Congratulations! You are a gold member, now you have access to exclusive benefits.";
    }

    private double calculateTotalFee(List<ActivityDTO> activities) {
        return activities.stream()
                .mapToDouble(ActivityDTO::getFee)
                .sum();
    }
}
