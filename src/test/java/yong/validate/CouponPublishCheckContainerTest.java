package yong.validate;

import org.junit.Before;
import org.junit.Test;
import yong.coupon.Coupon;
import yong.coupon.PublishPeriod;
import yong.member.Member;
import yong.request.CouponPublishRequest;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class CouponPublishCheckContainerTest {
    private PublishCheckable container;
    private CouponPublishRequest request;

    @Before
    public void setUp(){
        this.container = new CouponPublishCheckContainer(new DateTimeChecker(), new RemainCountChecker());
    }

    @Test
    public void validate_발급가능기간() throws Exception {
        this.request = new CouponPublishRequest(new Member(),
                new Coupon(new PublishPeriod(makeTodayMinusDay(15), makeTodayPlusDay(15)), false, 100), makeToday());

        assertThat(this.container.check(this.request), is(true));
    }

    private LocalDateTime makeToday(){
        return LocalDateTime.now();
    }

    private LocalDateTime makeTodayMinusDay(long day){
        return LocalDateTime.now().minusDays(day);
    }

    private LocalDateTime makeTodayPlusDay(long day){
        return LocalDateTime.now().plusDays(day);
    }

    @Test
    public void validate_발급불가기간() throws Exception {
        this.request = new CouponPublishRequest(new Member(),
                new Coupon(new PublishPeriod(makeTodayMinusDay(15), makeTodayPlusDay(15)), false, 100),
                LocalDateTime.of(2017, 5, 21, 17, 0));

        assertThat(this.container.check(this.request), is(false));
    }

    @Test
    public void validate_발급가능쿠폰개수() throws Exception {
        Coupon coupon = new Coupon(new PublishPeriod(makeTodayMinusDay(15), makeTodayPlusDay(15)), false, 100);
        this.request = new CouponPublishRequest(new Member(), coupon, makeToday());

        coupon.publishing();

        assertThat(this.container.check(this.request), is(true));
    }

    @Test
    public void validate_발급불가쿠폰개수() throws Exception {
        long totalPublishableCount = 100;
        Coupon coupon = new Coupon(new PublishPeriod(makeTodayMinusDay(15), makeTodayPlusDay(15)), false, totalPublishableCount);
        this.request = new CouponPublishRequest(new Member(), coupon, makeToday());

        for(int i = 0; i < totalPublishableCount; i++) {
            coupon.publishing();
        }

        assertThat(this.container.check(this.request), is(false));
    }
}