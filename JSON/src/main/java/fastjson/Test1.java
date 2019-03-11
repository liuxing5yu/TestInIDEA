package fastjson;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import fastjson.bean.Person;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test1 {
    private List<Person> listOfPersons = new ArrayList<Person>();

    @Before
    public void setUp() {
        listOfPersons.add(new Person(15, "John Doe", new Date()));
        listOfPersons.add(new Person(20, "Janette Doe", new Date()));
    }

    @Test
    public void whenJavaList_thanConvertToJsonCorrect() {
        String jsonOutput = JSON.toJSONString(listOfPersons);
        System.out.println(jsonOutput);
        // [{"AGE":15,"DATE OF BIRTH":1552305572514,"FULL NAME":"John Doe"},{"AGE":20,"DATE OF BIRTH":1552305572514,"FULL NAME":"Janette Doe"}]
        List<Person> people = JSON.parseArray(jsonOutput, Person.class);
        System.out.println(people);
    }
}
