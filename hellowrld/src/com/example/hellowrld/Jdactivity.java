package com.example.hellowrld;

import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;

public class Jdactivity extends Activity {
	
	EditText text;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_jdactivity);
		text = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.jdactivity, menu);
		return true;
	}
	
	public void calcClicked(View view) { 
		switch(view.getId()) { 
		case R.id.button1 : { 
			RadioButton cbut = (RadioButton) findViewById(R.id.radioButton1);
			RadioButton fbut = (RadioButton) findViewById(R.id.radioButton2);
			
			if(text.getText().length() == 0) { 
				Toast.makeText(this, "Enter the Valid Input...!", Toast.LENGTH_LONG).show();
				return;
			}
			
			//output value
			float ipValue = Float.parseFloat(text.getText().toString());
			//main code...
			if(cbut.isChecked()) { 
				text.setText(String.valueOf(convUtil.convertf2c(ipValue)));
				cbut.setChecked(false);
				fbut.setChecked(true);
			} else { 
				text.setText(String.valueOf(convUtil.convertc2f(ipValue)));
				cbut.setChecked(true);
				fbut.setChecked(false);
			}
			
			break;
		}//end of case...
		
		}
	}

}
