package com.niit.Dao;

import java.util.List;

import com.niit.Model.Friend;
import com.niit.Model.User;

public interface FriendDao 
{
	List<User> listOfSuggestedUsers(String email);
	void addFriendRequest(Friend friend);
	List<Friend> getAllPendingRequests(String email);//loggedin user id
	void updateFriendRequest(Friend friend);
	List<User> listOfFriends(String email);
}
