package hello.coreself.member;

import hello.coreself.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        //given
        Member member1 = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member1);
        Member memberA = memberService.findMember(member1.getId());

        //then
        Assertions.assertThat(member1).isEqualTo(memberA);

    }

    @Test
    void findMember() {
        //given
        Member member1 = new Member(1L, "memberA", Grade.VIP);
        Member member2 = new Member(2L, "memberB", Grade.BASIC);

        //when
        memberService.join(member1);
        memberService.join(member2);
        Member memberA = memberService.findMember(member1.getId());

        //then
        Assertions.assertThat(member1).isEqualTo(memberA);

    }
}