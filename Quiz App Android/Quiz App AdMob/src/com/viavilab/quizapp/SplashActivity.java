package com.viavilab.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
 
public class SplashActivity extends Activity {


	protected boolean active=true;
	protected int splashTime=2000;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		 
		super.onCreate(savedInstanceState);
		setContentView(R.layout.splash_activity);
		

		 Thread splashThread=new Thread()
	        {
	        	public void run()
	        	{
	        		try
	        		{
	        			int waited=0;
	        			
	        			while(active && (waited<splashTime))
	        			{
	        					sleep(100);
	        					if(active)
	        					{
	        						waited +=100;
	        					}
	        			}
	        		}
	        		catch(Exception e)
	        		{
	        			e.toString();
	        		}
	        		
	        		
	        	finally	
	        	{
	        		
	        		Intent int1=new Intent(getApplicationContext(),Start_Activity.class);
	        		startActivity(int1);
	        		finish();
	        		
	        		
	        	}
	        	}
	        };
	    
	      splashThread.start();
		
		
	}

	 
}
