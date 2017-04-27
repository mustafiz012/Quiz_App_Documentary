package com.viavilab.quizapp;

import java.util.List;

import com.example.database.DatabaseHandler;
import com.example.database.Pojo;
import com.example.util.Constant;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class PlayQuiz_Activity extends Activity{

 	TextView txtquestion,txttimer,txtpoint;
	Button btnopta,btnoptb,btnoptc,btnoptd;
	private int currentPosition = 0;
	String[] allArrayQid,allArrayQuestion,allArrayOptionA,allArrayOptionB,allArrayOptionC,allArrayOptionD,allArrayOptionAns;
	String opta,optb,optc,optd;
	private static int TOTAL_TEXT;
	CountDownTimer myTimer;
	int points,time;
	long millisTimerRemains;
	boolean isTimerOn;
	DatabaseHandler db;
	List<Pojo> checksolved;
	MediaPlayer mp;
	int typeOfGame;
	int id;
	private AdView mAdView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
 		setContentView(R.layout.playquiz_activity);
		 
		mAdView = (AdView) findViewById(R.id.adView);
	    mAdView.loadAd(new AdRequest.Builder().build());

		txtquestion=(TextView)findViewById(R.id.text_question);
		btnopta=(Button)findViewById(R.id.btn_optionA);
		btnoptb=(Button)findViewById(R.id.btn_optionB);
		btnoptc=(Button)findViewById(R.id.btn_optionC);
		btnoptd=(Button)findViewById(R.id.btn_optionD);
		txttimer=(TextView)findViewById(R.id.text_timer);
		txtpoint=(TextView)findViewById(R.id.text_point);
		db=new DatabaseHandler(this);
		checksolved=db.getLevel(Constant.ADD_LEVEL_IDD);
		id=db.getlaststageid();
		Log.e("iddd", ""+id);
		Intent i=getIntent();
		currentPosition=i.getIntExtra("POSITION",0);
		allArrayQid=i.getStringArrayExtra("Ques_QId");
		allArrayQuestion=i.getStringArrayExtra("Ques_Question");
		allArrayOptionA=i.getStringArrayExtra("Ques_OptionA");
		allArrayOptionB=i.getStringArrayExtra("Ques_OptionB");
		allArrayOptionC=i.getStringArrayExtra("Ques_OptionC");
		allArrayOptionD=i.getStringArrayExtra("Ques_OptionD");
		allArrayOptionAns=i.getStringArrayExtra("Ques_OptionAns");

		TOTAL_TEXT = (allArrayQid.length - 1);
		isTimerOn = false;
		txtquestion.setText(allArrayQuestion[currentPosition]);
		
		boolean found = false;
		int j1=0;
		for(int i1=0;i1<checksolved.size();i1++)
		{
			if(checksolved.get(i1).getPId().toString().contains(allArrayQid[currentPosition]))
			{
				txtquestion.setGravity(Gravity.CENTER);
				found=true;
				j1=i1;
				break;
			}
		}
		if(found)
		{
			if(checksolved.get(id).getPTime().equals("0"))//this is for last stage which is not clear show option about that
			{
			 	db.RemoveFav(new Pojo(checksolved.get(currentPosition).getPId().toString()));
				btnopta.setText(allArrayOptionA[currentPosition]);
				btnoptb.setText(allArrayOptionB[currentPosition]);
				btnoptc.setText(allArrayOptionC[currentPosition]);
				btnoptd.setText(allArrayOptionD[currentPosition]);
				millisTimerRemains = 0;
				setTimer(30000);
				typeOfGame=2;
			}
			else
			{
				btnopta.setVisibility(View.GONE);
				btnoptb.setVisibility(View.GONE);
				btnoptc.setVisibility(View.GONE);
				btnoptd.setVisibility(View.GONE);
	 			txtpoint.setText(checksolved.get(currentPosition).getPTime().toString());
	 			typeOfGame=1;
	 			//Log.e("bhai id", checksolved.get(currentPosition).getPId().toString());
			}
		}
		else
		{

			btnopta.setText(allArrayOptionA[currentPosition]);
			btnoptb.setText(allArrayOptionB[currentPosition]);
			btnoptc.setText(allArrayOptionC[currentPosition]);
			btnoptd.setText(allArrayOptionD[currentPosition]);
			millisTimerRemains = 0;
			setTimer(30000);
			typeOfGame=2;

		}
 

		btnopta.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				opta=btnopta.getText().toString();
				CheckAns(opta,currentPosition);
				 

			}
		});

		btnoptb.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				optb=btnoptb.getText().toString();
				CheckAns(optb,currentPosition);
				//Log.e("ans", optb);

			}
		});

		btnoptc.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				optc=btnoptc.getText().toString();
				CheckAns(optc,currentPosition);
				//Log.e("ans", optc);

			}
		});

		btnoptd.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				optd=btnoptd.getText().toString();
				CheckAns(optd,currentPosition);
				//Log.e("ans", optd);
			}
		});


	}

	public void CheckAns(String Ans,int id)
	{
		if(Ans.equals(allArrayOptionAns[id]))
		{
			//Log.e("Hiii", "You Clear");

			if (currentPosition < TOTAL_TEXT) {
				time=(int)millisTimerRemains/1000;
				PointCount(time);
				SetSecondQues(currentPosition+1);
				mp=MediaPlayer.create(this,R.raw.you_are_good);
				mp.start();
				if(isTimerOn)
				{
					myTimer.cancel();
					setTimer(30000);
				}


			}
			else
			{
				Intent intback=new Intent(PlayQuiz_Activity.this,Level_Activity.class);
				intback.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				startActivity(intback);
				time=(int)millisTimerRemains/1000;
				PointCount(time);
			}

		}
		else
		{
			//Log.e("Hiii", "Opps!!");
			Intent intentgameover=new Intent(getApplicationContext(),End_Game.class);
			mp=MediaPlayer.create(this,R.raw.tryagain);
			mp.start();
			intentgameover.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intentgameover);
			//Log.e("iddd eee", allArrayQid[currentPosition]);
			db.AddtoFavorite(new Pojo(allArrayQid[currentPosition],"0",Constant.ADD_LEVEL_IDD));

		}
	}
	private void SetSecondQues(int positionToMoveTo) {
		// TODO Auto-generated method stub

		txtquestion.setText(allArrayQuestion[positionToMoveTo]);
		btnopta.setText(allArrayOptionA[positionToMoveTo]);
		btnoptb.setText(allArrayOptionB[positionToMoveTo]);
		btnoptc.setText(allArrayOptionC[positionToMoveTo]);
		btnoptd.setText(allArrayOptionD[positionToMoveTo]);
		currentPosition=positionToMoveTo;
	}

	//for point count based on time remain

	public void PointCount(int timeremain)
	{

		Log.e("Time",""+timeremain);

		if(timeremain<29 && timeremain>=25)
		{
			points=5;
			txtpoint.setText("" + points);
			db.AddtoFavorite(new Pojo(allArrayQid[currentPosition], String.valueOf(points),Constant.ADD_LEVEL_IDD));
		}
		else if(timeremain<25 && timeremain>=20)
		{
			points=3;
			txtpoint.setText("" + points);
			db.AddtoFavorite(new Pojo(allArrayQid[currentPosition], String.valueOf(points),Constant.ADD_LEVEL_IDD));
		}

		else if(timeremain<20 && timeremain>=1)
		{
			points=1;
			txtpoint.setText("" + points);
			db.AddtoFavorite(new Pojo(allArrayQid[currentPosition], String.valueOf(points),Constant.ADD_LEVEL_IDD));
		}
	}

	//timer set
	public void setTimer(long millisInFuture) {
		millisTimerRemains = millisInFuture;
		int countDownInterval = 1000;
		myTimer = new CountDownTimer(millisInFuture, countDownInterval) {

			public void onTick(long millisUntilFinished) {
				txttimer.setText("" + millisUntilFinished / 1000);
				millisTimerRemains = millisUntilFinished;

				// TODO soundpool tic-tac

			}

			public void onFinish() {

				millisTimerRemains = 0;
				AlertDialog.Builder alert=new AlertDialog.Builder(PlayQuiz_Activity.this);
				db.AddtoFavorite(new Pojo(allArrayQid[currentPosition],"0",Constant.ADD_LEVEL_IDD));
				alert.setTitle("Times UP!");
				alert.setPositiveButton("MAIN", new OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						Intent intentdia=new Intent(getApplicationContext(),Stage_Activity.class);
						intentdia.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
						startActivity(intentdia);
					}
				});

				AlertDialog dialog=alert.create();
				dialog.show();
			}
		}.start();
		isTimerOn = true;
	}

	@Override
	public void onDestroy() {
		//TODO adView.destroy();
		super.onDestroy();
		if(typeOfGame==2)
		{
		myTimer.cancel();
		isTimerOn = false;
		}
	}
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		 
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		if(typeOfGame==2)
		{
			myTimer.cancel();
			isTimerOn = false;
		}
	 
	}
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		super.onBackPressed();
 		Intent intentbackk=new Intent(getApplicationContext(),Stage_Activity.class);
		intentbackk.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intentbackk);
		db.AddtoFavorite(new Pojo(allArrayQid[currentPosition],"0",Constant.ADD_LEVEL_IDD));
	}
	 

}
