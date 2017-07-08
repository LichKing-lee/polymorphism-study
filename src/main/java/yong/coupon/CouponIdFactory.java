package yong.coupon;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class CouponIdFactory {
    private static AtomicLong id = new AtomicLong(0);

    public static Long get(){
        return id.getAndAdd(1L);
    }
}
