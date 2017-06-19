package com.vishal.learningjava;

import java.io.IOException;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;

public class EntryActivity extends Activity {
	
	DataBaseAdapter db_adapter;
	DataBaseHelper dbHeplper;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_entry);
		
		dbHeplper = new DataBaseHelper(getApplicationContext(), null, null, 1);
		try {
			dbHeplper.createDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		findViewById(R.id.login).setOnClickListener(new OnClickListener() {
					public void onClick(View view) {
		        		 android.content.Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
		                  startActivityForResult(myIntent, 0);
					}
		        		 
		        		
		 });
		        
		findViewById(R.id.registerbtn).setOnClickListener(new OnClickListener() {
			 		public void onClick(View view) {
			 			android.content.Intent myIntent = new Intent(view.getContext(), SignUpActivity.class);
			 			startActivityForResult(myIntent, 0);
			 		}
	
		});
	}	
       
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
