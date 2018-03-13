package com.niit.project2_middleware;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Dao.FriendDao;
import com.niit.Dao.UserDao;
import com.niit.Model.Friend;
import com.niit.Model.User;

@RestController
@RequestMapping("/friend")
public class FriendController
{
	@Autowired 
	FriendDao friendDAO;
	@Autowired 
	UserDao userDAO;
	
	
	@RequestMapping(value="/addFriend/{myid}/{friendid}",method=RequestMethod.GET)
	public ResponseEntity<String> addBlog(@PathVariable("myid") int myid,@PathVariable("friendid") int friendid){
	
Friend friend=new Friend();

friend.setUser_id(myid);
friend.setFriendid(friendid);
friend.setStatus("P");

		
		
		boolean isSaved=friendDAO.addFriend(friend);
		if(isSaved)
		{
			
		return new ResponseEntity<String>("Adding friend successfull",HttpStatus.OK);
		}
		else
		{	
			return new ResponseEntity<String>("Error in adding friend",HttpStatus.BAD_REQUEST);
		}

	}
	
	 @RequestMapping(value="/getMyFriends/{myid}",method=RequestMethod.GET)
	 public ArrayList<User> getMyFriends(@PathVariable("myid") int myid)
	 {
		 
	ArrayList<Friend> myFriends=friendDAO.getAllMyFriend(myid) ;
	ArrayList<User> user=new ArrayList<User>();
	
	
	for(Friend s:myFriends)
	{
		if(s.getUser_id()==myid)
		{
			user.add(userDAO.getUserbyId(s.getFriendid()));
					}
		else if(s.getFriendid()==myid)
		{
		 user.add(userDAO.getUserbyId(s.getUser_id()));
		}
	}
	
	return user;
		 
	 }
	
	

	 @RequestMapping(value="/getAllOtherUsers/{myid}",method=RequestMethod.GET)
		public ArrayList<User> getAllFriends(@PathVariable("myid") int myid)
	 {User us=new User();
		ArrayList<User> searchFriends=new ArrayList<User>();
		ArrayList<Friend> myFriends=friendDAO.getAllMyFriend(myid);
		ArrayList<String> myfriendsname=new ArrayList<String>(); 
		for(Friend s:myFriends)
		{
			if(s.getUser_id()==myid)
			{
				myfriendsname.add(userDAO.getUser(s.getFriendid()).getEmail());
			}
			else if(s.getFriendid()==myid)
			{
				myfriendsname.add(userDAO.getUser(s.getUser_id()).getEmail());
			}
		}
	
		
		ArrayList<User> allUser=userDAO.getAllUser();
			
		
		for(User u:allUser)
		{int count=0;
			if(u.getUserId()!=myid)
			{
			for(String s:myfriendsname)
			{
				if(u.getEmail()!=s)
				{
					count++;
				}
					
				
			}
			if(count==myfriendsname.size())
			{
				searchFriends.add(u);
			}
		}
			
		}
ArrayList<Friend> pend=friendDAO.getAllpendingentries(myid);
ArrayList<String> pendnames=new ArrayList<String>();


for(Friend s:pend)
{
	if(s.getUser_id()==myid)
	{
		pendnames.add(userDAO.getUser(s.getFriendid()).getEmail());
	}
	else if(s.getFriendid()==myid)
	{
		pendnames.add(userDAO.getUser(s.getUser_id()).getEmail());
	}
}


ArrayList<User> newFriends=new ArrayList<User>();
for(User uu:searchFriends)
{ int count=0;
	
	for(String ff:pendnames)
	{
		if(uu.getEmail()!=ff)
		{
			count++;
		}
		
	}
	if(count==pendnames.size())
	{
		newFriends.add(uu);
	}
}
		return newFriends; 	
		}
	 
	 
	 
	 @RequestMapping(value="/getOnlineFriends/{myid}",method=RequestMethod.GET)
	 public ArrayList<User> getOnlineFriends(@PathVariable("myid") int myid)
	 {
		 
	ArrayList<Friend> myFriends=friendDAO.getAllMyFriend(myid) ;
	ArrayList<User> user=new ArrayList<User>();
	for(Friend s:myFriends)
	{
		if(s.getUser_id()==myid)
		{
			user.add(userDAO.getUserbyId(s.getFriendid()));
		}
		else if(s.getFriendid()==myid)
		{
			user.add(userDAO.getUserbyId(s.getUser_id()));
		}
	}
for(User us:user)
{
	System.err.println(us.getEmail());
}
	ArrayList<User> onlineusers=new ArrayList<User>();
	for(User uu:user)
	{
		if(uu.isOnline()==true)
		{
			onlineusers.add(uu);
		}
	}
	return onlineusers;
		 
	 }
	 
	 @RequestMapping(value="/getAllMyFriendRequests/{myid}",method=RequestMethod.GET)
	 public ArrayList<User> getAllMyFriendRequests(@PathVariable("myid") int myid)
	 
	 {
		 ArrayList<User> frequests =new ArrayList<User>(); 
	 ArrayList<Friend> frireq=friendDAO.getAllFriendRequestsByUser(myid);
	 for(Friend f:frireq)
	 {
		 System.err.println(f.getUser_id());
	 }
	 
	 
	 for(Friend f:frireq)
	 {

			if(f.getUser_id()==myid)
			{
				frequests.add(userDAO.getUserbyId(f.getFriendid()));
			}
			else if(f.getFriendid()==myid)
			{
				frequests.add(userDAO.getUserbyId(f.getUser_id()));
			} 
	 }
	 return frequests; 
	 }
	 
	 @RequestMapping(value="/unfriend/{myid}/{friendid}",method=RequestMethod.GET)
	 public User unfriend(@PathVariable("friendid") int friendid,@PathVariable("myid") int myid)
	 {
	 	List<Friend> fr=friendDAO.getfriendrequest(myid, friendid);
	 	for(Friend f:fr)
	 	{
	 		friendDAO.delete(f);
	 	}

	 return null;
	 }


	 @RequestMapping(value="/acceptfriend/{myid}/{friendid}",method=RequestMethod.GET)
	 public User acceptfriend(@PathVariable("friendid") int friendid,@PathVariable("myid") int myid)
	 {
	 	List<Friend> fr=friendDAO.getfriendrequest(myid, friendid);
	 	for(Friend f:fr)
	 	{
	 		f.setStatus("YES");
	 		friendDAO.acceptfriendrequest(f);
	 	}
	 return null;
	 }

	 @RequestMapping(value="/rejectfriend/{myid}/{friendid}",method=RequestMethod.GET)
	 public User rejectfriend(@PathVariable("friendid") int friendid,@PathVariable("myid") int myid)
	 {
	 	List<Friend> fr=friendDAO.getfriendrequest(myid, friendid);
	 	for(Friend f:fr)
	 	{
	 		f.setStatus("NO");
	 		friendDAO.rejectfriendrequest(f);
	 	}
return null;
}
}
