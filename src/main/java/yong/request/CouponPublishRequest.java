package yong.request;


import yong.coupon.Coupon;
import yong.member.Member;

import java.time.LocalDateTime;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class CouponPublishRequest {
    private Member member;
    private Coupon coupon;
    private LocalDateTime requestDateTime;

    public CouponPublishRequest(Member member, Coupon coupon, LocalDateTime requestDateTime){
        this.member = member;
        this.coupon = coupon;
        this.requestDateTime = requestDateTime;
    }

    public LocalDateTime getRequestDateTime(){
        return this.requestDateTime;
    }

    public Coupon getCoupon(){
        return this.coupon;
    }

    public boolean isPublishableDateTime(){
        return this.coupon.isPublishableDateTime(this.requestDateTime);
    }

    public boolean isPublishableRemainCount() {
        return this.coupon.isPublishableRemainCount();
    }
}
