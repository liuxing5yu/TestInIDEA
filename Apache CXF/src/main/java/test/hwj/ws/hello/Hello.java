/**
 * 
 */
package test.hwj.ws.hello;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 * 
 *
 * @author hwj
 * @date 2019年3月25日 上午9:15:30 
 *
 */
@WebService
public interface Hello {

	@WebMethod
	String sayHello(@WebParam(name = "name") String name);

}
