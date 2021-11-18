package com.salon.vanity.dao;

import com.salon.vanity.model.Login;

import com.salon.vanity.model.User;

public interface UserDao {
	
  int register(User user);
  int validateUser(Login login);
  
}
