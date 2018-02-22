package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.BlogDao;
import com.niit.Model.Blog;
import com.niit.Model.Jobs;
@Repository("blogDao")
public class BlogDaoImpl implements BlogDao
{

	@Autowired
	private SessionFactory sessionF;
	public BlogDaoImpl(SessionFactory sessionF)
	{
		super();
		this.sessionF=sessionF;
	}
	public BlogDaoImpl()
	{
		super();
		
	}
	public boolean addBlog(Blog blog) 
	{
		
		try
		{Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(blog);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
	}

	public boolean updateBlog(Blog blog) 
	{
		try{
			Session s=sessionF.openSession();
			 s.beginTransaction();
			s.update(blog);
			s.flush();
			s.getTransaction().commit();
			s.close();
			return true;
			}
			catch(Exception e)
			{
				return false;
			}
	}

	public boolean deleteBlog(Blog blog)
	{
		try
		{
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.delete(blog);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Blog getBlog(int blogId)
	{
		Session s=sessionF.openSession();
		Blog blog=(Blog)s.get(Blog.class, blogId);
		return blog;
		
	}

	public List<Blog> getAllBlogs() {
		Session s=sessionF.openSession();
		List<Blog> blist=s.createQuery("from Blog").list();	
		return blist;
	}
	

}
