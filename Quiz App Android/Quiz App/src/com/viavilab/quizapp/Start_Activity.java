package com.viavilab.quizapp;

import com.example.database.DatabaseHandler;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.startapp.android.publish.StartAppAd;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

public class Start_Activity extends Activity {

	Button btnstart,btnoption,btnabout;
	DatabaseHandler db;
	private StartAppAd startAppAd;
	private AdView mAdView;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		StartAppAd.init(this, getString(R.string.startapp_dev_id),getString(R.string.startapp_app_id));
		setContentView(R.layout.start_activity);
		
		StartAppAd.showSlider(this);
		startAppAd = new StartAppAd(this);
		
		mAdView = (AdView) findViewById(R.id.adView);
	    mAdView.loadAd(new AdRequest.Builder().build());
	     
	    

		btnstart=(Button)findViewById(R.id.btn_start);
		btnoption=(Button)findViewById(R.id.btn_option);
		btnabout=(Button)findViewById(R.id.btn_about);
		db=new DatabaseHandler(this);

		btnstart.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG).show();

				Intent intentstart=new Intent(getApplicationContext(),Level_Activity.class);
				startActivity(intentstart);
			}
		});

		btnoption.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "option", Toast.LENGTH_SHORT).show();
				Intent intentrules=new Intent(getApplicationContext(),Rules_Activity.class);
				startActivity(intentrules);
			}
		});

		btnabout.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), "about", Toast.LENGTH_SHORT).show();
				Intent intentabout=new Intent(getApplicationContext(),AboutActivity.class);
				startActivity(intentabout);
			}
		});

	}
	@Override
	public void onResume(){
		super.onResume();
		startAppAd.onResume();
	} 
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.reset:
			db.Reset();
			Toast.makeText(getApplicationContext(), "Reset Data",Toast.LENGTH_SHORT).show();
			return true;

		case R.id.share:

			Intent sendIntent = new Intent();
			   sendIntent.setAction(Intent.ACTION_SEND);
			   sendIntent.putExtra(Intent.EXTRA_TEXT,"Check out this Android Application -I'm using "+"[Quiz App]"+ " on my Android phone.Check it out here:"+"https://play.google.com/store/apps/details?id=com.viavilab.quizapp");
			   sendIntent.setType("text/plain");
			   startActivity(sendIntent);
			   return true;

		default:
			return super.onOptionsItemSelected(item);
		}
	}
	@Override
	 public boolean onKeyDown(int keyCode, KeyEvent event) {
	   

	  if (keyCode == KeyEvent.KEYCODE_BACK) {
	   // Toast.makeText(appContext, "BAck", Toast.LENGTH_LONG).show();
	   AlertDialog.Builder alert = new AlertDialog.Builder(
	     Start_Activity.this);
	   alert.setTitle(com.viavilab.quizapp.R.string.app_name);
	   alert.setIcon(R.drawable.app_icon);
	   alert.setMessage("Are You Sure You Want To Quit?");

	   alert.setPositiveButton("Ok",
	     new DialogInterface.OnClickListener() {
	      public void onClick(DialogInterface dialog,
	        int whichButton) {
	       
	    	  startAppAd.onBackPressed();
 				finish();
	      }
	        

	       
	     });

	   alert.setNegativeButton("Rate App",
	     new DialogInterface.OnClickListener() {

	      public void onClick(DialogInterface dialog, int which) {
	       
	       final String appName = "com.viavilab.quizapp";
	       try {
	        startActivity(new Intent(Intent.ACTION_VIEW,
	          Uri.parse("market://details?id="
	            + appName)));
	       } catch (android.content.ActivityNotFoundException anfe) {
	        startActivity(new Intent(
	          Intent.ACTION_VIEW,
	          Uri.parse("http://play.google.com/store/apps/details?id="
	            + appName)));
	       }
	      }
	     });
	   alert.show();
	   return true;
	  }

	  return super.onKeyDown(keyCode, event);

	 }
	 

}
 