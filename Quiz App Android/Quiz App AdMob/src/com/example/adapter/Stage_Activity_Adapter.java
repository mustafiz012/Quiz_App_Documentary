package com.example.adapter;

import java.util.ArrayList;
import java.util.List;
import com.example.database.DatabaseHandler;
import com.example.database.Pojo;
import com.example.item.Item_Stage_Activity;
import com.example.util.Constant;
import com.viavilab.quizapp.R;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;


public class Stage_Activity_Adapter extends  ArrayAdapter<Item_Stage_Activity> {


	private Activity activity;
	private List<Item_Stage_Activity> itemstage;
	private Item_Stage_Activity objstageBean;
	private int row;
	
	KeyClickListener mListener;
	List<Pojo> AllPoint;
	boolean found = false;
	int id;
	DatabaseHandler db;
	private ArrayList<String> data;

	public Stage_Activity_Adapter(Activity act, int resource, List<Item_Stage_Activity> arrayList,KeyClickListener listener) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.itemstage = arrayList;
		this.mListener = listener;
		db=new DatabaseHandler(activity);
		id=db.getlaststageid();
		AllPoint=db.getLevel(Constant.ADD_LEVEL_IDD);
		data=new ArrayList<String>();
		
		for(int i=0;i<itemstage.size();i++)
		{
			data.add(String.valueOf(i+1));
		}
	
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		final Button btnquesno;
		 

		 if (convertView == null) {
	            LayoutInflater inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	            btnquesno = (Button)inflater.inflate(row,parent,false);
	        } else {
	        	btnquesno = (Button) convertView;
	        }
		 
		objstageBean = itemstage.get(position);
		
		
		
		btnquesno.setId(Integer.parseInt(objstageBean.getLevelWiseQuesId().toString()));
		
			if(AllPoint.size()==0)
			{
				if(btnquesno.getId()==Integer.parseInt(itemstage.get(0).getLevelWiseQuesId()))
				{
					 btnquesno.setBackgroundResource(R.drawable.score_btn);
			//		 btnquesno.setText(objstageBean.getLevelWiseQuesId().toString());
					 btnquesno.setText(data.get(position));
					 
					 
				}
				else
				{
					btnquesno.setBackgroundResource(R.drawable.scrore_lock);
					btnquesno.setText("");
				}
				
			}
			else
			{
				if(btnquesno.getId()<=Integer.parseInt(AllPoint.get(id).getPId().toString()))
				{
					 btnquesno.setBackgroundResource(R.drawable.score_btn);
//					 btnquesno.setText(objstageBean.getLevelWiseQuesId().toString());
					 btnquesno.setText(data.get(position));
				}
				else
				{
					 btnquesno.setBackgroundResource(R.drawable.scrore_lock);
					 btnquesno.setText("");
				}
			}
	
			
		 btnquesno.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				if(AllPoint.size()==0)
				{
					if(btnquesno.getId()==Integer.parseInt(itemstage.get(0).getLevelWiseQuesId()))
					{	
						mListener.keyClickedIndex(position);
					}
					else
					{
						
					}
				}
				else
				{
					if(btnquesno.getId()<=Integer.parseInt(AllPoint.get(id).getPId().toString()))
					{
						mListener.keyClickedIndex(position);
					}
					else
					{
						 
					}
				}
				
			
			}
		});

		return btnquesno;
	}

	public interface KeyClickListener
	{
		public void keyClickedIndex(int index);
	}
} 



