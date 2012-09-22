package edu.project.androidmobilesecurity;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class SendEmailActivity extends Activity {

	private LocationManager locationManager = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);

    	setContentView(R.layout.activity_send_email);
    	
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        
    }
    
    LocationListener onLocationChange=new LocationListener() {
        public void onLocationChanged(Location loc) {
        	
        	String text = "This email was sent in these locations: " +
            "Latitude = " + loc.getLatitude() +
            "Longitude = " + loc.getLongitude();
            
            Toast.makeText(getApplicationContext(),
					text, Toast.LENGTH_SHORT).show();
            
            try {   
                MailSender sender = new MailSender("vergarakaye@gmail.com", "kaye0427");
                sender.sendMail("Android Mobile Security",   
                        text,   
                        "mark_anro@rocketmail.com",   
                        "mark_anro@rocketmail.com, kristine_vergara@ymail.com", "attachment filename/filepath");   
            } catch (Exception e) {   
                Log.e("SendMail", e.getMessage(), e);   
            }    
        }
         
        public void onProviderDisabled(String provider) {
        	// TODO
        }
         
        public void onProviderEnabled(String provider) {
        	// TODO
        }
         
        public void onStatusChanged(String provider, int status, Bundle extras) {
        	// TODO
        }
    };
    
    @Override
    public void onPause() {
        super.onPause();
        locationManager.removeUpdates(onLocationChange);
    }
    
    @Override
    public void onResume() {
        super.onResume();
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,0,1000,onLocationChange);
    }

}
