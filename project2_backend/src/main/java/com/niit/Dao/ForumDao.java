package com.niit.Dao;

import java.util.List;

import com.niit.Model.Forum;

public interface ForumDao 
{
	public boolean addForum(Forum forum);
	public boolean updateForum(Forum forum);
	public boolean deleteForum(Forum forum);
	public Forum getForum(int forumId);
	public List<Forum> getAllForum();
}
