package yong.validate;


import yong.request.CouponPublishRequest;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class PublishValidator {
    public boolean validate(CouponPublishRequest request){
        // 발급가능 유효기간
        if(!request.isPublishableDateTime()){
            return false;
        }

        // 쿠폰 잔여 수량
        if(!request.isPublishableRemainCount()){
            return false;
        }

        return true;
    }
}


// 발급가능 유효기간

// 쿠폰 잔여 수량

// 중복 발급 가능한 쿠폰인가
// 해당 회원이 쿠폰을 보유중인가