/**
 * 
 */
package hwj.testDbUtils;

/**
 * 
 *
 * @author hwj
 * @date 2018年7月4日 下午7:28:43 
 *
 */
public class UserInfo {
	private String userId;
	private String userName;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "UserInfo [userId=" + userId + ", userName=" + userName + "]";
	}

}
