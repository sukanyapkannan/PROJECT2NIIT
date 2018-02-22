package com.niit.Dao;

import java.util.ArrayList;
import java.util.List;

import com.niit.Model.Jobs;

public interface JobDao 
{
	public boolean addjob(Jobs job);
	public boolean updatejob(Jobs job);
	public boolean deletejob(Jobs job);
	public Jobs getjob(int jobId);
	public List<Jobs> getAlljobs();
}
