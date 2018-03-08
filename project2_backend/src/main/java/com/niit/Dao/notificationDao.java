package com.niit.Dao;

import java.util.ArrayList;

import com.niit.Model.notification;

public interface notificationDao
{
	public boolean addNotifications(notification notification) ;
	public ArrayList<notification> getAllNotifications( String username) ;
	public boolean deleteNotifications(notification notification);
	public notification getNotifications(int notifid);
}
