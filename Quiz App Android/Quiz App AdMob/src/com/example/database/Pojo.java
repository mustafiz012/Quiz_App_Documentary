package com.example.database;

public class Pojo {
	
	private int id;
	private String PTime;
	private String PId;
	private String LevelId;
 
	 
	public Pojo()
	{
		
	}
	
	public Pojo(String PId)
	{
		this.PId=PId;
	}
	
	public Pojo(String pid,String pquote,String Levelid)
	{
		this.PId=pid;
		this.PTime=pquote;
		this.LevelId=Levelid;
	 
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getPTime() {
		return PTime;
	}

	public void setPTime(String pquote) {
		this.PTime = pquote;
	}
	
	public String getPId() {
		return PId;
	}

	public void setPId(String pid) {
		this.PId = pid;
	}
	
	public String getLevelId() {
		return LevelId;
	}

	public void setLevelId(String pid) {
		this.LevelId = pid;
	}
}
