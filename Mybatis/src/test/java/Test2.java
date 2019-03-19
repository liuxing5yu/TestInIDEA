import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mybatis.example.bean.UserInfo;
import org.mybatis.example.mapper.UserInfoMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hwj
 * @date 2019/3/19 15:02
 */
public class Test2 {

	SqlSession session;

	@Before
	public void before() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		session = sqlSessionFactory.openSession();
	}

	@After
	public void after() {
		session.close();
	}

	/**
	 *
	 */
	@Test
	public void test1() {
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		ArrayList<String> list = new ArrayList<>();
		list.add("batchid-110");
		list.add("batchid-220");
		list.add("batchid-330");
		List<UserInfo> userInfos = userInfoMapper.selectList(list);
		System.out.println(userInfos);
	}

	@Test
	public void test2() {
		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		ArrayList<String> list = new ArrayList<>();
		list.add("batchid-110");
		list.add("batchid-220");
		list.add("batchid-330");
		List<UserInfo> userInfos = userInfoMapper.selectList2(list, "batchname-111");
		System.out.println(userInfos);
	}
}
