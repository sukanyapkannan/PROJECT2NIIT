package com.niit.Dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.Model.Blog;

public interface BlogDao 
{
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	
}
