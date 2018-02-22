package com.niit.project2_backend;

import java.util.List;
import static org.junit.Assert.*;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.Dao.JobDao;
import com.niit.Model.Jobs;

public class JobDaotest
{
	@Autowired
	private static  JobDao jobDao;
	
	
	
	@BeforeClass
	public static void initialize()
	{
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		
		jobDao=(JobDao)context.getBean("jobDao");
	}
   @Ignore
	@Test
	public void addjob()
	{
		Jobs job=new Jobs();
		job.setJobDescp("Devops");
		job.setJobPrfl("Web App developer");
		job.setQualification("btech");
		
		
		assertTrue("Problem in inserting job",jobDao.addjob(job));		
	}
   @Ignore
	@Test
	public void getJob()
	{
		Jobs job=jobDao.getjob(1);
		System.out.println(job.getJobDescp());
		
		
	}
	
   @Ignore
	@Test
	public void getAllJobs()
	{
		
		List<Jobs> job=(List<Jobs>)jobDao.getAlljobs();
		for(Jobs j:job)
		{
			System.out.println(j.getJobDescp());
			
		}
		
	}
   @Ignore
@Test
public void updateJob()
{

	Jobs job=jobDao.getjob(1);
	job.setJobDescp("software developer");
	assertTrue("problem in updating Job",jobDao.updatejob(job));
	
}
   @Ignore
	@Test
	public void deletejob()
	{
		
		Jobs job=jobDao.getjob(67);
		assertTrue("problem in deleting Job",jobDao.deletejob(job));
	}

}

