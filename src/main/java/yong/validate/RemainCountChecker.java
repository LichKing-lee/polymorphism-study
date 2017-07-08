package yong.validate;

import yong.request.CouponPublishRequest;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class RemainCountChecker implements PublishCheckable {
    @Override
    public boolean check(CouponPublishRequest request) {
        return request.isPublishableRemainCount();
    }
}
