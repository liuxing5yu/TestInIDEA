/**
 * 
 */
package hwj.testDbUtils;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

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
import org.junit.Before;
import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.sql.ROWID;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月11日 上午10:13:39 
 *
 */
public class Test1 {

	private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
	private static final String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String user = "hwj";
	private static final String password = "hwj";

	private DataSource dataSource = null;
	private Connection conn = null;
	private QueryRunner qr = null;

	/**
	 * 测试前操作
	 * @throws PropertyVetoException 
	 * @throws SQLException 
	 *
	 */
	@Before
	public void before() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(driverClass);
		cpds.setJdbcUrl(jdbcUrl);
		cpds.setUser(user);
		cpds.setPassword(password);

		dataSource = cpds;
		conn = cpds.getConnection();
		qr = new QueryRunner(dataSource, true);
	}

	/**
	 * @throws SQLException 
	 * 
	 *
	 */
	@Test
	public void test1() throws SQLException {
		QueryRunner run = new QueryRunner(dataSource);
		Object[] objArr = run.query("select * from user_info", new ArrayHandler());
		System.out.println(Arrays.toString(objArr));
	}

	@Test
	public void test2() throws SQLException {
		QueryRunner run = new QueryRunner();
		Object[] objArr = run.query(conn, "select * from user_info", new ArrayHandler());
		System.out.println(Arrays.toString(objArr));
	}

	/**
	 * 带参查询
	 *
	 * @throws SQLException
	 */
	@Test
	public void test3() throws SQLException {
		QueryRunner run = new QueryRunner(dataSource);
		Object[] objArr = run.query("select * from user_info where userid = ?", new ArrayHandler(), "16465140643");
		System.out.println(Arrays.toString(objArr));
	}

	@Test
	public void test4() throws SQLException {
		QueryRunner run = new QueryRunner(dataSource);
		int rows = run.update("update user_info set username = '12345' where userid = ?", "1646512dd7a");
		System.out.println(rows);
	}

	@Test
	public void test5() throws SQLException {
		String suffix = Long.toHexString(System.currentTimeMillis());

		QueryRunner run = new QueryRunner(dataSource, true);
		ROWID rowid = run.insert("insert into USER_INFO(userId, userName) values (?, ?)", new ScalarHandler<ROWID>(),
				suffix, "name" + suffix);
		System.out.println(rowid.stringValue());
	}

	@Test
	public void test6() throws SQLException {
		String suffix = Long.toHexString(System.currentTimeMillis());

		QueryRunner run = new QueryRunner(dataSource);
		int rows = run.update("insert into USER_INFO(userId, userName) values (?, ?)", suffix, "name" + suffix);
		System.out.println(rows);
	}

	@Test
	public void test7() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource, true);
		String sql = "insert into USER_INFO(userId, userName) values (?, ?)";
		Object[][] param = new Object[10][];
		for (int i = 0; i < 10; i++) {
			param[i] = new Object[2];
			param[i][0] = "batchid-" + i * 11 + 0;
			param[i][1] = "batchname-" + i * 11 + 1;
		}
		int[] batch = qr.batch(sql, param);

		System.out.println(Arrays.toString(batch));
	}

	/**
	 * ScalarHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test8() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource, true);
		Number number = qr.query("select count(*) from USER_INFO", new ScalarHandler<Number>());
		System.out.println(number);
	}

	/**
	 * ArrayHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test9() throws SQLException {
		QueryRunner qr = new QueryRunner(dataSource, true);
		Object[] results = qr.query("select * from USER_INFO where userid = ?", new ArrayHandler(), "batchid-550");
		System.out.println(Arrays.toString(results));
	}

	/**
	 * ArrayListHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test10() throws SQLException {
		List<Object[]> results = qr.query("select * from USER_INFO ", new ArrayListHandler());
		for (Object[] objects : results) {
			System.out.println(Arrays.toString(objects));
		}
	}

	/**
	 * KeyedHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test11() throws SQLException {
		Map<String, Map<String, Object>> map = qr.query("select * from USER_INFO ", new KeyedHandler<String>());
		System.out.println(map);
	}

	/**
	 * ColumnListHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test12() throws SQLException {
		List<String> list = qr.query("select * from USER_INFO ", new ColumnListHandler<String>("username"));
		System.out.println(list);
	}

	/**
	 * MapHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test13() throws SQLException {
		Map<String, Object> map = qr.query("select * from USER_INFO where userid = ?", new MapHandler(), "batchid-550");
		System.out.println(map);
	}

	/**
	 * MapListHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test14() throws SQLException {
		List<Map<String, Object>> list = qr.query("select * from USER_INFO ", new MapListHandler());
		System.out.println(list);
	}

	/**
	 * BeanHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test15() throws SQLException {
		UserInfo userInfo = qr.query("select * from USER_INFO where userid = ?",
				new BeanHandler<UserInfo>(UserInfo.class), "batchid-550");
		System.out.println(userInfo);
	}

	/**
	 * BeanListHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test16() throws SQLException {
		List<UserInfo> list = qr.query("select * from USER_INFO ", new BeanListHandler<UserInfo>(UserInfo.class));
		System.out.println(list);
	}

	/**
	 * BeanMapHandler
	 *
	 * @throws SQLException
	 */
	@Test
	public void test17() throws SQLException {
		Map<String, UserInfo> map = qr.query("select * from USER_INFO ",
				new BeanMapHandler<String, UserInfo>(UserInfo.class, "username"));
		System.out.println(map);
	}

	@Test
	public void test18() throws SQLException {
		List<UserInfo> list = qr.query("select * from USER_INFO ", new MyResultSetHandler());
		System.out.println(list);
	}
}
