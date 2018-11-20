package jsonlib;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * JSONArray 的使用
 *
 * @author hwj
 * @date 2018/11/20 16:42
 */
public class Test2 {
	public static void main(String[] args) {
		//创建JSONArray
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(0, "lwc");
		jsonArray.add(1, "nxj");
		jsonArray.element("mxj");
		//打印:1
		System.out.println(jsonArray);

		//根据下标返回,打印:2
		System.out.println(jsonArray.get(0));

		//根据下标设置新值,打印:3
		jsonArray.set(0, "itlwc");
		System.out.println(jsonArray);

		//把JSONObject放入到JSONArray中
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("username", "lwc");
		jsonObject.put("password", "123");
		//开始增加,打印:4
		jsonArray.add(jsonObject);
		System.out.println(jsonArray);

		//遍历,打印:5
		for (int i = 0; i < jsonArray.size(); i++) {
			System.out.print(jsonArray.get(i) + "\t");
		}
	}
}
