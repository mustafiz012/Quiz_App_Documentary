package com.example.item;

public class Item_Level_Activity {

	private String LevelId; 
	private String LevelName; 
	private String LevelRequirePoint; 
	private String LevelImageUrl; 

	public String getLevelId() {
		return LevelId;
	}

	public void setLevelId(String levelid) {
		this.LevelId = levelid;
	}

	public String getLevelName() {
		return LevelName;
	}

	public void setLevelName(String levelname) {
		this.LevelName = levelname;
	}
	public String getLevelRequirePoint()
	{
		return LevelRequirePoint;
 	}
 	public void setLevelRequirePoint(String levelrequirepoint)
	{
		this.LevelRequirePoint=levelrequirepoint;
	}
 	public String getLevelImageUrl()
	{
		return LevelImageUrl;
 	}
 	public void setLevelImageUrl(String levelimageurl)
	{
		this.LevelImageUrl=levelimageurl;
	}


}
