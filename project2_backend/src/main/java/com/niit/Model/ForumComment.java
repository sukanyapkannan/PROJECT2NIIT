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
public class ForumComment implements Serializable
{
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int FCId;
	private String fcmnt;
	private Date fcmntDate;
	public int getFCId() {
		return FCId;
	}
	public void setFCId(int fCId) {
		FCId = fCId;
	}
	public String getFcmnt() {
		return fcmnt;
	}
	public void setFcmnt(String fcmnt) {
		this.fcmnt = fcmnt;
	}
	public Date getFcmntDate() {
		return fcmntDate;
	}
	public void setFcmntDate(Date fcmntDate) {
		this.fcmntDate = fcmntDate;
	}
	
}
