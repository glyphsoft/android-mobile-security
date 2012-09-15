package edu.project.androidmobilesecurity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class AppArrayAdapter extends ArrayAdapter<String> {

	private final Context context;
	private final String[] values;

	public AppArrayAdapter(Context context, String[] values) {
		super(context, R.layout.activity_list_app, values);
		this.context = context;
		this.values = values;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

		View rowView = inflater.inflate(R.layout.activity_list_app, parent,
				false);
		final TextView textView = (TextView) rowView.findViewById(R.id.label);
		CheckBox checkView = (CheckBox) rowView.findViewById(R.id.check);
		
		
		textView.setText(values[position]);
		
		checkView.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton buttonView,
					boolean isChecked) {
				Toast.makeText(context,
						"Selected: "+textView.getText(), Toast.LENGTH_SHORT).show();
			}
		});

		return rowView;
	}
}
