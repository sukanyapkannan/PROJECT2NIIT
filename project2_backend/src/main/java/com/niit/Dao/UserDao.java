package com.niit.Dao;


import java.util.ArrayList;
import java.util.List;

import com.niit.Model.User;

public interface UserDao 
{
    boolean saveUser(User u);
	
	User getUser(int id);

	ArrayList<User> getAllUser();
	public ArrayList<User> getAllUsers();
	
	void updateUser(User user);

	

	boolean checkLogin(User user);

	void updateOnlineStatus(User tempuser);
	public User getUserbyemail(String email);
	public User getUserbyId(int userId);
	

	
}
