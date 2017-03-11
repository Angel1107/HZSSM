package com.sixstar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sixstar.dao.UserDao;
import com.sixstar.entity.User;

@Service("userService")
public class UserService {
	@Autowired
	private UserDao userDao;
	
	public boolean login(User user){
		User result = userDao.login(user);
		if(result!=null){
			return true;
		}else{
			return false;
		}
	}
}
