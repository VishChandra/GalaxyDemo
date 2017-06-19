package com.vishal.learningjava;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.app.Activity;
import android.widget.Toast;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SignUpActivity extends Activity {
	
	DataBaseAdapter db_adapter;
	DataBaseHelper dbHeplper;	
	Button next;
	EditText firstnameEditText, lastnameEditText, stdnEditText, passwdEditText;
	 
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_signup);
		
		db_adapter=new DataBaseAdapter(this);
	    db_adapter=db_adapter.open();
		
		firstnameEditText = (EditText) findViewById(R.id.fname);
        lastnameEditText = (EditText) findViewById(R.id.lname);
        stdnEditText = (EditText) findViewById(R.id.stdn);
        passwdEditText = (EditText) findViewById(R.id.pword);
		
	    next=(Button)findViewById(R.id.register);
	    next.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				String fname = firstnameEditText.getText().toString();
                String lname = lastnameEditText.getText().toString();
                String stdn = stdnEditText.getText().toString();
                String pword = passwdEditText.getText().toString();
                
                if(!isValidstdn(stdn))
                {
                	Toast.makeText(getApplicationContext(),"Enter valid Studet ID", Toast.LENGTH_LONG).show();
                }
                else if (!isValidpass(pword)) {
                    Toast.makeText(getApplicationContext(),"Password must be 6 char long with at least one upper case letter and a number!", Toast.LENGTH_LONG).show();
                }
                
                else{	
                	db_adapter.insertEntry(fname, lname, stdn, pword);
                	Toast.makeText(getApplicationContext(), "Registration Succesful ", Toast.LENGTH_LONG).show();
                }
			}
		});
	    
		findViewById(R.id.bktologin).setOnClickListener(new OnClickListener() {
	 		public void onClick(View view) {
	 			android.content.Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
	 			startActivityForResult(myIntent, 0);
	 		}
	 	});
	}
	
	private boolean isValidpass(String pass) {
        String PASS_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{6,})";

        Pattern pattern = Pattern.compile(PASS_PATTERN);
        Matcher matcher = pattern.matcher(pass);
        return matcher.matches();
    }
	private boolean isValidstdn(String stdn) {
        String stdn_PATTERN = "^[0-9]{9,}$";
        Pattern pattern = Pattern.compile(stdn_PATTERN);
        Matcher matcher = pattern.matcher(stdn);
        return matcher.matches();
    }


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register, menu);
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
