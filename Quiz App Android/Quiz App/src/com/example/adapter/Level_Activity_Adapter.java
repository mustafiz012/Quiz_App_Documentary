package com.example.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import java.util.List;
import com.example.item.Item_Level_Activity;
import com.viavilab.quizapp.R;

public class Level_Activity_Adapter extends ArrayAdapter<Item_Level_Activity> {


	private Activity activity;
	private List<Item_Level_Activity> itemslevel;
	private Item_Level_Activity objlevelBean;
	private int row;
 	int totalpoint;
	public Level_Activity_Adapter(Activity act, int resource, List<Item_Level_Activity> arrayList, int totalpoint) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.itemslevel = arrayList;
		this.totalpoint=totalpoint;

	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);

			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((itemslevel == null) || ((position + 1) > itemslevel.size()))
			return view;

		objlevelBean = itemslevel.get(position);



		holder.txt_levelname=(TextView)view.findViewById(R.id.text_levelname);
		holder.rel=(RelativeLayout)view.findViewById(R.id.rel1);

		holder.txt_levelname.setText(objlevelBean.getLevelName().toString());
	 
		
		if(totalpoint >= Integer.parseInt(objlevelBean.getLevelRequirePoint().toString()))
		{
			holder.rel.setBackgroundResource(R.drawable.active_level_bg);
			holder.txt_levelname.setTextColor(activity.getResources().getColor(R.color.unlock_color));
		}
		else
		{	
			holder.rel.setBackgroundResource(R.drawable.none_active_level_bg);
			holder.txt_levelname.setTextColor(activity.getResources().getColor(R.color.lock_color));
		}
		
		

		return view;

	}

	public class ViewHolder {

		public ImageView img_levelimage;
		public  TextView txt_levelname;
		public RelativeLayout rel;

	}
} 
