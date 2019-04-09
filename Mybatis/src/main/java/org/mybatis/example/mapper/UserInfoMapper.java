package org.mybatis.example.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.mybatis.example.bean.UserInfo;

import java.util.List;
import java.util.Map;

/**
 * @author hwj
 * @date 2019/3/19 9:57
 */
public interface UserInfoMapper {
	UserInfo selectUserInfo(String id);

	UserInfo selectUserInfo2(@Param("id") String id, String name);

	List<UserInfo> selectList(List<String> list);

	List<UserInfo> selectList2(@Param("list") List<String> list, @Param("name") String name);

	List<UserInfo> selectList3(@Param("map") Map<String, String> map);

	List<UserInfo> selectList4(@Param("id") String id);
}
