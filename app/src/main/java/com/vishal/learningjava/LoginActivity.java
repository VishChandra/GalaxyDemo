package com.vishal.learningjava;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends Activity {
	
	String firstname="Vishal";
	DataBaseAdapter db_adapter;
	EditText firstnameEditText, lastnameEditText, stdnEditText, passwdEditText;;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		db_adapter=new DataBaseAdapter(this);
	    db_adapter=db_adapter.open();
		
		firstnameEditText = (EditText) findViewById(R.id.fname);
        lastnameEditText = (EditText) findViewById(R.id.lname);
        stdnEditText = (EditText) findViewById(R.id.stdn);
        passwdEditText = (EditText) findViewById(R.id.pword);
        
        findViewById(R.id.signin).setOnClickListener(new OnClickListener() {
        	
        	@Override
            public void onClick(View view) {
        		
        		String fname = firstnameEditText.getText().toString();
                String lname = lastnameEditText.getText().toString();
                String stdn = stdnEditText.getText().toString();
                String pword = passwdEditText.getText().toString();
                
                String getfname=db_adapter.getfname(fname);
                String getlname=db_adapter.getlname(lname);
                String getstdn=db_adapter.getstdn(stdn);
                String getpword=db_adapter.getpword(pword);
                
                
                if(!lname.equals(getlname)) {
                	lastnameEditText.setError("Invalid Lastname");
                }
                if(!fname.equals(getfname)) {
                	firstnameEditText.setError("Invalid Firstname");
                }
                if(!stdn.equals(getstdn)) {
    		 		stdnEditText.setError("Invalid Student ID");
    		 	}
       		 	if(!pword.equals(getpword)) {
       		 		passwdEditText.setError("Invalid Password");
       		 	}
       		 
	       		 if(!isValidfn(fname)) {
	       			AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
	          		 alert.setMessage("Name field must not contain spaces, numbers and special characters")
	          		 	  .setTitle("Error")
	          		 	  .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
	   				
	          		 		  @Override
	          		 		  public void onClick(DialogInterface dialog, int id) {
	          		 			  // TODO Auto-generated method stub
	          		 			  dialog.dismiss();
	          		 		  }
	          		 	  })
	          		 	.show();
	             }
	             else if(!isValidln(lname)) {
	            	 AlertDialog.Builder alert = new AlertDialog.Builder(LoginActivity.this);
	           		 alert.setMessage("Name field must not contain spaces, numbers and special characters")
	           		 	  .setTitle("Error")
	           		 	  .setPositiveButton("Okay", new DialogInterface.OnClickListener() {
	    				
	           		 		  @Override
	           		 		  public void onClick(DialogInterface dialog, int id) {
	           		 			  // TODO Auto-generated method stub
	           		 			  dialog.dismiss();
	           		 		  }
	           		 	  })
	           		 	.show();
	             }
	             else if(lname.equals(getlname) && fname.equals(getfname) && stdn.equals(getstdn) && pword.equals(getpword)) {
	                 	android.content.Intent myIntent = new Intent(view.getContext(), FlowActivity.class);
	                    startActivityForResult(myIntent, 0);
	                 }
        	}
        });
        
	}

	private boolean isValidfn(String fn) {
        String fn_PATTERN = "^[^\\d\\s]+$";

        Pattern pattern = Pattern.compile(fn_PATTERN);
        Matcher matcher = pattern.matcher(fn);
        return matcher.matches();
    }
	private boolean isValidln(String ln) {
        String ln_PATTERN = "^[^\\d\\s]+$";

        Pattern pattern = Pattern.compile(ln_PATTERN);
        Matcher matcher = pattern.matcher(ln);
        return matcher.matches();
    }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
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
