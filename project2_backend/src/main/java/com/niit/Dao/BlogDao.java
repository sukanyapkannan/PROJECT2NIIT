package com.niit.Dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.Model.Blog;
import com.niit.Model.BlogComment;

public interface BlogDao 
{
	public boolean addBlog(Blog blog);
	public boolean updateBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public Blog getBlog(int blogId);
	public List<Blog> getAllBlogs();
	public boolean addBlogComment(BlogComment blogcomment);
	public boolean deleteBlogComment(BlogComment blogcomment);
	public boolean updateBlogComment(BlogComment blogcomment);
	public BlogComment getBlogComment(int BCId);
	public ArrayList<BlogComment> getAllBlogComments(int blogId);
	public boolean like(int blogId);
	public boolean incview(int blogId);
	public ArrayList<Blog> getAllBlogRequests();
	public ArrayList<Blog> getAllMyBlogs(String email);
	
}
