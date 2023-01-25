package hello.coreself;

import hello.coreself.member.Grade;
import hello.coreself.member.Member;
import hello.coreself.member.MemberService;
import hello.coreself.member.MemberServiceImpl;
import hello.coreself.order.Order;
import hello.coreself.order.OrderService;
import hello.coreself.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 20000);
        System.out.println("order.calculatePrice() = " + order.calculatePrice());
        System.out.println("order = " + order);
    }
}
