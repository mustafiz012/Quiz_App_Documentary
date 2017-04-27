package com.viavilab.quizapp;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.adapter.Level_Activity_Adapter;
import com.example.database.DatabaseHandler;
import com.example.database.Pojo;
import com.example.item.Item_Level_Activity;
import com.example.util.AlertDialogManager;
import com.example.util.Constant;
import com.example.util.JsonUtils;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Level_Activity extends Activity{

	Level_Activity_Adapter leveladapter;
	ArrayList<Item_Level_Activity> arrayOflevel ;
	Item_Level_Activity itemlevel;
	AlertDialogManager alert = new AlertDialogManager();
	ListView lsvlevel;
	TextView text_leveltotalpts;
	int totalpoint=0;
	List<Pojo> AllPoint;
	DatabaseHandler db;
	int requiredpoint;
	private AdView mAdView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.level_activity);

		mAdView = (AdView) findViewById(R.id.adView);
		mAdView.loadAd(new AdRequest.Builder().build());

		lsvlevel=(ListView)findViewById(R.id.list_level);
		text_leveltotalpts=(TextView)findViewById(R.id.text_leveltotalpts);

		arrayOflevel= new ArrayList<Item_Level_Activity>();
		db=new DatabaseHandler(this);
		AllPoint=db.getAllData();
		for(int i=0;i<AllPoint.size();i++)
		{
			totalpoint=totalpoint+Integer.parseInt(AllPoint.get(i).getPTime().toString());
		}

		text_leveltotalpts.setText(" Point- "+String.valueOf(totalpoint));
		if (JsonUtils.isNetworkAvailable(Level_Activity.this)) {
			new MyTask().execute(Constant.ADD_LEVEL);
		} else {
			showToast("No Network Connection!!!");
			alert.showAlertDialog(Level_Activity.this, "Internet Connection Error",
					"Please connect to working Internet connection", false);
		}


		lsvlevel.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int position,
					long arg3) {
				// TODO Auto-generated method stub
				//Toast.makeText(getApplicationContext(), ""+position, Toast.LENGTH_SHORT).show();
				itemlevel=arrayOflevel.get(position);

				Constant.ADD_LEVEL_IDD=itemlevel.getLevelId();
				requiredpoint=Integer.parseInt(itemlevel.getLevelRequirePoint().toString());

				if(totalpoint >= requiredpoint)
				{
					Intent intentlevel=new Intent(getApplicationContext(),Stage_Activity.class);
					startActivity(intentlevel);	
				}
				else
				{
					Toast.makeText(Level_Activity.this, "Open This Stage You Required "+requiredpoint +" Points", Toast.LENGTH_SHORT).show();
				}

			}
		});


	}
	private	class MyTask extends AsyncTask<String, Void, String> {

		ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(Level_Activity.this);
			pDialog.setMessage("Loading...");
			pDialog.setCancelable(false);
			pDialog.show();
		}

		@Override
		protected String doInBackground(String... params) {
			return JsonUtils.getJSONString(params[0]);
		}

		@Override
		protected void onPostExecute(String result) {
			super.onPostExecute(result);

			if (null != pDialog && pDialog.isShowing()) {
				pDialog.dismiss();
			}

			if (null == result || result.length() == 0) {
				showToast("Server Connection Error");
				alert.showAlertDialog(Level_Activity.this, "Server Connection Error",
						"May Server Under Maintaines Or Low Network", false);

			} else {

				try {
					JSONObject mainJson = new JSONObject(result);
					JSONArray jsonArray = mainJson.getJSONArray(Constant.ADD_LEVEL_ARRAY_NAME);
					JSONObject objJson = null;
					for (int i = 0; i < jsonArray.length(); i++) {
						objJson = jsonArray.getJSONObject(i);

						Item_Level_Activity objItem = new Item_Level_Activity();

						objItem.setLevelId(objJson.getString(Constant.ADD_LEVEL_ID));
						objItem.setLevelName(objJson.getString(Constant.ADD_LEVEL_LEVELNAME));
						objItem.setLevelRequirePoint(objJson.getString(Constant.ADD_LEVEL_REQUIREPOINT));

						arrayOflevel.add(objItem);


					}

				} catch (JSONException e) {
					e.printStackTrace();
				}


				setAdapterToListview();
			}

		}
	}



	public void setAdapterToListview() {
		leveladapter = new Level_Activity_Adapter(Level_Activity.this, R.layout.level_item_activity,
				arrayOflevel,totalpoint);
		lsvlevel.setAdapter(leveladapter);
	}

	public void showToast(String msg) {
		Toast.makeText(Level_Activity.this, msg, Toast.LENGTH_LONG).show();
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

}
