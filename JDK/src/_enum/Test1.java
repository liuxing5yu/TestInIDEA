/**
 *
 */
package _enum;

/**
 * @author hwj
 * @date 2018年3月22日 下午3:09:56
 */
public class Test1 {
    public static void main(String[] args) {
        E e = E.valueOf("ONE");
        System.out.println(e);

        E e2 = E.values()[1];
        System.out.println(e2);
    }

    private enum E {
        ONE, TWO, THREE
    }
}
