package com.niit.project2_middleware;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Dao.BlogDao;
import com.niit.Dao.UserDao;
import com.niit.Model.Blog;
import com.niit.Model.BlogComment;
import com.niit.Model.Jobs;
import com.niit.Model.User;


@RestController
@RequestMapping("/blog")
public class BlogController
{
	@Autowired
	UserDao udao;
	@Autowired
	BlogDao blogDao;
	
	@RequestMapping(value="/addBlog",method=RequestMethod.POST)
	public ResponseEntity<String> addBlog(@RequestBody Blog blog)
	{
		blog.setStatus("P");
		 SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
		   
		    String createDate = sm.format(new java.util.Date()).toString();
		blog.setCreateDate(createDate);
		boolean isSaved=blogDao.addBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("blog addes ok",HttpStatus.OK);
		else
			return new ResponseEntity<String>("blog add error",HttpStatus.BAD_REQUEST);
		
	}
	
	
	@RequestMapping(value="/getAllBlogs",method=RequestMethod.GET,headers = "Accept=application/json")
	public ArrayList<Blog> getAllBlogs(){
		
		System.out.println("in getall blogs");
		ArrayList<Blog> blogs=(ArrayList<Blog>)blogDao.getAllBlogs();
		for(Blog blo:blogs)
		{
			System.out.println(blo.getBlogName());
			System.out.println(blo.getBlogContent());
			
		}
				return blogs;
	
	}
	
	
	
	

	@RequestMapping(value="/deleteBlog/{blogId}",method=RequestMethod.GET)
	public String delete(@PathVariable("blogId") int id)
	{
		Blog b=blogDao.getBlog(id);
		blogDao.deleteBlog(b);
		
		return "blog deleted Successfully"+b.toString();
		
	}
	
	@RequestMapping(value="/updateBlog",method=RequestMethod.POST)
	public String update(@RequestBody Blog blog)
	{
		
		System.out.println("Blog for updated :"+blog.getBlogId()+blog.getStatus());
				blogDao.updateBlog(blog);
		
		 return "blog updated Successfully"+blog.toString();
		
	}
	
	@RequestMapping(value="/getBlogById/{blogId}",method=RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<Blog>  getBlogById(@PathVariable("blogId") int blogId )
	{
		System.out.println("blog by id :"+blogId);
		Blog blog=blogDao.getBlog(blogId);
		
		
		
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
	
	@RequestMapping(value="/getAllMyBlogs/{userid}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<Blog>> getAllMyBlogs(@PathVariable("userid") int userid)
	{
		System.out.println("user id:"+userid);
		User user=udao.getUser(userid);
		ArrayList<Blog> myblogs=blogDao.getAllMyBlogs(user.getUsername());
		return new ResponseEntity<ArrayList<Blog>>(myblogs,HttpStatus.OK);
	
	
	
	}
	
	/*@RequestMapping(value="/addBlogComments/{blogId}/{userId}/{cmnt}/{username}",method=RequestMethod.GET)
	public ResponseEntity<String> addBlogComments(@PathVariable("blogId") int blogid,@PathVariable("userId") int u,@PathVariable("cmnt") int cmnt , @PathVariable("username") String username)
	{
		System.out.println(blogid+u+cmnt+username);
BlogComment blogcomment=new BlogComment();
blogcomment.setBCId(blogid);
blogcomment.setBCId(cmnt);
blogcomment.setUserId(u);
blogcomment.setUsername(username);
		boolean isSaved=blogDao.addBlogComment(blogcomment);
		if(isSaved)
		{
		return new ResponseEntity<String>("Blogcomment added successfully",HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<String>("Problem in adding blog comment",HttpStatus.BAD_REQUEST);
		}
	}
	*/
	
	@RequestMapping(value="/addBlogComment",method=RequestMethod.POST)
	public ResponseEntity<String> addBlogComment(@RequestBody BlogComment blogcomment)
	{
		SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy"); 
		String cmntDate = sm.format(new java.util.Date()).toString();
		blogcomment.setCmntDate(cmntDate);
		boolean isSaved=blogDao.addBlogComment(blogcomment);
		if(isSaved)
		return new ResponseEntity<String>("blog comment added",HttpStatus.OK);
		else
			return new ResponseEntity<String>("blog comment failed",HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/getAllBlogComments/{blogId}",method=RequestMethod.GET,headers = "Accept=application/json")
	public ArrayList<BlogComment> getAllBlogComment(@PathVariable("blogId") int blogId){
	
	ArrayList<BlogComment> blogcomments=blogDao.getAllBlogComments(blogId);
	if(blogcomments.isEmpty()){
		return null;
	}
	else
	{
	return blogcomments;
			
	}
	}
	
	@RequestMapping(value="/likeBlog/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<String> likeBlog(@PathVariable("blogId") int blogId){
		
		Blog blog=blogDao.getBlog(blogId);
		blog.setLikes(blog.getLikes()+1);
	    System.out.println("--------------------------"+blogId);
		boolean isSaved=blogDao.updateBlog(blog);
		if(isSaved)
		return new ResponseEntity<String>("Blog liked successfully",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Problem in liking blog",HttpStatus.BAD_REQUEST);
		
	}	
	

}
