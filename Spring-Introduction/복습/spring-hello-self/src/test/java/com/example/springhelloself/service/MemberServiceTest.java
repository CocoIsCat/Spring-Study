package com.example.springhelloself.service;

import com.example.springhelloself.domain.Member;
import com.example.springhelloself.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }

    @Test
    void 회원가입() {
        //given
        Member member1 = new Member("spring");

        //when
        Long saveID = memberService.join(member1);

        //then
        Member member = memberService.findMemberById(saveID).get();
        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());
    }


    @Test
    void 중복_회원_검증() {
        //given
        Member member1 = new Member("spring");
        Member member2 = new Member("spring");

        //when
        memberService.join(member1);

        //then
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        Assertions.assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }


    @Test
    void 전체회원조회() {
        //given
        Member member1 = new Member("spring1");
        Member member2 = new Member("spring2");

        //when
        memberService.join(member1);
        memberService.join(member2);
        //then
        List<Member> allMembers = memberService.findAllMembers();
        Assertions.assertThat(allMembers.size()).isEqualTo(2);
    }

    @Test
    void ID로_조회() {
        //given
        Member member = new Member("spring1");

        //when
        Long joinID = memberService.join(member);

        //then
        Member member1 = memberService.findMemberById(joinID).get();
        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());
    }
}