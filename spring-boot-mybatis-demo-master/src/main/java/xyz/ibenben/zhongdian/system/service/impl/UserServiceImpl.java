package xyz.ibenben.zhongdian.system.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import xyz.ibenben.zhongdian.system.dao.UserDao;
import xyz.ibenben.zhongdian.system.entity.User;
import xyz.ibenben.zhongdian.system.service.UserService;


@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	public List<User> listUser() {
		return userDao.selectByState();
	}

	public void upUser(int state) {
		userDao.upUser(state);
	}
}
