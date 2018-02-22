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
public class BlogComment implements Serializable
{
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int BCId;
	private String cmnt;
	private Date cmntDate;
	public int getBCId() {
		return BCId;
	}
	public void setBCId(int bCId) {
		BCId = bCId;
	}
	public String getCmnt() {
		return cmnt;
	}
	public void setCmnt(String cmnt) {
		this.cmnt = cmnt;
	}
	public Date getCmntDate() {
		return cmntDate;
	}
	public void setCmntDate(Date cmntDate) {
		this.cmntDate = cmntDate;
	}

	
}
