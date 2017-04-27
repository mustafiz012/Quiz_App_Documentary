package com.viavilab.quizapp;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import com.example.adapter.Stage_Activity_Adapter;
import com.example.adapter.Stage_Activity_Adapter.KeyClickListener;
import com.example.database.DatabaseHandler;
import com.example.database.Pojo;
import com.example.item.Item_Stage_Activity;
import com.example.util.AlertDialogManager;
import com.example.util.Constant;
import com.example.util.JsonUtils;
import com.startapp.android.publish.StartAppAd;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.GridView;

public class Stage_Activity extends Activity implements KeyClickListener{

	GridView gridstage;
	Stage_Activity_Adapter stageadapter;
	ArrayList<Item_Stage_Activity> arrayOfstagelevel ;
	Item_Stage_Activity itemstagelevel;
	AlertDialogManager alert = new AlertDialogManager();
	Item_Stage_Activity item;
	String[] allArrayQid,allArrayQuestion,allArrayOptionA,allArrayOptionB,allArrayOptionC,allArrayOptionD,allArrayOptionAns;
	ArrayList<String> allArrayListid,allArrayListQuestion,allArrayListOptionA,allArrayListOptionB,allArrayListOptionC,allArrayListOptionD,allArrayListOptionAns;
	List<Pojo> AllPoint;
	DatabaseHandler db;
	TextView txtpoint;
	int totalpoint=0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		this.requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		StartAppAd.init(this, getString(R.string.startapp_dev_id),getString(R.string.startapp_app_id));
		setContentView(R.layout.stage_activity);
		StartAppAd.showSlider(this);


		gridstage=(GridView)findViewById(R.id.grid_stage);
		txtpoint=(TextView)findViewById(R.id.text_gridpoint);
		db=new DatabaseHandler(this);
		AllPoint=db.getLevel(Constant.ADD_LEVEL_IDD);
		for(int i=0;i<AllPoint.size();i++)
		{
			totalpoint=totalpoint+Integer.parseInt(AllPoint.get(i).getPTime().toString());
		}

		txtpoint.setText(" Point- "+String.valueOf(totalpoint));

		arrayOfstagelevel= new ArrayList<Item_Stage_Activity>();
		allArrayListid=new ArrayList<String>();
		allArrayListQuestion=new ArrayList<String>();
		allArrayListOptionA=new ArrayList<String>();
		allArrayListOptionB=new ArrayList<String>();
		allArrayListOptionC=new ArrayList<String>();
		allArrayListOptionD=new ArrayList<String>();
		allArrayListOptionAns=new ArrayList<String>();


		allArrayQid=new String[allArrayListid.size()];
		allArrayQuestion=new String[allArrayListQuestion.size()];
		allArrayOptionA=new String[allArrayListOptionA.size()];
		allArrayOptionB=new String[allArrayListOptionB.size()];
		allArrayOptionC=new String[allArrayListOptionC.size()];
		allArrayOptionD=new String[allArrayListOptionD.size()];
		allArrayOptionAns=new String[allArrayListOptionAns.size()];

