package edu.project.androidmobilesecurity;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ListActivity;
import android.app.LocalActivityManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;

public class ListAppActivity extends ListActivity {
	
	private List<String> results = new ArrayList<String>();
	private List<Drawable> icons = new ArrayList<Drawable>();

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		PackageManager pm = this.getPackageManager();

		Intent intent = new Intent(Intent.ACTION_MAIN, null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);

		List<ResolveInfo> list = pm.queryIntentActivities(intent, PackageManager.PERMISSION_GRANTED);
		
		pm.setApplicationEnabledSetting("com.example.kaye", PackageManager.COMPONENT_ENABLED_STATE_DISABLED, PackageManager.DONT_KILL_APP);
		
//		DevicePolicyManager  mDPM =  (DevicePolicyManager)getSystemService(Context.DEVICE_POLICY_SERVICE);
//		ComponentName mDeviceAdminSample = new ComponentName("com.example.kaye", "MainActiviy");
//		long timeMs = 1000L*Long.parseLong("5");
//		mDPM.setMaximumTimeToLock(mDeviceAdminSample, timeMs);
//		mDPM.lockNow();
		
		for (ResolveInfo rInfo : list) {
			results.add(rInfo.activityInfo.applicationInfo.loadLabel(pm).toString());
//			results.add(rInfo.activityInfo.applicationInfo.packageName.toString());
			icons.add(rInfo.loadIcon(pm));
		}
		
		setListAdapter(new AppArrayAdapter(this, results.toArray(new String[results.size()]), icons.toArray(new Drawable[icons.size()])));
		
//		final ActivityManager activityManager = (ActivityManager) this.getSystemService(ACTIVITY_SERVICE);
//		ActivityManager.MemoryInfo mInfo = new ActivityManager.MemoryInfo ();
//		activityManager.getMemoryInfo( mInfo );
//		
//		activityManager.killBackgroundProcesses("com.example.kaye");
		
//		Timer timer = new Timer();
//	    timer.scheduleAtFixedRate(new TimerTask() {
//	        public void run() {  
//	        	
//	        	Log.d("Timer", "Running Timer");
//	        	
//	        	List<RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
//	            for (RunningAppProcessInfo appProcess : appProcesses) {
//	            	Log.d("PROCESSES", "App processes :"+appProcess);
//	            }
//	            	
//	        }
//	    }, 0, 1000);
			

	}
	
}
