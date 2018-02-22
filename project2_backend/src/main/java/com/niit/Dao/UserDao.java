package com.niit.Dao;


import java.util.List;

import com.niit.Model.User;

public interface UserDao 
{
    boolean saveUser(User u);
	
	User getUser(int id);

	List<User> getAllUser();

	
	void updateUser(User user);
}
