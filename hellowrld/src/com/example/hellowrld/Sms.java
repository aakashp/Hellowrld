package com.example.hellowrld;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.*;
import android.telephony.SmsManager;

public class Sms extends Activity {
	
	Button dsendBut;
	Button appsendBut;
	
	EditText number;
	EditText msg;
	
	String destinNo;
	String mContent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sms_activity);
		dsendBut = (Button) findViewById(R.id.button1);
		appsendBut = (Button) findViewById(R.id.button2);
		number = (EditText) findViewById(R.id.editText1);
		msg = (EditText) findViewById(R.id.editText2);
	}

	
	
	public void dsend(View button) { 
		destinNo = number.getText().toString();
		mContent = msg.getText().toString();
		
		try { 
			SmsManager sms = SmsManager.getDefault();
			
			sms.sendTextMessage(destinNo, null , mContent, null , null);
			
			
			Toast.makeText(getApplicationContext(), "SMS sent Successfully", Toast.LENGTH_LONG).show();
			
			
		} catch(Exception e) { 
			Toast.makeText(getApplicationContext(), "Failed to Send SMS! Try Again! " , Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
		
	}
	
	public void appsend(View button) { 
		destinNo = number.getText().toString();
		mContent = msg.getText().toString();
		
		try { 
			Intent send = new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms", destinNo, null));
			send.putExtra("sms_body", mContent);
			startActivity(send);
		} catch(Exception e) { 
			Toast.makeText(getApplicationContext(), "Failed to Send.. Try Again!" , Toast.LENGTH_LONG).show();
			e.printStackTrace();
		}
	}

}
