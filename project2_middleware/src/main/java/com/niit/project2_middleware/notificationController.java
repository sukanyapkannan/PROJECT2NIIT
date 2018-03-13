package com.niit.project2_middleware;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Dao.notificationDao;
import com.niit.Model.User;
import com.niit.Model.notification;

@RestController
@RequestMapping("/notification")
public class notificationController {
	@Autowired 
	notificationDao notificationsDAO;
	
	
	
	@RequestMapping(value="/getAllNotis",method=RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<ArrayList<notification>> getAllNotis(HttpSession session){
		User user=(User)session.getAttribute("currentuser");
		System.out.println("in getall notis");
		System.out.println(user.getEmail());
		ArrayList<notification> notis=(ArrayList<notification>)notificationsDAO.getAllNotifications(user.getEmail());
		for(notification n:notis)
		{
			System.err.println(n.getNoti());
		}
				return new ResponseEntity<ArrayList<notification>>(notis,HttpStatus.OK);
				
	
	
	
	}
	
	
	@RequestMapping(value="/deleteNoti/{notifid}",method=RequestMethod.GET)
	public ResponseEntity<ArrayList<notification>> deleteNoti(@PathVariable("notifid") int notifid,HttpSession session){
	
	User us=(User)session.getAttribute("currentuser");
		
	notification noti=notificationsDAO.getNotifications(notifid);
	if(notificationsDAO.deleteNotifications(noti))
	{
		ArrayList<notification> bc=notificationsDAO.getAllNotifications(us.getEmail());
	
		return new ResponseEntity<ArrayList<notification>>(bc,HttpStatus.OK);	

	}
	else
	{
		return null;
	}

	}
}