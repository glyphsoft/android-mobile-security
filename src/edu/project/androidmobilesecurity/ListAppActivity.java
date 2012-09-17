package edu.project.androidmobilesecurity;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;

public class ListAppActivity extends ListActivity {
	
	private List<String> results = new ArrayList<String>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PackageManager pm = this.getPackageManager();

		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);

		List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
		
//		pm.setApplicationEnabledSetting("com.example.kaye", PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
		
		DevicePolicyManager  mDPM =  (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
//		ComponentName mDeviceAdminSample = new ComponentName("com.example.kaye", "MainActiviy");
//		long timeMs = 1000L*Long.parseLong("5");
//		mDPM.setMaximumTimeToLock(mDeviceAdminSample, timeMs);
		mDPM.lockNow();
		
		for (ResolveInfo rInfo : list) {
			//results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
			results.add(rInfo.activityInfo.applicationInfo.packageName.toString());
		}
		
		setListAdapter(new AppArrayAdapter(this, results.toArray(new String[results.size()])));

	}
	
}
