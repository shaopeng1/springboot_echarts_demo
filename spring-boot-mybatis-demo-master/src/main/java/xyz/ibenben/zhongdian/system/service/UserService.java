package xyz.ibenben.zhongdian.system.service;

import java.util.List;

import xyz.ibenben.zhongdian.system.entity.User;

public interface UserService {
	public List<User> listUser();
	
	public void upUser(int state);
}
