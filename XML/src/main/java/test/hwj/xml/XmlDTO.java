package test.hwj.xml;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "xmlDTO", propOrder = {"status", "code", "message"})
public class XmlDTO {

	@XmlElement(name = "STATUS")
	protected Integer status;
	@XmlElement(name = "CODE")
	protected Integer code;
	@XmlElement(name = "MESSAGE")
	protected String message;


	/**
	 * 获取status属性的值。
	 *
	 * @return possible object is
	 * {@link Integer }
	 */
	public Integer getSTATUS() {
		return status;
	}

	/**
	 * 设置status属性的值。
	 *
	 * @param value allowed object is
	 *              {@link Integer }
	 */
	public void setSTATUS(Integer value) {
		this.status = value;
	}

	/**
	 * 获取code属性的值。
	 *
	 * @return possible object is
	 * {@link Integer }
	 */
	public Integer getCODE() {
		return code;
	}

	/**
	 * 设置code属性的值。
	 *
	 * @param value allowed object is
	 *              {@link Integer }
	 */
	public void setCODE(Integer value) {
		this.code = value;
	}

	/**
	 * 获取message属性的值。
	 *
	 * @return possible object is
	 * {@link String }
	 */
	public String getMESSAGE() {
		return message;
	}

	/**
	 * 设置message属性的值。
	 *
	 * @param value allowed object is
	 *              {@link String }
	 */
	public void setMESSAGE(String value) {
		this.message = value;
	}


}
