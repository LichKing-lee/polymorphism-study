package yong.member;


import yong.coupon.Coupon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class Member {
    private Long id;
    private List<Coupon> coupons;

    public Member(){
        this(Collections.emptyList());
    }

    public Member(List<Coupon> coupons){
        this.id = MemberIdFactory.get();
        this.coupons = new ArrayList<>(coupons);
    }
}
