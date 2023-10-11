package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class ConfigurationSingletonTest {

    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

         OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);
        MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);

        MemberRepository memberRepository1 = memberService1.getMemberRepository();
        MemberRepository memberRepository2 = orderService.getMemberRepository();

//        System.out.println("memberRepository = " + memberRepository);
//        System.out.println("memberRepository1 = " + memberRepository1);
//        System.out.println("memberRepository2 = " + memberRepository2);

        assertThat(memberService1.getMemberRepository()).isEqualTo(orderService.getMemberRepository());
        assertThat(memberRepository).isEqualTo(orderService.getMemberRepository());
    }
}
