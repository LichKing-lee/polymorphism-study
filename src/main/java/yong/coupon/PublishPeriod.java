package yong.coupon;

import java.time.LocalDateTime;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class PublishPeriod {
    private LocalDateTime publishStartDatetime;
    private LocalDateTime publishEndDatetime;

    public PublishPeriod(LocalDateTime publishStartDatetime, LocalDateTime publishEndDatetime){
        this.publishStartDatetime = publishStartDatetime;
        this.publishEndDatetime = publishEndDatetime;
    }

    public boolean isBetween(LocalDateTime localDateTime){
        return (localDateTime.isAfter(this.publishStartDatetime)) && (localDateTime.isBefore(this.publishEndDatetime))
                || localDateTime.isEqual(this.publishStartDatetime);
    }
}
