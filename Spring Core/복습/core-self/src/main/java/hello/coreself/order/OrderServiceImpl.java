package hello.coreself.order;

import hello.coreself.discount.DiscountPolicy;
import hello.coreself.discount.FixDiscountPolicy;
import hello.coreself.member.Member;
import hello.coreself.member.MemberRepository;
import hello.coreself.member.MemberService;
import hello.coreself.member.MemberServiceImpl;

public class OrderServiceImpl implements OrderService{

    private final DiscountPolicy discountPolicy;
    private final MemberRepository memberRepository;

    public OrderServiceImpl(DiscountPolicy discountPolicy, MemberRepository memberRepository) {
        this.discountPolicy = discountPolicy;
        this.memberRepository = memberRepository;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);
        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
