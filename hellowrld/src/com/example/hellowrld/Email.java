package com.example.hellowrld;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class Email extends Activity implements View.OnClickListener {
	EditText personsEmail, Intro, personsName, stupidThings,hatefulAction,outro;
	String EmailAdd,beginning,name,stupidAction,hatefulAct,Out;
	Button sendEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.email);
		
		setVariables();
		sendEmail.setOnClickListener(this);
	}

	private void setVariables() {
		// TODO Auto-generated method stub
		personsEmail = (EditText) findViewById (R.id.etEmails);
		Intro = (EditText) findViewById (R.id.etIntro);
		personsName = (EditText) findViewById(R.id.etName);
		stupidThings = (EditText)findViewById(R.id.etThings);
		hatefulAction = (EditText) findViewById(R.id.etAction);
		outro = (EditText) findViewById(R.id.etOutro);
		sendEmail =(Button) findViewById(R.id.bsentMail);
		
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
		convEditTextToStrings();
		String emailaddress[] = {EmailAdd};
		String message ="Well hello"+name+"I just wanted to tell you"+beginning+"Not only hate"
				+stupidAction+"ffwefwefwefw"+hatefulAct+"egnege"+Out+'\n'+"P.S Aakash";
		
		Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
		emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, EmailAdd);
		emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "I hate you!");
		emailIntent.setType("plain/text");
		emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,message);
		startActivity(emailIntent);
		
	}

	private void convEditTextToStrings() {
		// TODO Auto-generated method stub
		EmailAdd = personsEmail.getText().toString();
		beginning = Intro.getText().toString();
		name = personsName.getText().toString();
		stupidAction =stupidThings.getText().toString();
		hatefulAct =hatefulAction.getText().toString();
		Out = outro.getText().toString();
	}

	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		finish();
	} 

}