		if (JsonUtils.isNetworkAvailable(Stage_Activity.this)) {
			new MyTask().execute(Constant.LEVELWISE_QUESTION+Constant.ADD_LEVEL_IDD);
		} else {
			showToast("No Network Connection!!!");
			alert.showAlertDialog(Stage_Activity.this, "Internet Connection Error",
					"Please connect to working Internet connection", false);
		}



	}

	private	class MyTask extends AsyncTask<String, Void, String> {

		ProgressDialog pDialog;

		@Override
		protected void onPreExecute() {
			super.onPreExecute();

			pDialog = new ProgressDialog(Stage_Activity.this);
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
				alert.showAlertDialog(Stage_Activity.this, "Server Connection Error",
						"May Server Under Maintaines Or Low Network", false);

			} else {

				try {
					JSONObject mainJson = new JSONObject(result);
					JSONArray jsonArray = mainJson.getJSONArray(Constant.ADD_LEVEL_ARRAY_NAME);
					JSONObject objJson = null;
					for (int i = 0; i < jsonArray.length(); i++) {
						objJson = jsonArray.getJSONObject(i);

						Item_Stage_Activity objItem = new Item_Stage_Activity();

						objItem.setLevelWiseQuesId(objJson.getString(Constant.LEVELWISE_QUESTION_QID));
						objItem.setLevelWiseQuesLevelId(objJson.getString(Constant.LEVELWISE_QUESTION_LEVELID));
						objItem.setLevelWiseQuesQuestion(objJson.getString(Constant.LEVELWISE_QUESTION_QUESTION));
						objItem.setLevelWiseQuesOptA(objJson.getString(Constant.LEVELWISE_QUESTION_OPTIONA));
						objItem.setLevelWiseQuesOptB(objJson.getString(Constant.LEVELWISE_QUESTION_OPTIONB));
						objItem.setLevelWiseQuesOptC(objJson.getString(Constant.LEVELWISE_QUESTION_OPTIONC));
						objItem.setLevelWiseQuesOptD(objJson.getString(Constant.LEVELWISE_QUESTION_OPTIOND));
						objItem.setLevelWiseQuesAns(objJson.getString(Constant.LEVELWISE_QUESTION_ANS));


						arrayOfstagelevel.add(objItem);


					}



				} catch (JSONException e) {
					e.printStackTrace();
				}

				for(int j=0;j<arrayOfstagelevel.size();j++)
				{
					item=arrayOfstagelevel.get(j);

					allArrayListid.add(item.getLevelWiseQuesId());
					allArrayQid=allArrayListid.toArray(allArrayQid);

					allArrayListQuestion.add(item.getLevelWiseQuesQuestion());
					allArrayQuestion=allArrayListQuestion.toArray(allArrayQuestion);

					allArrayListOptionA.add(item.getLevelWiseQuesOptA());
					allArrayOptionA=allArrayListOptionA.toArray(allArrayOptionA);

					allArrayListOptionB.add(item.getLevelWiseQuesOptB());
					allArrayOptionB=allArrayListOptionB.toArray(allArrayOptionB);

					allArrayListOptionC.add(item.getLevelWiseQuesOptC());
					allArrayOptionC=allArrayListOptionC.toArray(allArrayOptionC);

					allArrayListOptionD.add(item.getLevelWiseQuesOptD());
					allArrayOptionD=allArrayListOptionD.toArray(allArrayOptionD);

					allArrayListOptionAns.add(item.getLevelWiseQuesAns());
					allArrayOptionAns=allArrayListOptionAns.toArray(allArrayOptionAns);
				}


				setAdapterToListview();
			}

		}
	}



	public void setAdapterToListview() {
		stageadapter = new Stage_Activity_Adapter(Stage_Activity.this, R.layout.stage_item_activity,
				arrayOfstagelevel,this);
		gridstage.setAdapter(stageadapter);
	}

	public void showToast(String msg) {
		Toast.makeText(Stage_Activity.this, msg, Toast.LENGTH_LONG).show();
	}

	@Override
	public void keyClickedIndex(int index) {
		// TODO Auto-generated method stub


		Intent intentstage=new Intent(getApplicationContext(),PlayQuiz_Activity.class);
		intentstage.putExtra("POSITION", index);
		intentstage.putExtra("Ques_QId", allArrayQid);
		intentstage.putExtra("Ques_Question", allArrayQuestion);
		intentstage.putExtra("Ques_OptionA", allArrayOptionA);
		intentstage.putExtra("Ques_OptionB", allArrayOptionB);
		intentstage.putExtra("Ques_OptionC", allArrayOptionC);
		intentstage.putExtra("Ques_OptionD", allArrayOptionD);
		intentstage.putExtra("Ques_OptionAns", allArrayOptionAns);
		startActivity(intentstage);

	}
	@Override
	public void onBackPressed()
	{
		super.onBackPressed();
		Intent intback=new Intent(getApplicationContext(),Level_Activity.class);
		intback.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(intback);
	}

}