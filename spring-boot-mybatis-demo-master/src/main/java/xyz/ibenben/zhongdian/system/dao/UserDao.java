package xyz.ibenben.zhongdian.system.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;

import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.User;
public interface UserDao extends BaseDao<User>{
	
	@Select("select * from u_user")
	public List<User> selectByState();
	
	@Select("select * from u_user where nickname = #{name}")
	public User findByName(String name);
}
