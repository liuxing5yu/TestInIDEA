package jsonlib;

import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import net.sf.json.xml.XMLSerializer;
import org.junit.Test;

import java.util.*;

/**
 * @author hwj
 * @date 2018/11/20 17:05
 */
public class Test3 {

	/**
	 * JavaBean对象
	 */
	@Test
	public void test1() {
		// JavaBean对象转json字符串
		Student stu1 = new Student("lwc", "111111");
		JSONObject jsonObject = JSONObject.fromObject(stu1);
		System.out.println(jsonObject);

		// json字符串转JavaBean
		String jsondata = "{\"password\":\"111111\",\"username\":\"lwc\"}";
		JSONObject jsonObject1 = JSONObject.fromObject(jsondata);
		Student stu2 = (Student) JSONObject.toBean(jsonObject1, Student.class);
		System.out.println(stu2);
	}

	/**
	 * List
	 */
	@Test
	public void test2() {
		// List转json字符串
		List list = new ArrayList();
		list.add(new Student("lwc", "111111"));
		list.add(new Student("nxj", "222222"));
		JSONArray jsonArray = JSONArray.fromObject(list);
		System.out.println(jsonArray);

		// json字符串转List
		List list1 = new ArrayList();
		String jsondata = "[{\"password\":\"111111\",\"username\":\"lwc\"},{\"password\":\"222222\",\"username\":\"nxj\"}]";
		JSONArray jsonArray1 = JSONArray.fromObject(jsondata);
		for (int i = 0; i < jsonArray1.size(); i++) {
			JSONObject jsonObject2 = jsonArray1.getJSONObject(i);
			Student stu2 = (Student) JSONObject.toBean(jsonObject2, Student.class);
			list1.add(stu2);
		}
		System.out.println(list1);


		//JSONArray转型List
		List<Student> list2 = JSONArray.toList(jsonArray, new Student(), new JsonConfig());
		Iterator<Student> ite = list2.iterator();
		while (ite.hasNext()) {
			Student stu = ite.next();
			System.out.println(stu);
		}
	}

	/**
	 * Map
	 */
	@Test
	public void test3() {
		// Map转json字符串
		Map map = new HashMap();
		map.put("1", new Student("lwc", "111111"));
		map.put("2", new Student("nxj", "222222"));
		JSONObject jsonMap = JSONObject.fromObject(map);
		System.out.println("1.  " + jsonMap);

		// json字符串转Map
		String jsondata = "{\"2\":{\"password\":\"222222\",\"username\":\"nxj\"},\"1\":{\"password\":\"111111\",\"username\":\"lwc\"}}";
		Map map1 = (Map) JSONObject.fromObject(jsondata);
		System.out.println("2.  " + map1);
		Set set = map1.keySet();
		Iterator ite = set.iterator();
		while (ite.hasNext()) {
			String key = (String) ite.next();
			JSONObject jsonObject = JSONObject.fromObject(map1.get(key));
			Student stu = (Student) JSONObject.toBean(jsonObject, Student.class);
			System.out.println(key + " " + stu);
		}
	}


	/**
	 * 数组
	 */
	@Test
	public void test5() {
		// Java数组转JSONArray
		boolean[] boolArray = new boolean[]{true, false, true};
		JSONArray jsonArray = JSONArray.fromObject(boolArray);
		System.out.println(jsonArray.toString());

		// JSONArray转Java数组
		Object obj[] = jsonArray.toArray();
		for (Object o : obj) {
			System.out.print(o + " ");
		}
	}

	/**
	 * XML，需要导入xom-1.1.jar
	 */
	@Test
	public void test6() {
		// XML转JSON
		String xml = "<root>" + "<name type='type'>zhaipuhong</name>" + "<gender>male</gender>" + "<birthday>" + "<year>1970</year>" + "<month>12</month>" + "<day>17</day>" + "</birthday>" + "</root>";
		XMLSerializer xmlSerializer = new XMLSerializer();
		JSON json = xmlSerializer.read(xml);
		System.out.println(json.toString(2));

		// JSON转XML
		String jsondata = "{\"root\":{" + "\"name\":\"zhaipuhong\"," + "\"gender\":\"male\"," + "\"birthday\":{" + "\"year\":\"1970\"," + "\"month\":\"12\"," + "\"day\":\"17\"" + "}" + "}" + "}";
		JSONObject jsonObject = JSONObject.fromObject(jsondata);
		String xmlstr = new XMLSerializer().write(jsonObject);
		System.out.println(xmlstr);
	}


}
