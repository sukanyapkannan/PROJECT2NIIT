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
		return new ResponseEntity<String>("Job addes ok",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Job add error",HttpStatus.BAD_REQUEST);
		
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
	
	@RequestMapping(value="/getBlogById/{blogId}",method=RequestMethod.GET)
	public ResponseEntity<Blog>  getBlogById(@PathVariable("blogId") int bid )
	{
		Blog blog=blogDao.getBlog(bid);
		
		
		
		return new ResponseEntity<Blog>(blog,HttpStatus.OK);
	}
}
