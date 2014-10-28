package com.example.hellowrld;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
	int counter;
	Button Add,Sub;
	TextView display;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        counter=0;
       Add= (Button)findViewById (R.id.button1);
       Sub= (Button)findViewById (R.id.button2);
       display= (TextView) findViewById (R.id.textView1);
       
       Add.setOnClickListener(new View.OnClickListener() {
		
		@Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			counter++;
			display.setText("Your total is "+counter);
			
		}
	});
       Sub.setOnClickListener(new View.OnClickListener() {
   		
   		@Override
   		public void onClick(View arg0) {
   			// TODO Auto-generated method stub
   			
   			counter--;
			display.setText("Your total is "+counter);
   		}
   	});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.cool_menu, menu);
        return true;
    }
    
}
