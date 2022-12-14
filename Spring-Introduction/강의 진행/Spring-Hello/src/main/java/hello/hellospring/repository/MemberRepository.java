package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member); //멤버 저장

    Optional<Member> findByID(Long id); //아이디로 회원 찾음

    Optional<Member> findByName(String name);   //이름으로 회원 찾음

    List<Member> findAll(); //모든 회원 찾아오기
}
