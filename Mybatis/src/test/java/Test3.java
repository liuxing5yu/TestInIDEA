import org.apache.ibatis.io.Resources;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.mybatis.example.bean.UserInfo;
import org.mybatis.example.mapper.UserInfoMapper;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author hwj
 * @date 2019/4/8 21:43
 */
public class Test3 {
	@Test
	public void test1() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);

		SqlSession session = sqlSessionFactory.openSession();

		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		List<UserInfo> userInfos = mapper.selectList4("batchid-001");
		System.out.println(userInfos);

		session.close();
	}
}
