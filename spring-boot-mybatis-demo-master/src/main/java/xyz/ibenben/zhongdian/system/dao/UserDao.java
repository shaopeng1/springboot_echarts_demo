package xyz.ibenben.zhongdian.system.dao;


import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import xyz.ibenben.zhongdian.common.BaseDao;
import xyz.ibenben.zhongdian.system.entity.User;

public interface UserDao extends BaseDao<User>{
	
	@Select("select * from user")
	public List<User> selectByState();
	
	@Update("update user state = state where id = 3")
	public void upUser(int state);
}
