package org.example;

import junit.framework.TestCase;
import org.example.util.LettuceUtil;

/**
 * @author Chen Manman
 * @since 2023/4/4 21:36
 */
public class LettuceTest extends TestCase {
    public void test1() {
        LettuceUtil util = LettuceUtil.getInstance("127.0.0.1", 6379);
        String res = util.set("123", "456");
        assertEquals(res, "OK");
    }

    public void test2() {
        LettuceUtil util = LettuceUtil.getInstance("127.0.0.1", 6379);
        String res = util.set("123", "456");
        assertEquals(res, "OK");
    }
}
