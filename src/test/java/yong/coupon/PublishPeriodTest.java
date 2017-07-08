package yong.coupon;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class PublishPeriodTest {
    private PublishPeriod publishPeriod;

    @Before
    public void setUp(){
    }

    @Test
    public void isBetween_1분전() throws Exception {
        this.publishPeriod = new PublishPeriod(LocalDateTime.of(2017, 7, 1, 12, 30),
                LocalDateTime.of(2017, 7, 31, 12, 0));

        LocalDateTime localDateTime = LocalDateTime.of(2017, 7, 1, 12, 29);

        assertThat(this.publishPeriod.isBetween(localDateTime), is(false));
    }

    @Test
    public void isBetween_경계값() throws Exception {
        this.publishPeriod = new PublishPeriod(LocalDateTime.of(2017, 7, 1, 12, 30),
                LocalDateTime.of(2017, 7, 31, 12, 0));

        LocalDateTime localDateTime = LocalDateTime.of(2017, 7, 1, 12, 30);

        assertThat(this.publishPeriod.isBetween(localDateTime), is(true));
    }

    @Test
    public void isBetween_1분후() throws Exception {
        this.publishPeriod = new PublishPeriod(LocalDateTime.of(2017, 7, 1, 12, 30),
                LocalDateTime.of(2017, 7, 31, 12, 0));

        LocalDateTime localDateTime = LocalDateTime.of(2017, 7, 31, 12, 0);

        assertThat(this.publishPeriod.isBetween(localDateTime), is(false));
    }
}