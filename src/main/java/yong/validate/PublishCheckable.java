package yong.validate;

import yong.request.CouponPublishRequest;

/**
 * Created by lichking on 2017. 7. 8..
 */
public interface PublishCheckable {
    boolean check(CouponPublishRequest request);
}
