package com.niit.project2_middleware;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Dao.UserDao;
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
	
	 @RequestMapping(value="/getUserById/{userId}",method=RequestMethod.GET)
		public ResponseEntity<User>  getUserById(@PathVariable("userId") int id )
		{
			User user=udao.getUser(id);
			
			
			
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
	 
	 
	 @RequestMapping(value="/login",method=RequestMethod.POST)
		public ResponseEntity<User> login(@RequestBody User user,HttpSession http)
	 
	 {
		 System.out.println(user.getEmail());
			if(udao.checkLogin(user))
			{
				 User tempuser=udao.getUserbyemail(user.getEmail());
			
			tempuser.setOnline(true);
				udao.updateOnlineStatus(tempuser);
	tempuser.setErrorcode(200);
	tempuser.setErrormessage("login success");
			http.setAttribute("currentuser",tempuser);	
			return new ResponseEntity<User>(tempuser,HttpStatus.OK);
				
				
			}
			else
			{
				User tempuser1=new User();
				tempuser1.setErrorcode(200);
				tempuser1.setErrormessage("Invalid User or Password");
							
						return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
				
			/*User tempuser1=new User();
			
			if(udao.checkLogin(user))
			{
				User tempuser=udao.getUser(user.getUserId());
				
				if(tempuser.getStatus().equals("P"))
				{
			tempuser1.setErrorcode(200);
			tempuser1.setErrormessage("You are not yet approved by admin");
			return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
			}
				else
				{
					tempuser1.setErrorcode(200);
					tempuser1.setErrormessage("You rejected please contact admin");
					return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
				}
				
				
				
			}
			
			else
			{
				if(udao.checkLogin(user))
				
				{
						tempuser1.setErrorcode(200);
						tempuser1.setErrormessage("email id or password incorrect");
						return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
					}
					else
					{
						tempuser1.setErrorcode(200);
						tempuser1.setErrormessage("You are not registered yet");
						return new ResponseEntity<User>(tempuser1,HttpStatus.OK);
					}
	
			 }*/
		     }
			
	}
	 
	 @RequestMapping(value="/logout/{email}",method=RequestMethod.GET)
		public ResponseEntity<String> logout(@PathVariable("email") String email){
		 System.out.println(email);
		 
	 String emaill=email+".com";
System.out.println(emaill);
	 
User tempuser=udao.getUserbyemail(emaill);
		 tempuser.setOnline(false);
		udao.updateOnlineStatus(tempuser);
		return new ResponseEntity<String>("Logout success",HttpStatus.OK);		 
}
			

}
