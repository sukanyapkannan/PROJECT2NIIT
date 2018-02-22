package com.niit.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Jobs implements Serializable
{
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int jobId;
	private String jobPrfl;
	private String jobDescp;
	private String qualification;
	private String status;
	private String postDate;
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getJobPrfl() {
		return jobPrfl;
	}
	public void setJobPrfl(String jobPrfl) {
		this.jobPrfl = jobPrfl;
	}
	public String getJobDescp() {
		return jobDescp;
	}
	public void setJobDescp(String jobDescp) {
		this.jobDescp = jobDescp;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPostDate() {
		return postDate;
	}
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}
	@Override
	public String toString() {
		return "Jobs [jobId=" + jobId + ", jobPrfl=" + jobPrfl + ", jobDescp=" + jobDescp + ", qualification="
				+ qualification + ", status=" + status + ", postDate=" + postDate + "]";
	}
	
}
