package com.niit.project2_backend;

import static org.junit.Assert.*;


import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.UserDao;
import com.niit.Model.User;


public class UserDAOTest 
{

	@Autowired
	public static UserDao userDAO;
		
		
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			
			userDAO=(UserDao)context.getBean("UserDao");
		}
		
	    @Ignore
		@Test
		public void getAllUsersTest()
		{
			List<User> user= userDAO.getAllUser();
			for(User u:user)
			{
				System.out.println(u.getUsername());
				
				System.out.println(u.getPassword());
			
			
		}
		}
            @Ignore
			@Test
			public void addUserTest()
			{
        	   User user =new User();
				user.setAddress("hgfhgd");
				user.setEmail("123@g.vc");
				user.setOnline(false);
				user.setPassword("jfh");
				user.setPhone(4635424);
				user.setRole("ROLE_USER");
				user.setStatus("P");
				user.setUsername("Sukanya");
				
				
			
				assertTrue("Problem in Inserting USer",userDAO.saveUser(user));
				
				
				
				
			}
		/*	
			@Ignore
			@Test
			public void getUserTest()
			{
				
				User user=(User)userDAO.getUser(1);
				System.out.println(user.getEmail_id());
				
			}
			
			@Ignore
			@Test
			public void updateOnlineStatusTest()

			{
				User user=userDAO.getUser(2);
				
				assertTrue("Problem in updating Online Status",userDAO.updateOnlineStatus(user));
				
				
			}
			@Ignore
			@Test
			public void checklogin()
			{
				User user=(User)userDAO.getUser(33);
				System.out.println(user.getEmail_id());
				
				assertTrue("Problem in login Status",userDAO.checkLogin(user));
				
			}
			@Ignore
			@Test
			public void getuserbyemail()
			{
				User user=(User)userDAO.getUserbyId(1);
				System.out.println(user.getEmail_id());
				
				
				
			}
*/

}

/*import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.UserDao;
import com.niit.Model.User;

import junit.framework.TestCase;


public class UserDAOTest extends TestCase
{

	@Autowired
	public static UserDao userDAO;
		
		
		@BeforeClass
		public static void initialize()
		{
			AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
			context.scan("com.niit");
			context.refresh();
			
			userDAO=(UserDao)context.getBean("UserDao");
		}
		
	@Ignore
		@Test
		public void getAllUsersTest()
		{
			ArrayList<User> user= userDAO.getAllUser();
			for(User u:user)
			{
				System.out.println(u.getFirst_name());
				System.out.println(u.getLast_name());
				System.out.println(u.getPassword());
			
			
		}
		}
          // @Ignore
			@Test
			public void addUserTest()
			{
				User user =new User();
				user.setAddress("hgfhgd");
				user.setEmail("123@g.vc");
				user.setOnline(false);
				user.setPassword("jfh");
				user.setPhone(4635424);
				user.setRole("ROLE_USER");
				user.setStatus("P");
				user.setUsername("Sukanya");
				
				user.setFirst_name("amal ");
				user.setLast_name("saleem");
				user.setUsername("Amaal");
				user.setEmail_id("amal@gmail.com");
				user.setIsonline("N");
				user.setGender("F");
				user.setPassword("amal1811");
				user.setRole("ROLE_USER");
				user.setUser_ID(1236);
				
				
			
				assertTrue("Problem in Inserting USer",userDAO.saveUser(user));
				
				
				
				
			}
			
			@Ignore
			@Test
			public void getUserTest()
			{
				
				User user=(User)userDAO.getUser(1);
				System.out.println(user.getEmail_id());
				
			}
			
			@Ignore
			@Test
			public void updateOnlineStatusTest()

			{
				User user=userDAO.getUser(2);
				
				assertTrue("Problem in updating Online Status",userDAO.updateOnlineStatus(user));
				
				
			}
			@Ignore
			@Test
			public void checklogin()
			{
				User user=(User)userDAO.getUser(33);
				System.out.println(user.getEmail_id());
				
				assertTrue("Problem in login Status",userDAO.checkLogin(user));
				
			}
			@Ignore
			@Test
			public void getuserbyemail()
			{
				User user=(User)userDAO.getUserbyId(1);
				System.out.println(user.getEmail_id());
				
				
				
			}


}*/