package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.FriendDao;
import com.niit.Model.Friend;
import com.niit.Model.User;
@Repository
@Transactional
public class FriendDaoImpl implements FriendDao
{
	@Autowired
	private SessionFactory sessionFactory;
	@Transactional
	public boolean addFriend(Friend friend) {
		try
		{
		sessionFactory.getCurrentSession().save(friend);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}

//accept friend requests
@Transactional
	public boolean accept(int friendreqid) {
		try
		{Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class,friendreqid);
		friend.setStatus("YES");
		session.saveOrUpdate(friend);
		session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}


//rejecting friendrequests
@Transactional
	public boolean reject(int friendreqid) {
		try
		{Session session=sessionFactory.openSession();
		Friend friend=(Friend) session.get(Friend.class,friendreqid);
		friend.setStatus("NO");
		session.saveOrUpdate(friend);
		session.close();
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}	}


//fetching all my friend requests
@Transactional
	public ArrayList<Friend> getAllFriendRequestsByUser( int user_id) {
		

		Session session = sessionFactory.openSession();
		ArrayList<Friend> myfriends=(ArrayList<Friend>)session.createQuery("from Friend where friendid="+user_id+" and status='P'").list();
		session.close();
		return myfriends;
	}

//retyrieving everything from friend table 
@Transactional
	public ArrayList<Friend> getAllFriend() {
		Session session = sessionFactory.openSession();
		ArrayList<Friend> Allfriends=(ArrayList<Friend>)session.createQuery("from Friend").list();
		session.close();
		return Allfriends;
		
	}

//fetching all my friends 
@Transactional
public ArrayList<Friend> getAllMyFriend(int myid) {
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where status='YES' and (user_id="+myid+" or friendid="+myid+")" );
ArrayList<Friend> myfriends=(ArrayList<Friend>)q.list();
return myfriends;
	}

//fetching all pending entries like we not acceped or he not accepted
@Transactional
public ArrayList<Friend> getAllpendingentries(int myid) {
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where  status='P' and( user_id="+myid+" or friendid="+myid+") ");
ArrayList<Friend> myfriends=(ArrayList<Friend>)q.list();
return myfriends;
	}


//
@Transactional
public ArrayList<Friend> getAllPendingrequests( int user_id) {
	

	Session session = sessionFactory.openSession();
	ArrayList<Friend> myfriends=(ArrayList<Friend>)session.createQuery("from Friend where user_id="+user_id+" and status='P'").list();
	session.close();
	return myfriends;
}



@Transactional
public User getUserById(int user_id) {
	User user=new User();
	try{
		Session session= sessionFactory.openSession();
		Query query=session.createQuery("from User where user_id="+user_id);
		 user=(User)query.list().get(0);
		session.close();
		
	}
	catch(Exception e)
	{
		
		
	}
	return user;
}

@Transactional
public boolean delete(Friend friend) {
	try
	{
		
	sessionFactory.getCurrentSession().delete(friend);
	return true;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return false;
	}
}

@Transactional
public List<Friend> getfriendrequest(int friendreqid,int myid) {
	
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where (user_id="+myid+" and friendid="+friendreqid+") or (user_id="+friendreqid+" and friendid="+myid+")" );
	List<Friend> mynfriend=(List<Friend>)q.list();
return mynfriend;
	
}


@Transactional
public Friend acceptfriendrequest(Friend friend)
{
	try
	{
	sessionFactory.getCurrentSession().update(friend);
	return null;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return null;
	}
}


@Transactional
public ArrayList<Friend> getAllMyFriendpend(int myid) {
	Session session = sessionFactory.openSession();
	Query q= session.createQuery("from Friend where (user_id="+myid+" or friendid="+myid+")");
ArrayList<Friend> myfriends=(ArrayList<Friend>)q.list();
return myfriends;

}

@Transactional
public Friend rejectfriendrequest(Friend friend) {
	try
	{
	sessionFactory.getCurrentSession().update(friend);
	return null;
	}
	catch(Exception e)
	{
	System.out.println(e);
	return null;
	}
}

}
