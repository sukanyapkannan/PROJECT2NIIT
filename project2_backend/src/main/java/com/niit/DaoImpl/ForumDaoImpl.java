package com.niit.DaoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.ForumDao;
import com.niit.Model.Blog;
import com.niit.Model.Forum;
@Repository("forumDao")
public class ForumDaoImpl implements ForumDao
{
	@Autowired
	private SessionFactory sessionF;
	public ForumDaoImpl(SessionFactory sessionF)
	{
		super();
		this.sessionF=sessionF;
	}
	public ForumDaoImpl()
	{
		super();
		
	}

	public boolean addForum(Forum forum)
	{
		try
		{Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(forum);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}

	public boolean updateForum(Forum forum) 
	{
		try{
			Session s=sessionF.openSession();
			 s.beginTransaction();
			s.update(forum);
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

	public boolean deleteForum(Forum forum) 
	{
		try
		{
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.delete(forum);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Forum getForum(int forumId) 
	{
		Session s=sessionF.openSession();
		Forum forum=(Forum)s.get(Forum.class, forumId);
		return forum;
	}

	public List<Forum> getAllForum()
	{
		Session s=sessionF.openSession();
		List<Forum> flist=s.createQuery("from Forum").list();	
		return flist;
	}

}
