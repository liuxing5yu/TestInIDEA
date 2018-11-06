/**
 * 
 */
package hwj.testDbUtils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.dbutils.ResultSetHandler;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月11日 下午7:47:13 
 *
 */
public class MyResultSetHandler implements ResultSetHandler<List<UserInfo>> {
	@Override
	public List<UserInfo> handle(ResultSet rs) throws SQLException {
		List<UserInfo> list = new ArrayList<UserInfo>();
		while (rs.next()) {
			UserInfo u = new UserInfo();
			u.setUserId(rs.getString("userid"));
			u.setUserName(rs.getString("userid"));
			list.add(u);
		}
		return list;
	}
}
