package com.viavilab.quizapp;

import com.startapp.android.publish.StartAppAd;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;

public class Rules_Activity extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.rules);
		StartAppAd.showSlider(this);
	}

}
