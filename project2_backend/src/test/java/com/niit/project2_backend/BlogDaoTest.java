package com.niit.project2_backend;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.BlogDao;
import com.niit.Model.Blog;

public class BlogDaoTest 
{
	@Autowired
	private static BlogDao blogDao;
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		blogDao=(BlogDao)context.getBean("blogDao");
	}
		
		@Ignore
		@Test
		public void addBlog()
		{
			Blog blog=new Blog();
			blog.setBlogName("how to be successful");
			blog.setBlogContent("fytgfyuegtfyuefgrhfgb");
			
			
			assertTrue("Problem in inserting blog",blogDao.addBlog(blog));		
		}
		 @Ignore
		@Test
		public void getBlog()
		{
			Blog blog=blogDao.getBlog(1);
			System.out.println(blog.getBlogContent());
			
			
		}
		
		 @Ignore
		@Test
		public void getAllBlogs()
		{
			
			List<Blog> blog=(List<Blog>)blogDao.getAllBlogs();
			for(Blog b:blog)
			{
				System.out.println(b.getBlogContent());
				
			}
			
		}
		 @Ignore
	@Test
	public void updateBlog()
	{

		Blog blog=blogDao.getBlog(1);
		blog.setBlogName("how to be successful");
		assertTrue("problem in updating blog",blogDao.updateBlog(blog));
		
	}
		 @Ignore
		@Test
		public void deleteBlog()
		{
			
			Blog blog=blogDao.getBlog(67);
			assertTrue("problem in deleting blog",blogDao.deleteBlog(blog));
		}

	}

