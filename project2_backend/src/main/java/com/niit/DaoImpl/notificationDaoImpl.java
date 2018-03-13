package com.niit.DaoImpl;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.Dao.notificationDao;
import com.niit.Model.notification;
@Repository("NotificationsDao")
public class notificationDaoImpl implements notificationDao
{
	
	
	@Autowired
	private SessionFactory sessionF;
	public notificationDaoImpl(SessionFactory sessionF)
	{
		super();
		this.sessionF=sessionF;
	}
	@Transactional
	public boolean addNotifications(notification notification) {
		try
		{
		sessionF.getCurrentSession().save(notification);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}
	@Transactional
	public ArrayList<notification> getAllNotifications(String userName) {
		Session session = sessionF.openSession();
		ArrayList<notification> notis=(ArrayList<notification>)session.createQuery("from notification where username='"+userName+"'").list();
		session.close();
		return notis;
	}
	
	@Transactional
	public boolean deleteNotifications(notification notification) {
		try
		{
		sessionF.getCurrentSession().delete(notification);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	
	@Transactional
	public notification getNotifications(int notifid) {
		Session session=sessionF.openSession();
		notification noti = (notification) session.get(notification.class,notifid);
		session.close();
		return noti;
	}
	
}
