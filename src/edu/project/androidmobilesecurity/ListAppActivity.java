package edu.project.androidmobilesecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

public class ListAppActivity extends ListActivity {
	
	
	static final String[] MOBILE_OS = 
            new String[] { "Android", "iOS", "WindowsMobile", "Blackberry"};
	
	private List<String> results = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PackageManager pm = this.getPackageManager();

		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);

		List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
		
		for (ResolveInfo rInfo : list) {
			results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
		}
		
		setListAdapter(new AppArrayAdapter(this, results.toArray(new String[results.size()])));

	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		String selectedValue = (String) getListAdapter().getItem(position);
		Toast.makeText(this, selectedValue, Toast.LENGTH_SHORT).show();

	}
	
//	private ListView listView;
//	private ArrayList<String> results = new ArrayList<String>();
//
//	@SuppressWarnings({ "unchecked", "rawtypes" })
//	@Override
//	public void onCreate(Bundle savedInstanceState) {
//		super.onCreate(savedInstanceState);
//		setContentView(R.layout.activity_list_app);
//		listView = (ListView) findViewById(R.id.list_view);
//		
//		PackageManager pm = this.getPackageManager();
//
//		Intent intent = new Intent(Intent.ACTION_MAIN, null);
//		intent.addCategory(Intent.CATEGORY_LAUNCHER);
//
//		List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
//		
//		for (ResolveInfo rInfo : list) {
//			results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
//		}
//		 
//		listView.setAdapter(new ArrayAdapter(this, android.R.layout.simple_list_item_multiple_choice, results));
//	}
}
