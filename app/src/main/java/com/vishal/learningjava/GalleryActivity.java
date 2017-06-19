package com.vishal.learningjava;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;


public class GalleryActivity extends Activity {
	DataBaseAdapter db_adapter;
	ImageView earth,jupiter,saturn, neptune, venus, mercury;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gallery);
		
		AlertDialog alertDialog = new AlertDialog.Builder(GalleryActivity.this).create();
		alertDialog.setTitle("Note");
		alertDialog.setMessage("Touch text to view the image!");
		alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Okay",
		    new DialogInterface.OnClickListener() {
		        public void onClick(DialogInterface dialog, int which) {
		            dialog.dismiss();
		        }
		    });
		alertDialog.show();
		
		db_adapter=new DataBaseAdapter(this);
	    db_adapter=db_adapter.open();
	    
	    earth = (ImageView) findViewById(R.id.earth);
	    jupiter = (ImageView) findViewById(R.id.jupiter);
	    saturn = (ImageView) findViewById(R.id.saturn);
	    neptune = (ImageView) findViewById(R.id.neptune);
	    venus = (ImageView) findViewById(R.id.venus);
	    mercury = (ImageView) findViewById(R.id.mercury);
	    
        findViewById(R.id.earthtxt).setOnClickListener(new OnClickListener() {
	           public void onClick(View view) {
	        	   byte[] bytes = db_adapter.retreiveImageFromDB1();
	        	   earth.setImageBitmap(Utils.getimg(bytes));
	        		 }
	        });
        findViewById(R.id.neptunetxt).setOnClickListener(new OnClickListener() {
	           public void onClick(View view) {
	        	   byte[] bytes1 = db_adapter.retreiveImageFromDB2();
	        	   neptune.setImageBitmap(Utils.getimg(bytes1));
	        		 }
	        });
        findViewById(R.id.saturntxt).setOnClickListener(new OnClickListener() {
	           public void onClick(View view) {
	        	   byte[] bytes2 = db_adapter.retreiveImageFromDB3();
	        	   saturn.setImageBitmap(Utils.getimg(bytes2));
	        		 }
	        });
        findViewById(R.id.jupitertxt).setOnClickListener(new OnClickListener() {
	           public void onClick(View view) {
	        	   byte[] bytes3 = db_adapter.retreiveImageFromDB4();
	        	   jupiter.setImageBitmap(Utils.getimg(bytes3));
	        		 }
	        });
        findViewById(R.id.venustxt).setOnClickListener(new OnClickListener() {
	           public void onClick(View view) {
	        	   byte[] bytes4 = db_adapter.retreiveImageFromDB5();
	        	   venus.setImageBitmap(Utils.getimg(bytes4));
	       		 
	        		 }
	        });
        findViewById(R.id.mercurytxt).setOnClickListener(new OnClickListener() {
	           public void onClick(View view) {
	        	   byte[] bytes5 = db_adapter.retreiveImageFromDB6();
	        	   mercury.setImageBitmap(Utils.getimg(bytes5));
	       		 
	        		 }
	        });
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.gallery, menu);
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
