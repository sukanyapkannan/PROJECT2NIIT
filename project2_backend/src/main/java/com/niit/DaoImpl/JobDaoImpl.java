package com.niit.DaoImpl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.Dao.JobDao;
import com.niit.Model.JobApplications;
import com.niit.Model.Jobs;
@Repository("jobDao")
public class JobDaoImpl implements JobDao
{

	@Autowired
	private SessionFactory sessionF;
	/*public JobDaoImpl(SessionFactory sessionF)
	{
		super();
		this.sessionF=sessionF;
	}
	public JobDaoImpl()
	{
		super();
		
	}
	
	*/
	public boolean addjob(Jobs job)
	{
		try
		{Session s=sessionF.openSession();
		s.beginTransaction();
		s.save(job);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
	
		
	}

	public boolean updatejob(Jobs job) 
	{
		try{
		Session s=sessionF.openSession();
		 s.beginTransaction();
		s.update(job);
		s.flush();
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
			return false;
		}
		
	}

	public boolean deletejob(Jobs job)
	{
		try
		{
		Session s=sessionF.openSession();
		s.beginTransaction();
		s.delete(job);
		s.getTransaction().commit();
		s.close();
		return true;
		}
		catch(Exception e)
		{
		return false;
		}
	}

	public Jobs getjob(int jobId)
	{
		Session s=sessionF.openSession();
		Jobs job=(Jobs)s.get(Jobs.class, jobId);
		return job;
		
	}

	public List<Jobs> getAlljobs()
	{
		Session s=sessionF.openSession();
		List<Jobs> jlist=s.createQuery("from Jobs").list();	
		return jlist;
		
	}
	@Transactional
	public boolean applyJob(JobApplications jobapplications)
	{
		try
		{
		sessionF.getCurrentSession().save(jobapplications);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
	}
	
	@Transactional
	public ArrayList<JobApplications> myjobs(int myid)
	{
		System.err.println(myid);
		Session session = sessionF.openSession();
		ArrayList<JobApplications> jobapllicationlist=(ArrayList<JobApplications>)session.createQuery("from JobApplications where userid="+myid).list();
		session.close();
		return jobapllicationlist;
	}
	
	@Transactional
	public ArrayList<JobApplications> checkIfApplied(int jobid, int myid) 
	{
		Session session = sessionF.openSession();
		ArrayList<JobApplications> checkifapplied=(ArrayList<JobApplications>)session.createQuery("from JobApplications where userid="+myid+" and jobid="+jobid).list();
		session.close();
		return checkifapplied;
	}
	
	@Transactional
	public ArrayList<JobApplications> jobapps(int jobid) 
	{
		Session session = sessionF.openSession();
		ArrayList<JobApplications> jobapps=(ArrayList<JobApplications>)session.createQuery("from JobApplications where  jobid="+jobid).list();
		session.close();
		return jobapps;
		
		
		}
	
	public boolean deletejobApp(JobApplications jobapplication)
	{
		try
		{
		sessionF.getCurrentSession().delete(jobapplication);
		return true;
		}
		catch(Exception e)
		{
		System.out.println(e);
		return false;
		}
		
	}

}
