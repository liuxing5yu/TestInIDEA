/**
 * 
 */
package math;

public class MathTest {

	public static void main(String[] args) {

		System.out.println("绝对值：" + Math.abs(-12.7));

		System.out.println("大于等于参数的最小整数值：" + Math.ceil(12.7));
		System.out.println("小于等于参数的最小整数值：" + Math.floor(12.7));
		System.out.println("接近参数的最小整数值：" + Math.rint(12.5));

		System.out.println("a的b次方：" + Math.pow(3, 2));
		System.out.println("平方根：" + Math.sqrt(16));
		System.out.println("立方根：" + Math.cbrt(27));

		System.out.println("欧拉数 e 的 double 次幂：" + Math.exp(1));
		System.out.println("自然对数：" + Math.log(Math.exp(5)));
		System.out.println("底数为10的对数：" + Math.log10(1000));
		System.out.println("任何数的对数：" + Math.log(1000) / Math.log(10));

		System.out.println("两者之间最大值：" + Math.max(9, 5.5));
		System.out.println("两者之间最小值：" + Math.min(9, 5.5));

		System.out.println(Math.round(5.5));

		System.out.println(Math.random());
	}

}
