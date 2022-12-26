package com.example.springhelloself.service;

import com.example.springhelloself.domain.Member;
import com.example.springhelloself.repository.MemberRepository;
import com.example.springhelloself.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    /**
     * 회원 가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplicateMember(member);

        Member save = memberRepository.save(member);
        return save.getId();
    }

    /**
     * 중복 회원 검증
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(member1 -> {
           throw new IllegalStateException("이미 존재하는 회원입니다.");
       });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findAllMembers() {
        return memberRepository.findAll();
    }

    /**
     * ID로 회원 조회
     * @param memberId
     * @return
     */
    public Optional<Member> findMemberById(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
