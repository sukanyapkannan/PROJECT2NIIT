package com.niit.Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
@Table
public class notification implements Serializable
{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int notId;
	private String noti;
	private String userName;
	public int getNotId() {
		return notId;
	}
	public void setNotId(int notId) {
		this.notId = notId;
	}
	public String getNoti() {
		return noti;
	}
	public void setNoti(String noti) {
		this.noti = noti;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
