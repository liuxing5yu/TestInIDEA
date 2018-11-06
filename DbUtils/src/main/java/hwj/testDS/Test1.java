/**
 * 
 */
package hwj.testDS;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;

import oracle.jdbc.pool.OracleDataSource;
import org.junit.jupiter.api.Test;

/**
 * 测试数据源1
 *
 * @author hwj
 * @date 2018年7月10日 上午9:23:44 
 *
 */
public class Test1 {

	private static final String driverClass = "oracle.jdbc.driver.OracleDriver";
	private static final String jdbcUrl = "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	private static final String user = "hwj";
	private static final String password = "hwj";

	/**
	 * DriverManager获取Connection
	 *
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	@Test
	public void test1() throws SQLException, ClassNotFoundException {
		Class.forName(driverClass);
		Connection conn = DriverManager.getConnection(jdbcUrl, user, password);
		System.out.println(conn);
	}

	/**
	 * C3P0获取Connection
	 *
	 * @throws PropertyVetoException
	 * @throws SQLException
	 */
	@Test
	public void test2() throws PropertyVetoException, SQLException {
		ComboPooledDataSource cpds = new ComboPooledDataSource();
		cpds.setDriverClass(driverClass);
		cpds.setJdbcUrl(jdbcUrl);
		cpds.setUser(user);
		cpds.setPassword(password);

		System.out.println(cpds.getConnection());
	}

	/**
	 * OracleDataSource获取Connection
	 *
	 * @throws SQLException
	 */
	@Test
	public void test3() throws SQLException {
		OracleDataSource ods = new OracleDataSource();
		ods.setURL(jdbcUrl);
		ods.setUser(user);
		ods.setPassword(password);
		System.out.println(ods.getConnection());
	}

	/**
	 * DBCP获取Connection
	 *
	 * @throws SQLException
	 */
	@Test
	public void test4() throws SQLException {
		BasicDataSource bds = new BasicDataSource();
		bds.setDriverClassName(driverClass);
		bds.setUrl(jdbcUrl);
		bds.setUsername(user);
		bds.setPassword(password);
		System.out.println(bds.getConnection());

		bds.close();
	}
	
	/**
	 * Druid获取Connection
	 *
	 * @throws SQLException
	 */
	@Test
	public void test5() throws SQLException {
		DruidDataSource dds = new DruidDataSource();
		dds.setDriverClassName(driverClass);
		dds.setUrl(jdbcUrl);
		dds.setUsername(user);
		dds.setPassword(password);
		
		System.out.println(dds.getConnection());
		
		dds.close();
	}
}
