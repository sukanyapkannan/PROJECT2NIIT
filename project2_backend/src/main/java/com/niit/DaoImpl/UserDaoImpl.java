package com.niit.DaoImpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.UserDao;
import com.niit.Model.User;

@Repository
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


	

	public void saveUser(User u) 
	{
		System.out.println("in saveUser"+u.getEmail());
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		s.close();
		
	}


	public User getUser(String mailid) {
		// TODO Auto-generated method stub
		return null;
	}
}
