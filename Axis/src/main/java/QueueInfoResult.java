/**
 * 
 */

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;

/**
 * 统一返回数据结构
 *
 * @author hwj
 * @date 2019年3月25日 下午1:37:30 
 *
 */
public class QueueInfoResult {
	// 状态码，0为正常，其他为异常
	private int code;
	// 异常信息，code为0时，message为空
	private String message;
	// 返回结果信息
	private List<QueueUnit> data;

	public QueueInfoResult() {
	}

	public QueueInfoResult(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	public QueueInfoResult(int code, String message, List<QueueUnit> data) {
		super();
		this.code = code;
		this.message = message;
		this.data = data;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@XmlElementWrapper(name = "data")
	@XmlElements(value = { @XmlElement(name = "unit", type = QueueUnit.class) })
	public List<QueueUnit> getData() {
		return data;
	}

	public void setData(List<QueueUnit> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "QueueInfoResult [code=" + code + ", message=" + message + ", data=" + data + "]";
	}

	/**
	 * 正确返回
	 * 
	 *
	 * @return
	 */
	public static QueueInfoResult Ok() {
		return new QueueInfoResult(0, "");
	}

	public static QueueInfoResult Ok(List<QueueUnit> data) {
		return new QueueInfoResult(0, "", data);
	}

	/**
	 * 错误返回
	 * 
	 *
	 * @param message
	 * @return
	 */
	public static QueueInfoResult NotOk(String message) {
		return new QueueInfoResult(1, message);
	}
}
