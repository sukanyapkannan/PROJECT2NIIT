package com.niit.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

/**
 * @author user
 *
 */
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
	private String cmntDate;
	private String username;
	private int userId;
	private int blogId;
	
	
	public int getBlogId() {
		return blogId;
	}
	public void setBlogId(int blogId) {
		this.blogId = blogId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
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
	public String getCmntDate() {
		return cmntDate;
	}
	public void setCmntDate(String cmntDate) {
		this.cmntDate = cmntDate;
	}
	
	
}
