package hello.coreself.discount;

import hello.coreself.member.Member;

public interface DiscountPolicy {
    int discount(Member member, int price);
}
