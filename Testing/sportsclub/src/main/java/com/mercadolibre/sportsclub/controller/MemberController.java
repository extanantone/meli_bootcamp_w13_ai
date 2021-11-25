package com.mercadolibre.sportsclub.controller;

import com.mercadolibre.sportsclub.model.MemberDTO;
import com.mercadolibre.sportsclub.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Set;

@RestController
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/addMember")
    public ResponseEntity<?> addMember(@RequestBody @Valid MemberDTO member) {
        this.memberService.createMember(member);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/getMember/{memberId}")
    public MemberDTO retrieveMember(@PathVariable Long memberId) {
        return this.memberService.getMember(memberId);
    }

    @PostMapping("/updateMember")
    public ResponseEntity<?> modifyStudent(@RequestBody @Valid MemberDTO member) {
        this.memberService.updateMember(member);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/deleteMember/{memberId}")
    public ResponseEntity<?> deleteMember(@PathVariable Long memberId) {
        this.memberService.deleteMember(memberId);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/listMembers")
    public Set<MemberDTO> listStudents() {
        return this.memberService.getAllMembers();
    }

}
