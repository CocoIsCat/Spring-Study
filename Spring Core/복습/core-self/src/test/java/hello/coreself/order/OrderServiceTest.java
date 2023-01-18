package hello.coreself.order;

import hello.coreself.discount.DiscountPolicy;
import hello.coreself.member.Grade;
import hello.coreself.member.Member;
import hello.coreself.member.MemberService;
import hello.coreself.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderServiceTest {
    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(order.calculatePrice()).isEqualTo(9000);
    }

    @Test
    void createBasicOrder() {
        Member member = new Member(2L, "memberB", Grade.BASIC);
        memberService.join(member);

        //when
        Order order = orderService.createOrder(member.getId(), "itemA", 10000);

        //then
        Assertions.assertThat(order.calculatePrice()).isEqualTo(10000);
    }
}