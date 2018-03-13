package com.niit.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Table
@Entity
@Component
public class Friend implements Serializable
{
private static final long serialVersionUID=1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="FriendReqId")
	private int friendreqid; 
    private int user_id;
    private int friendid;
	@Column(name="Status")
	private  String status;
	public int getFriendreqid() {
		return friendreqid;
	}
	public void setFriendreqid(int friendreqid) {
		this.friendreqid = friendreqid;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public int getFriendid() {
		return friendid;
	}
	public void setFriendid(int friendid) {
		this.friendid = friendid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}




