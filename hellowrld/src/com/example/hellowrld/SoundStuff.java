package com.example.hellowrld;

import android.app.Activity;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;

public class SoundStuff extends Activity implements OnClickListener, OnLongClickListener{
SoundPool sp;
int car =0;
MediaPlayer mp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
	View v = new View(this);
	v.setOnClickListener(this);
	v.setOnLongClickListener(this);
	setContentView(v);
     sp = new SoundPool(5,AudioManager.STREAM_MUSIC,0);
     car = sp.load(this, R.raw._car_lock_,1);
     mp = MediaPlayer.create(this, R.raw.psy_gangnam_style);
    		 
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		if(car != 0)
		sp.play(car, 1,1,0,0,1);
	}

	@Override
	public boolean onLongClick(View arg0) {
		// TODO Auto-generated method stub
		mp.start();
		
		return false;
		
	}
	

}
