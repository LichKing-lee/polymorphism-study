package yong.member;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by lichking on 2017. 7. 8..
 */
public class MemberIdFactory {
    private static AtomicLong id = new AtomicLong(0);

    public static Long get(){
        return id.getAndAdd(1L);
    }
}
