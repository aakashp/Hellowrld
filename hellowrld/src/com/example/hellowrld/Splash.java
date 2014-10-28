package com.example.hellowrld;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;


public class Splash extends Activity{
MediaPlayer oursong;
	@Override
	protected void onCreate(Bundle Aparlikar) {
		// TODO Auto-generated method stub
		super.onCreate(Aparlikar);
	    setContentView(R.layout.splash);
	     oursong = MediaPlayer.create(Splash.this,R.raw.i_like_2_move_it);
	     SharedPreferences getPrefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
	     boolean music = getPrefs.getBoolean("checkbox",true);
	     if(music == true)
	    oursong.start();
	    Thread timer = new Thread(){
	    public void run(){
	    	try{
	    		sleep(5000);	    		
	    	}catch(InterruptedException e){
	    		e.printStackTrace();
	    	}finally{
	    		Intent openStartingPoint = new Intent("com.example.hellowrld.Menu");
	    		startActivity(openStartingPoint);
	    	}
	    }
	};
	timer.start();

	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		oursong.release();
		finish();
		}
	
	
}
