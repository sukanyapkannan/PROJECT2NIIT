package com.niit.Model;

import java.sql.Date;

public class OutputMessage extends Messages
{
	private Date time;

	public OutputMessage(Messages original,Date time)
	{
		super(original.getId(),original.getMessage());
		this.setTime(time);
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}
}
