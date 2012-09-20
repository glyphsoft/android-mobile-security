package edu.project.androidmobilesecurity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class SendEmailActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);


        try {   
            MailSender sender = new MailSender("vergarakaye@gmail.com", "kaye0427");
            sender.sendMail("Android Mobile Security",   
                    "This is Body",   
                    "mark_anro@rocketmail.com",   
                    "mark_anro@rocketmail.com", "attachment filename/filepath");   
        } catch (Exception e) {   
            Log.e("SendMail", e.getMessage(), e);   
        } 

        
        setContentView(R.layout.activity_send_email);
    }

}
