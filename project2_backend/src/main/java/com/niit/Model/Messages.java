package com.niit.Model;

public class Messages 
{
	private String message;
	private int id;
	
	public Messages()
	{
		//dummy constructor
	}
	
	public Messages(int id, String message) 
	{
		this.id = id;
		this.message = message ;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	} 
	
}
