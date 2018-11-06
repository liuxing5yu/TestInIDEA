package hwj.testDbUtils;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.BeanMapHandler;
import org.apache.commons.dbutils.handlers.ColumnListHandler;
import org.apache.commons.dbutils.handlers.KeyedHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBUtilsTest {
	private Connection conn = null;

	@Before
	public void initConnection() throws SQLException, ClassNotFoundException {
		printCurrentMethodName();
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:orcl", "hwj", "hwj");
	}

	// @Before
	public void initDatabase() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		runner.update(conn, "CREATE TABLE USER_INFO (userId VARCHAR2(20) PRIMARY KEY, userName VARCHAR2(50))");
	}

	@Test
	public void update() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		String suffix = Long.toHexString(System.currentTimeMillis());
		Integer result = runner.update(conn, "insert into USER_INFO(userId, userName) values(?, ?)", suffix,
				"name" + suffix);
		System.out.println("受影响记录条数：" + result);
	}

	@Test
	public void queryByScalarHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		Number number = runner.query(conn, "select count(*) from USER_INFO", new ScalarHandler<Number>());
		System.out.println(number.getClass());
		System.out.println("总记录记录条数：" + number);
	}

	@Test
	public void queryByArrayHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		Object[] results = runner.query(conn, "select * from USER_INFO", new ArrayHandler());
		System.out.println(Arrays.toString(results));
	}

	@Test
	public void queryByArrayListHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		List<Object[]> results = runner.query(conn, "select * from USER_INFO", new ArrayListHandler());
		for (Object[] object : results) {
			System.out.println(Arrays.asList(object));
		}
	}

	@Test
	public void queryByKeyedHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		Map<String, Map<String, Object>> results = runner.query(conn, "select * from USER_INFO",
				new KeyedHandler<String>());
		System.out.println(results);
	}

	@Test
	public void queryByColumnListHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		List<String> results = runner.query(conn, "select * from USER_INFO", new ColumnListHandler<String>());
		System.out.println(results);
	}

	@Test
	public void queryByMapHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		Map<String, Object> results = runner.query(conn, "select * from USER_INFO", new MapHandler());
		System.out.println(results);
	}

	@Test
	public void queryByMapListHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		List<Map<String, Object>> results = runner.query(conn, "select * from USER_INFO", new MapListHandler());
		System.out.println(results);
	}

	@Test
	public void queryByBeanHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		UserInfo results = runner.query(conn, "select * from USER_INFO", new BeanHandler<UserInfo>(UserInfo.class));
		System.out.println(results);
	}

	@Test
	public void queryByBeanListHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		List<UserInfo> results = runner.query(conn, "select * from USER_INFO",
				new BeanListHandler<UserInfo>(UserInfo.class));
		System.out.println(results);
	}

	@Test
	public void queryByBeanMapHandler() throws SQLException {
		printCurrentMethodName();
		QueryRunner runner = new QueryRunner();
		Map<String, UserInfo> results = runner.query(conn, "select * from USER_INFO",
				new BeanMapHandler<String, UserInfo>(UserInfo.class));
		System.out.println(results);
	}

	@After
	public void destory() {
		printCurrentMethodName();
		DbUtils.closeQuietly(conn);
	}

	/**
	* 打印当前运行方法名称
	*/
	public void printCurrentMethodName() {
		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		System.out.println("==================================================");
	}
}