package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.UserDao;
import com.niit.Model.User;

@Repository("UserDao")
public class UserDaoImpl implements UserDao
{
	@Autowired
	private SessionFactory sessionF;
	
	
	public UserDaoImpl(SessionFactory sessionF) {
		super();
		this.sessionF = sessionF;
	}

	
	public UserDaoImpl() {
		super();
	}


	

	public boolean saveUser(User u) 
	{
		System.out.println("in saveUser"+u.getEmail());
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		return true;
		
	}



	public ArrayList<User> getAllUser() 
	{
		Session k=sessionF.openSession();
		ArrayList<User> ulist=(ArrayList<User>) k.createQuery("from User").list();
		return ulist;
		
				
	}


	

	public void updateUser(User user)
	{
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.update(user);
		s.getTransaction().commit();
		s.close();
		
		
	}


	public User getUser(int id) {
		
		Session k=sessionF.openSession();
		User c=(User)k.get(User.class, id);
		return c;
		
	}


	public boolean checkLogin(User user)
	{
		try{
			Session session=sessionF.openSession();
		    Query query=session.createQuery("from User where (email='"+user.getEmail()+"' and password='"+user.getPassword()+"') ");
			ArrayList<User> user1=(ArrayList<User>)query.list();
			
			if(user1.isEmpty())
			{
				return false;
			}
			else
			{
				return true;
			}
		   }
		catch(Exception e)
		{
			return false;
		}
	}

@Transactional
	public void updateOnlineStatus(User tempuser) 
	{
	
			sessionF.getCurrentSession().saveOrUpdate(tempuser);
			
		
	}


	public User getUserbyemail(String email)
	{
		User user=new User();
		
		Session session= sessionF.openSession();
		Query query=session.createQuery("from User where email='"+email+"'");
		 user=(User)query.list().get(0);
		session.close();
		return user;
	}


	public User getUserbyId(int userId) 
	{
User user=new User();
		
		Session session= sessionF.openSession();
		Query query=session.createQuery("from User where email='"+userId+"'");
		 user=(User)query.list().get(0);
		session.close();
		return user;
	}


	

	

	}

