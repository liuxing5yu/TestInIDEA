package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jackson.bean.Friend;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

public class Test1 {
    @Test
    public void test1() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Friend friend = new Friend("yitian", 25);

        // 写为字符串
        String text = mapper.writeValueAsString(friend);
        // 写为文件
        mapper.writeValue(new File("friend.json"), friend);
        // 写为字节流
        byte[] bytes = mapper.writeValueAsBytes(friend);
        System.out.println(text);
        // 从字符串中读取
        Friend newFriend = mapper.readValue(text, Friend.class);
        System.out.println("从字符串中读取：" + newFriend);
        // 从字节流中读取
        newFriend = mapper.readValue(bytes, Friend.class);
        System.out.println("从字节流中读取：" + newFriend);
        // 从文件中读取
        newFriend = mapper.readValue(new File("friend.json"), Friend.class);
        System.out.println("从文件中读取：" + newFriend);
    }
}
