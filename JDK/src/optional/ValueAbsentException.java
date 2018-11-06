/**
 * 
 */
package optional;

/**
 * 
 *
 * @author hwj
 * @date 2018年3月6日 上午8:21:56 
 *
 */
public class ValueAbsentException extends Throwable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ValueAbsentException() {
		super();
	}

	public ValueAbsentException(String msg) {
		super(msg);
	}

	@Override
	public String getMessage() {
		return "No value present in the Optional instance";
	}
}
