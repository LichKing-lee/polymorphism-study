package yong.validate;

import yong.request.CouponPublishRequest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class CouponPublishCheckContainer implements PublishCheckable {
    private final List<PublishCheckable> checkables;

    public CouponPublishCheckContainer(PublishCheckable... checkables){
        this.checkables = Collections.unmodifiableList(Arrays.asList(checkables));
    }

    @Override
    public boolean check(CouponPublishRequest request) {
        for(PublishCheckable checkable : this.checkables){
            if(!checkable.check(request)){
                return false;
            }
        }

        return true;
    }
}
