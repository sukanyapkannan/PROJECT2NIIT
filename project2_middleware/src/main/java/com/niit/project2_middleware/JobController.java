package com.niit.project2_middleware;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.niit.Dao.JobDao;
import com.niit.Model.Jobs;


@RestController
@RequestMapping("/job")
public class JobController {
	@Autowired
	JobDao jdao;
	@RequestMapping(value="/addJob",method=RequestMethod.POST)
	public ResponseEntity<String> addJob(@RequestBody Jobs job)
	{
		job.setStatus("A");
		 SimpleDateFormat sm = new SimpleDateFormat("mm-dd-yyyy");
		   
		    String postDate = sm.format(new Date());
		job.setPostDate(postDate);
		
		boolean isSaved=jdao.addjob(job);
		if(isSaved)
		return new ResponseEntity<String>("Job addes ok",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Job add error",HttpStatus.BAD_REQUEST);
		
	}
	
	@RequestMapping(value="/deleteJob/{jobid}",method=RequestMethod.GET)
	public String delete(@PathVariable("jobid") int id)
	{
		Jobs j=jdao.getjob(id);
		jdao.deletejob(j);
		
		return "JOB deleteed Successfully"+j.toString();
		
	}
	@RequestMapping(value="/updateJob/{jobid}",method=RequestMethod.GET)
	public String update(@PathVariable("jobid") int id)
	{
		Jobs j=jdao.getjob(id);
		jdao.updatejob(j);
		
		return "JOB updated Successfully"+j.toString();
		
	}
	
	@RequestMapping(value="/getJob/{jobid}",method=RequestMethod.GET,headers = "Accept=application/json")
	public ResponseEntity<Jobs> getJob(@PathVariable("jobid") int jobId){

	System.out.println("In get job controller"+jobId);
	if(jdao.getjob(jobId)==null){
		return new ResponseEntity<Jobs>(jdao.getjob(jobId),HttpStatus.BAD_REQUEST);	
		
	}
	else
	{
		return new ResponseEntity<Jobs>(jdao.getjob(jobId),HttpStatus.OK);	
	}


	}

	@RequestMapping(value="/getAllJobs",method=RequestMethod.GET,headers = "Accept=application/json")
	public ArrayList<Jobs> getAllJobs(){
		ArrayList<Jobs> jobs=(ArrayList<Jobs>)jdao.getAlljobs();
		if(jobs.isEmpty()){
			return null;
		}
		else
		{
			return jobs;	
		}
		
				
	}
}
