package gson;

import com.google.gson.Gson;

/**
 * @author hwj
 * @date 2018/11/16 14:35
 */
public class Test1 {
	public static void main(String[] args) {
		// Serialization
		Gson gson = new Gson();

		gson.toJson(1);            // ==> 1
		gson.toJson("abcd");       // ==> "abcd"
		gson.toJson(new Long(10)); // ==> 10
		int[] values = {1};
		gson.toJson(values);       // ==> [1]

		// Deserialization
		int one = gson.fromJson("1", int.class);
		Integer two = gson.fromJson("1", Integer.class);
		Long three = gson.fromJson("1", Long.class);
		Boolean four = gson.fromJson("false", Boolean.class);
		String five = gson.fromJson("\"abc\"", String.class);
		String[] six = gson.fromJson("[\"abc\"]", String[].class);
	}
}
