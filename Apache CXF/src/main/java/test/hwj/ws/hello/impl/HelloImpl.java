/**
 *
 */
package test.hwj.ws.hello.impl;


import test.hwj.ws.hello.Hello;

/**
 *
 *
 * @author hwj
 * @date 2019年3月25日 上午9:16:17 
 *
 */
public class HelloImpl implements Hello {

	@Override
	public String sayHello(String name) {
		return "Hello " + name;
	}

}
