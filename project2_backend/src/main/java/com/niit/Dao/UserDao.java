package com.niit.Dao;

import com.niit.Model.User;

public interface UserDao 
{
void saveUser(User u);
	
	User getUser(String mailid);
}
