package com.example.hellowrld;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SqliteDatabase extends Activity implements OnClickListener{
Button sqlUpdate, sqlView, sqlModify, sqlGetInfo,sqlDelete;
EditText sqlHotness, sqlName, sqlRow;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.sqllitedatabase);
		
		sqlUpdate = (Button) findViewById(R.id.bSQLUpdate);
		sqlView = (Button) findViewById(R.id.bSQLOpenView);
		sqlHotness = (EditText) findViewById(R.id.etsqlHotness);
		sqlName = (EditText) findViewById(R.id.etsqlname);
		sqlRow = (EditText) findViewById(R.id.etSqlRowInfo);
		sqlDelete = (Button) findViewById(R.id.bSqlDelete);
		sqlModify = (Button) findViewById(R.id.bSqlModify);
		sqlDelete = (Button) findViewById(R.id.bSqlDelete);
		sqlGetInfo = (Button) findViewById(R.id.bGetInfoSql);
		
		sqlUpdate.setOnClickListener(this);
		sqlGetInfo.setOnClickListener(this);
		sqlModify.setOnClickListener(this);
		sqlDelete.setOnClickListener(this);
		sqlView.setOnClickListener(this);
	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch(arg0.getId()){
		case R.id.bSQLUpdate:
			Boolean didItWork = true;
			try{
			String name = sqlName.getText().toString();
			String hotness = sqlHotness.getText().toString();
			
			HotOrNot entry = new HotOrNot(SqliteDatabase.this);
			entry.open();
			entry.CreateEntry(name,hotness);
			entry.close();
			}
			catch(Exception e){
				didItWork = false;
				String error = e.toString();
				Dialog d = new Dialog(this);
				d.setTitle("Dang It!");
				TextView tv = new TextView(this);
				tv.setText(error);
				d.setContentView(tv);
				d.show();

			}
			finally{
				if(didItWork){
					Dialog d = new Dialog(this);
					d.setTitle("Heck Yea!");
					TextView tv = new TextView(this);
					tv.setText("Sucess");
					d.setContentView(tv);
					d.show();
					
				}
			}
			break;
		case R.id.bSQLOpenView:
			Intent i = new Intent("com.example.hellowrld.SQLVIEW");
			startActivity(i);
			break;
			
		case R.id.bGetInfoSql:try{
			String s = sqlRow.getText().toString();
			long l = Long.parseLong(s);
			HotOrNot hon = new HotOrNot(this);
			hon.open();
			String returnName = hon.getName(l);
			String returnHotness = hon.getHotness(l);
			hon.close();
			
			sqlName.setText(returnName);
			sqlHotness.setText(returnHotness);
		}
		catch(Exception e){
		
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Dang It!");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();

		}
			break;
		case R.id.bSqlModify:try{
			String mname = sqlName.getText().toString();
			String mhotness = sqlHotness.getText().toString();
			String sRow = sqlRow.getText().toString();
			long lRow = Long.parseLong(sRow);
			
			HotOrNot ex = new HotOrNot(this);
			ex.open();
			ex.updateentry(lRow,mname,mhotness);
			ex.close();
		}
		catch(Exception e){
			
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Dang It!");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();

		}
			break;
		case R.id.bSqlDelete:try{
			String sRow1 = sqlRow.getText().toString();
			long lRow1 = Long.parseLong(sRow1);
			HotOrNot ex1 = new HotOrNot(this);
			ex1.open();
			ex1.deleteEntry(lRow1);
			ex1.close();
		}
		catch(Exception e){
			
			String error = e.toString();
			Dialog d = new Dialog(this);
			d.setTitle("Dang It!");
			TextView tv = new TextView(this);
			tv.setText(error);
			d.setContentView(tv);
			d.show();

		}
			break;
		}
		
	}

}
