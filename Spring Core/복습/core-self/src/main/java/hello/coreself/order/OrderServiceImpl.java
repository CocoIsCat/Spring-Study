package hello.coreself.order;

import hello.coreself.discount.DiscountPolicy;
import hello.coreself.discount.FixDiscountPolicy;
import hello.coreself.member.Member;
import hello.coreself.member.MemberService;
import hello.coreself.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService{

    DiscountPolicy discountPolicy = new FixDiscountPolicy();
    MemberService memberService = new MemberServiceImpl();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberService.findMember(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
