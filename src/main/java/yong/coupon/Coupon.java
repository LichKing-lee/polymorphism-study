package yong.coupon;

import java.time.LocalDateTime;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class Coupon {
    private Long id;
    private PublishPeriod publishPeriod;
    private boolean isDuplicatable;
    private long totalPublishableCount;
    private long publishedCount;

    public Coupon(PublishPeriod publishPeriod, boolean isDuplicatable, long totalPublishableCount){
        this.id = CouponIdFactory.get();
        this.publishPeriod = publishPeriod;
        this.isDuplicatable = isDuplicatable;
        this.totalPublishableCount = totalPublishableCount;
    }

    public boolean isPublishableDateTime(LocalDateTime localDateTime){
        return this.publishPeriod.isBetween(localDateTime);
    }

    public boolean isPublishableRemainCount() {
        return this.totalPublishableCount > this.publishedCount;
    }

    public void publishing(){
        this.publishedCount++;
    }
}
