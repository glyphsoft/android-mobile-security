package edu.project.androidmobilesecurity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ListActivity {
	
	//Temporary options
	private static final String[] MENUS = new String[] { "About", "Image Capture Demo", "Send Email Demo", "List Installed Applications Demo"};
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setListAdapter(new ArrayAdapter<String>(this, R.layout.activity_main, MENUS));

		ListView listView = getListView();
		listView.setTextFilterEnabled(true);

		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				
				// TODO when clicked...
				
				Toast.makeText(getApplicationContext(),
						"Selected: "+((TextView) view).getText(), Toast.LENGTH_SHORT).show();
				
				Intent intent1 = new Intent(MainActivity.this, ImageCaptureActivity.class);
				Intent intent2 = new Intent(MainActivity.this, SendEmailActivity.class);
				Intent intent3 = new Intent(MainActivity.this, ListAppActivity.class);
				
				switch (position) {
					case 1: startActivity(intent1); break;
		        	case 2: startActivity(intent2); break;
		        	case 3: startActivity(intent3); break;	
				}
//				
				
			}
		});

	}
}
