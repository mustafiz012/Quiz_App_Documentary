package com.viavilab.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class End_Game extends Activity implements OnClickListener {
	
	 
	Button mainMenuButton;
	TextView gameOverText,pointText;
	 
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.endgame);
		
		 
		mainMenuButton = (Button) findViewById(R.id.mainMenuButton);
		mainMenuButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intentstage=new Intent(getApplicationContext(),Stage_Activity.class);
				intentstage.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intentstage);
			}
		});
	 
		//pointText=(TextView)findViewById(R.id.gameoverpoint);
		gameOverText = (TextView) findViewById(R.id.gameOverText);
		
	 
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.mainMenuButton:
			 
			finish();
		}	
	}
	
 	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
		Intent intentback=new Intent(getApplicationContext(),Stage_Activity.class);
		intentback.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intentback);
		
	}

}
