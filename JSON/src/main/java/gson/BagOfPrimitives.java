package gson;

import com.google.gson.Gson;

/**
 * Object Examples
 *
 * @author hwj
 * @date 2019/3/11 17:18
 */
public class BagOfPrimitives {
	private int value1 = 1;
	private String value2 = "abc";
	private transient int value3 = 3;

	BagOfPrimitives() {
		// no-args constructor
	}

	public static void main(String[] args) {
		// Serialization
		BagOfPrimitives obj = new BagOfPrimitives();
		Gson gson = new Gson();
		String json = gson.toJson(obj);
		System.out.println(json);   // ==> json is {"value1":1,"value2":"abc"}

		BagOfPrimitives obj2 = gson.fromJson(json, BagOfPrimitives.class);
		System.out.println(obj2.value3);
	}
}
