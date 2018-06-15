package com.wj.jsonlib;

import java.sql.Timestamp;
import java.util.Date;

public class People {
	private String id;
	private Date mdate;
	private Timestamp vdate;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public Timestamp getVdate() {
		return vdate;
	}
	public void setVdate(Timestamp vdate) {
		this.vdate = vdate;
	}
	
	
}