package test.hwj.spring.jdbctemplate;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @author hwj
 * @date 2019/5/15 20:54
 */
public class Test1 {
	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:spring1.xml");
		JdbcTemplate jdbcTemplate = ac.getBean("jdbcTemplate", JdbcTemplate.class);
		String sql = "select count(*)  from test_a";
		Long num = (long) jdbcTemplate.queryForObject(sql, Long.class);
		System.out.println(num);
	}
}
