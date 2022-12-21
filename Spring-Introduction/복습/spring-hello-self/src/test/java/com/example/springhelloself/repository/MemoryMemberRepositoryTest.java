package com.example.springhelloself.repository;

import com.example.springhelloself.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MemoryMemberRepositoryTest {

    MemoryMemberRepository memberRepository = new MemoryMemberRepository();


    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member("spring");
        Member newMember = memberRepository.save(member);

        Member result = memberRepository.findById(newMember.getId()).get();

        Assertions.assertThat(newMember).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member("spring1");
        Member newMember1 = memberRepository.save(member1);

        Member member2 = new Member("spring2");
        memberRepository.save(member2);

        Member result = memberRepository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(newMember1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member("spring1");
        memberRepository.save(member1);

        Member member2 = new Member("spring2");
        memberRepository.save(member2);

        List<Member> members = memberRepository.findAll();
        Assertions.assertThat(members.size()).isEqualTo(2);
    }
}
