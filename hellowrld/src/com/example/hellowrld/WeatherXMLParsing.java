package com.example.hellowrld;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class WeatherXMLParsing extends Activity implements OnClickListener{

	static final String BaseURL = "http://www.google.com/ig/api?weather=";
	TextView tv;
    EditText city, state;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weather);
		Button b = (Button) findViewById(R.id.bWeather);
		 tv = (TextView) findViewById(R.id.tvWeather);
		 city = (EditText) findViewById(R.id.etCity);
	     state = (EditText) findViewById(R.id.etState);
	     b.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String c = city.getText().toString();
		String s = state.getText().toString();
		
		StringBuilder URL = new StringBuilder(BaseURL);
		URL.append(c + "," + s);
		String fullURL = URL.toString();
		try{
			URL website = new URL(fullURL);
			SAXParserFactory spf = SAXParserFactory.newInstance();
			SAXParser sp = spf.newSAXParser();
			XMLReader xr = sp.getXMLReader();
			HandlingXMLStuff doingWork = new HandlingXMLStuff();
			xr.setContentHandler(doingWork);
			xr.parse(new InputSource(website.openStream()));
			String information = doingWork.getInformation();
			tv.setText(information);
		}catch(Exception e){
			tv.setText("error");
			
		}
	}

}
