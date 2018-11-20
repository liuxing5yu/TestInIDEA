package jsonlib;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSONObject 的使用
 *
 * @author hwj
 * @date 2018/11/20 16:10
 */
public class Test1 {
	public static void main(String[] args) {
		// 创建JSONObject
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "lwc");
		jsonObject.put("password", "123");
		// 打印:1
		System.out.println(jsonObject);

		// 增加属性,打印:2
		jsonObject.element("sex", "男");
		System.out.println(jsonObject);

		// 根据key返回,打印:3
		System.out.println(jsonObject.get("sex"));

		// 判读输出对象的类型
		boolean isArray = jsonObject.isArray();
		boolean isEmpty = jsonObject.isEmpty();
		boolean isNullObject = jsonObject.isNullObject();
		// 打印:4
		System.out.println("是否数组:" + isArray + " 是否空:" + isEmpty + " 是否空对象:" + isNullObject);

		// 把JSONArray增加到JSONObject中
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(0, "lwc");
		jsonArray.add(1, "nxj");
		// 开始增加
		jsonObject.element("student", jsonArray);
		// 打印:5
		System.out.println(jsonObject);
	}
}
