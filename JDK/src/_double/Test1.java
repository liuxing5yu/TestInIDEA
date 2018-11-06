package _double;


import org.junit.Test;

import java.math.BigDecimal;

/**
 * @author hwj
 * @date 2018年7月17日 下午4:52:00
 */
public class Test1 {
    Integer a = 123792;
    Integer b = 654365;

    /**
     * 测试Integer的除法得到double
     */
    @Test
    public void test1() {
        double div = (double) a / b;

        System.out.println((double) a / b);
        BigDecimal ba = new BigDecimal(a);
        BigDecimal bb = new BigDecimal(b);
        System.out.println(ba.divide(bb, BigDecimal.ROUND_HALF_UP));

        double score = new BigDecimal(div).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(score);
    }
}
