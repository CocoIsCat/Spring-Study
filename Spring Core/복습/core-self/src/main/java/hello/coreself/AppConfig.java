package hello.coreself;

import hello.coreself.discount.DiscountPolicy;
import hello.coreself.discount.FixDiscountPolicy;
import hello.coreself.discount.RateDiscountPolicy;
import hello.coreself.member.MemberRepository;
import hello.coreself.member.MemberService;
import hello.coreself.member.MemberServiceImpl;
import hello.coreself.member.MemoryMemberRepository;
import hello.coreself.order.OrderService;
import hello.coreself.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(MemberRepository());
    }

    @Bean
    public static MemberRepository MemberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(DiscountPolicy(), MemberRepository());
    }

    @Bean
    public static DiscountPolicy DiscountPolicy() {
        return new RateDiscountPolicy();
    }
}
