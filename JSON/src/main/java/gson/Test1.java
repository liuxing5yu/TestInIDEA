package gson;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * https://github.com/google/gson/blob/master/UserGuide.md#TOC-Gson-With-Maven
 */
public class Test1 {
    /**
     * Primitives Examples
     */
    @Test
    public void test1() {
        // Serialization
        Gson gson = new Gson();
        System.out.println(gson.toJson(1));            // ==> 1
        System.out.println(gson.toJson("abcd"));       // ==> "abcd"
        System.out.println(gson.toJson(new Long(10))); // ==> 10
        System.out.println(gson.toJson(new int[]{1}));       // ==> [1]

        // Deserialization
        int int1 = gson.fromJson("1", int.class);
        Integer Integer1 = gson.fromJson("1", Integer.class);
        Long Long1 = gson.fromJson("1", Long.class);
        Boolean Boolean1 = gson.fromJson("false", Boolean.class);
        String String1 = gson.fromJson("\"abc\"", String.class);
        String[] StringArr1 = gson.fromJson("[abc]", String[].class);

        System.out.println(int1);
        System.out.println(Integer1);
        System.out.println(Long1);
        System.out.println(Boolean1);
        System.out.println(String1);
        System.out.println(Arrays.toString(StringArr1));
    }

    /**
     * Array Examples
     */
    @Test
    public void test2() {
        Gson gson = new Gson();
        int[] ints = {1, 2, 3, 4, 5};
        String[] strings = {"abc", "def", "ghi"};

        // Serialization
        System.out.println(gson.toJson(ints));     // ==> [1,2,3,4,5]
        System.out.println(gson.toJson(strings));  // ==> ["abc", "def", "ghi"]

        // Deserialization
        int[] ints2 = gson.fromJson("[1,2,3,4,5]", int[].class);
        // ==> ints2 will be same as ints
        System.out.println(Arrays.toString(ints2));
    }

    /**
     * Collections Examples
     */
    @Test
    public void test3() {
        Gson gson = new Gson();
        ArrayList<Integer> ints = new ArrayList<Integer>();
        ints.add(1);
        ints.add(2);
        ints.add(3);
        ints.add(4);
        ints.add(5);

        // Serialization
        String json = gson.toJson(ints);  // ==> json is [1,2,3,4,5]
        System.out.println(json);

        // Deserialization
        Type collectionType = new TypeToken<Collection<Integer>>() {
        }.getType();
        Collection<Integer> ints2 = gson.fromJson(json, collectionType);
        // ==> ints2 is same as ints
        System.out.println(ints2);
    }
}
