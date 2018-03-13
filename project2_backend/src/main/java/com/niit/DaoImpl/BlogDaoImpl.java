package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.BlogDao;
import com.niit.Model.Blog;
import com.niit.Model.BlogComment;
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
	@Transactional
	public boolean addBlogComment(BlogComment blogcomment) {
		try
		{
		sessionF.getCurrentSession().save(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}

	}
	@Transactional
	public boolean deleteBlogComment(BlogComment blogcomment) 
	{
		try
		{
		sessionF.getCurrentSession().delete(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}

		
	}
	@Transactional
	public boolean updateBlogComment(BlogComment blogcomment) 
	{
		try
		{
		sessionF.getCurrentSession().update(blogcomment);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	
	@Transactional
	public BlogComment getBlogComment(int BCId) 
	{
		Session session=sessionF.openSession();
		BlogComment blogcomment = (BlogComment) session.get(BlogComment.class, BCId);
		session.close();
		return blogcomment;
	}
	@Transactional
	public ArrayList<BlogComment> getAllBlogComments(int blogId) 
	{
		Session s=sessionF.openSession();
		org.hibernate.Query q= s.createQuery("from BlogComment where blogId="+blogId);
		ArrayList<BlogComment> l=(ArrayList<BlogComment>) q.list();
	    s.close();
		return l;
	}
	
	@Transactional
	public boolean like(int blogId) 
	{
		try
		{
			Session session=sessionF.openSession();
			Blog blog = (Blog) session.get(Blog.class, blogId);
			session.update(blog);
		    return true;
		}
		catch(Exception e)
		{
		   System.out.println(e);
		   return false;
		}
	}
	
	
	
	@Transactional
	public boolean incview(int blogId) {
		try
		{
			Session session=sessionF.openSession();
			Blog blog = (Blog) session.get(Blog.class, blogId);
			session.update(blog);
			return true;
		}
		catch(Exception e)
		{
			System.out.println(e);
			return false;
		}	
	}
	
	@Transactional
	public ArrayList<Blog> getAllBlogRequests()
	{
		Session session = sessionF.openSession();
		ArrayList<Blog> blogreq=(ArrayList<Blog>)session.createQuery("from Blog where status='A'").list();
		session.close();
		return blogreq;	
	}
	
	@Transactional
	public ArrayList<Blog> getAllMyBlogs(String email) 
	{
		Session session = sessionF.openSession();
		ArrayList<Blog> myblogs=(ArrayList<Blog>)session.createQuery("from Blog where username='"+email+"'").list();
		session.close();
		return myblogs;	
	}
	

}
