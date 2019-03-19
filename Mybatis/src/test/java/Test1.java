import oracle.jdbc.pool.OracleDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.junit.Test;
import org.mybatis.example.bean.UserInfo;
import org.mybatis.example.mapper.UserInfoMapper;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author hwj
 * @date 2019/3/19 9:42
 */
public class Test1 {

	/**
	 * 使用xml配置的方式构建 SqlSessionFactory
	 * 使用Java 注解来做映射
	 *
	 * @throws IOException
	 */
	@Test
	public void test1() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);

		SqlSession session = sqlSessionFactory.openSession();

		UserInfo userInfo = (UserInfo) session.selectOne("org.mybatis.example.mapper.UserInfoMapper.selectUserInfo", "batchid-00");
		System.out.println(userInfo);

		session.close();
	}

	/**
	 * 使用xml配置的方式构建 SqlSessionFactory
	 * 使用对应的接口获取Mapper
	 *
	 * @throws IOException
	 */
	@Test
	public void test2() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);

		SqlSession session = sqlSessionFactory.openSession();

		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		UserInfo userInfo = mapper.selectUserInfo("batchid-00");

		System.out.println(userInfo);

		session.close();
	}

	/**
	 * 使用xml配置的方式构建 SqlSessionFactory
	 * 使用对应的接口获取Mapper
	 * 测试多个String参数
	 *
	 * @throws IOException
	 */
	@Test
	public void test3() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);

		SqlSession session = sqlSessionFactory.openSession();

		UserInfoMapper mapper = session.getMapper(UserInfoMapper.class);
		UserInfo userInfo = mapper.selectUserInfo2("batchid-00", "batchname-01");

		System.out.println(userInfo);

		session.close();
	}

	/**
	 * 使用xml配置的方式构建 SqlSessionFactory
	 * 直接使用xml配置文件中的方法
	 *
	 * @throws IOException
	 */
	@Test
	public void test4() throws IOException {
		InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		System.out.println(sqlSessionFactory);

		SqlSession session = sqlSessionFactory.openSession();

		UserInfo userInfo = (UserInfo) session.selectOne("org.mybatis.example.mapper.UserInfoMapper2.selectUserInfo", "batchid-00");
		System.out.println(userInfo);

		session.close();
	}

	/**
	 * 使用xml配置的方式构建 SqlSessionFactory
	 * 直接使用xml配置文件中的方法
	 *
	 * @throws IOException
	 */
	@Test
	public void test5() throws IOException, SQLException {
		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setDriverType("oracle.jdbc.driver.OracleDriver");
		dataSource.setURL("jdbc:oracle:thin:@localhost:1521:orcl");
		dataSource.setUser("hwj");
		dataSource.setPassword("hwj");

		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(configuration);

		configuration.addMapper(UserInfoMapper.class);

		SqlSession session = sqlSessionFactory.openSession();

		UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
		UserInfo userInfo = userInfoMapper.selectUserInfo("batchid-00");
		System.out.println(userInfo);
	}
}
