/**
 *
 */
package builder;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @author hwj
 * @date 2018年5月16日 下午4:33:49
 */
public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        System.out.println(ToStringBuilder.reflectionToString(test1));
    }
}
