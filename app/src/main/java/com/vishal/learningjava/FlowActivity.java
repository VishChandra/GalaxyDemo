package com.vishal.learningjava;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class FlowActivity extends LoginActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_flow);
		
		TextView mytv = (TextView) findViewById(R.id.text1); 
		mytv.setText("Welcome!");
		
		findViewById(R.id.vg).setOnClickListener(new OnClickListener() {
		    
	           public void onClick(View view) {
	        		 android.content.Intent myIntent = new Intent(view.getContext(), GalleryActivity.class);
	                  startActivityForResult(myIntent, 0);
	        	}
	        		
	    });
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
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
