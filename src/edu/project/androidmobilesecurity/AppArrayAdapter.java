package edu.project.androidmobilesecurity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AppArrayAdapter extends ArrayAdapter<String> {
	
	private final Context context;
	private final String[] values;
 
	public AppArrayAdapter(Context context, String[] values) {
		super(context, R.layout.activity_list_app, values);
		this.context = context;
		this.values = values;
	}
 
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
 
		View rowView = inflater.inflate(R.layout.activity_list_app, parent, false);
		TextView textView = (TextView) rowView.findViewById(R.id.label);
		textView.setText(values[position]);
 
		return rowView;
	}
}
