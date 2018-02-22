package com.niit.project2_middleware;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Dao.UserDao;
import com.niit.Model.Blog;
import com.niit.Model.User;

@RestController
@RequestMapping("/user")
public class UserController
{
	@Autowired
	UserDao udao;
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public ResponseEntity<User> register(@RequestBody User user)
	{
		user.setStatus("P");
		udao.saveUser(user);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public ResponseEntity<User> update(@RequestBody User user)
	{
		udao.updateUser(user);
		
		return new ResponseEntity<User>(user,HttpStatus.OK);
		
	}
	 @RequestMapping(value="/getAllUser",method=RequestMethod.GET)
		public List<User> getAllUser(){
		 System.out.println("in rest controller getallusers");
			List<User> user=(List<User>)udao.getAllUser();
			System.out.println("in rest controller getallusers");

		return user;		
		}
	 
	/* @RequestMapping(value="/approveusers/{username}",method=RequestMethod.POST)
	 public void approveusers(@PathVariable("username") String username)
	 {
		 User users =udao.getUser(username);
		 users.setStatus("A");
		 udao.approveusers(users); 
	 }
	 @RequestMapping(value="/rejectusers/{username}",method=RequestMethod.POST)
	 public void rejectusers(@PathVariable("username") String username)
	 {
		 User users =udao.getUser(username);
		 users.setStatus("R");
		 udao.rejectusers(users);
		 
	 }*/
	
	 @RequestMapping(value="/getUserById/{userId}",method=RequestMethod.POST)
		public ResponseEntity<User>  getUserByName(@PathVariable("userId") int id )
		{
			User user=udao.getUser(id);
			
			
			
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}

}
