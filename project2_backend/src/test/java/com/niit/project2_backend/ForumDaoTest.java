package com.niit.project2_backend;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.ForumDao;
import com.niit.Model.Forum;



public class ForumDaoTest
{
	@Autowired
	private static  ForumDao forumDao;
	
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		forumDao=(ForumDao)context.getBean("forumDao");
	}
	 @Ignore
	@Test
	public void addForum()
	{
		Forum forum=new Forum();
		forum.setForumName("abcd");
		forum.setForumContent("hgsdwhgdwjygd");
		
		
		
		assertTrue("Problem in inserting forum",forumDao.addForum(forum));		
	}
	 @Ignore
	@Test
	public void getForum()
	{
		Forum forum=forumDao.getForum(1);
		System.out.println(forum.getForumName());
		
		
	}
	
	 @Ignore
	@Test
	public void getAllForum()
	{
		
		List<Forum> forum=(List<Forum>)forumDao.getAllForum();
		for(Forum j:forum)
		{
			System.out.println(j.getForumContent());
			
		}
		
	}
	 @Ignore
@Test
public void updateForum()
{

	Forum forum=forumDao.getForum(1);
	forum.setForumContent("fhdfqwfd");
	assertTrue("problem in updating forum",forumDao.updateForum(forum));
	
}
	 @Ignore
	@Test
	public void deleteForum()
	{
		
		Forum forum=forumDao.getForum(56);
		assertTrue("problem in deleting forum",forumDao.deleteForum(forum));
	}

}
