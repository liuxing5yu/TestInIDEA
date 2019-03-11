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

        // дΪ�ַ���
        String text = mapper.writeValueAsString(friend);
        // дΪ�ļ�
        mapper.writeValue(new File("friend.json"), friend);
        // дΪ�ֽ���
        byte[] bytes = mapper.writeValueAsBytes(friend);
        System.out.println(text);
        // ���ַ����ж�ȡ
        Friend newFriend = mapper.readValue(text, Friend.class);
        System.out.println("���ַ����ж�ȡ��" + newFriend);
        // ���ֽ����ж�ȡ
        newFriend = mapper.readValue(bytes, Friend.class);
        System.out.println("���ֽ����ж�ȡ��" + newFriend);
        // ���ļ��ж�ȡ
        newFriend = mapper.readValue(new File("friend.json"), Friend.class);
        System.out.println("���ļ��ж�ȡ��" + newFriend);
    }
}
