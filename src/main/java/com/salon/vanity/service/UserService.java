package com.salon.vanity.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salon.vanity.dao.UserDao;
import com.salon.vanity.model.Login;
import com.salon.vanity.model.User;

@Service
public class UserService {

	@Autowired
	  UserDao userDao;

	  public int register(User user) {
	    return userDao.register(user);
	  }

	  public int validateUser(Login login) {
	    return userDao.validateUser(login);
	  }
}