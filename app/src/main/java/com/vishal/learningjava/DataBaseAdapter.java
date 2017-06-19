package com.vishal.learningjava;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
 
public class DataBaseAdapter 
{
		static final String DATABASE_NAME = "login";
		static final int DATABASE_VERSION = 1;
		public static final int NAME_COLUMN = 1;
	    private static final String KEY_ID = "id";
	    private static final String KEY_FIRSTNAME = "FIRSTNAME";
	    private static final String KEY_LASTNAME = "LASTNAME";
	    private static final String KEY_STUDENTID = "STUDENTID";
	    private static final String KEY_PASSWORD = "PASSWORD";
	   
		static final String DATABASE_CREATE = "CREATE TABLE " + "LOGIN" + "("
                + KEY_ID + " INTEGER PRIMARY KEY,"
                + KEY_FIRSTNAME + " TEXT,"
                + KEY_LASTNAME + " TEXT,"
                + KEY_STUDENTID + " TEXT UNIQUE,"
                + KEY_PASSWORD + " TEXT"
                 + ")";
		
		public  SQLiteDatabase db;
		private final Context context;
		private DataBaseHelper dbHelper;
		public  DataBaseAdapter(Context _context) 
		{
			context = _context;
			dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
		}
		public  DataBaseAdapter open() throws SQLException 
		{
			db = dbHelper.getWritableDatabase();
			return this;
		}
		public void close() 
		{
			db.close();
		}
 
		public  SQLiteDatabase getdb_instance()
		{
			return db;
		}
 
		public void insertEntry(String fname, String lname, String stdn, String pword)
		{
	       ContentValues newValues = new ContentValues();
	       newValues.put(KEY_FIRSTNAME, fname); 
	       newValues.put(KEY_LASTNAME, lname); 
	       newValues.put(KEY_STUDENTID, stdn);
	       newValues.put(KEY_PASSWORD, pword); 
	     
			db.insert("LOGIN", null, newValues);
			
		}
		
		
		public byte[] retreiveImageFromDB1() {
	        Cursor cursor = db.query("images", null, " id=?", new String[]{"1"}, null, null, null);
	        if (cursor.moveToFirst()) {
	            byte[] blob = cursor.getBlob(cursor.getColumnIndex("image_data"));
	            cursor.close();
	            return blob;
	        }
	        cursor.close();
	        return null;
	    }
		public byte[] retreiveImageFromDB4() {
	        Cursor cursor = db.query("images", null, " id=?", new String[]{"4"}, null, null, null);
	        if (cursor.moveToFirst()) {
	            byte[] blob = cursor.getBlob(cursor.getColumnIndex("image_data"));
	            cursor.close();
	            return blob;
	        }
	        cursor.close();
	        return null;
	    }
		public byte[] retreiveImageFromDB2() {
	        Cursor cursor = db.query("images", null, " id=?", new String[]{"2"}, null, null, null);
	        if (cursor.moveToFirst()) {
	            byte[] blob = cursor.getBlob(cursor.getColumnIndex("image_data"));
	            cursor.close();
	            return blob;
	        }
	        cursor.close();
	        return null;
	    }
		public byte[] retreiveImageFromDB3() {
	        Cursor cursor = db.query("images", null, " id=?", new String[]{"3"}, null, null, null);
	        if (cursor.moveToFirst()) {
	            byte[] blob = cursor.getBlob(cursor.getColumnIndex("image_data"));
	            cursor.close();
	            return blob;
	        }
	        cursor.close();
	        return null;
	    }
		public byte[] retreiveImageFromDB5() {
	        Cursor cursor = db.query("images", null, " id=?", new String[]{"5"}, null, null, null);
	        if (cursor.moveToFirst()) {
	            byte[] blob = cursor.getBlob(cursor.getColumnIndex("image_data"));
	            cursor.close();
	            return blob;
	        }
	        cursor.close();
	        return null;
	    }
		public byte[] retreiveImageFromDB6() {
	        Cursor cursor = db.query("images", null, " id=?", new String[]{"6"}, null, null, null);
	        if (cursor.moveToFirst()) {
	            byte[] blob = cursor.getBlob(cursor.getColumnIndex("image_data"));
	            cursor.close();
	            return blob;
	        }
	        cursor.close();
	        return null;
	    }
		public String getstdn(String stdn)
		{
			Cursor cursor=db.query("LOGIN", null, " STUDENTID=?", new String[]{stdn}, null, null, null);
	        if(cursor.getCount()<1) 
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
		    
			String stdng= cursor.getString(cursor.getColumnIndex("STUDENTID"));
		    
			cursor.close();
			return stdng;				
		}
		public String getfname(String fname)
		{
			Cursor cursor=db.query("LOGIN", null, " FIRSTNAME=?", new String[]{fname}, null, null, null);
	        if(cursor.getCount()<1) 
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
		    
			String fnameg= cursor.getString(cursor.getColumnIndex("FIRSTNAME"));
			
			cursor.close();
			return fnameg;				
		}
		
		public String getlname(String lname)
		{
			Cursor cursor=db.query("LOGIN", null, " LASTNAME=?", new String[]{lname}, null, null, null);
	        if(cursor.getCount()<1) 
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
		    
			String lnameg= cursor.getString(cursor.getColumnIndex("LASTNAME"));
		    
			cursor.close();
			return lnameg;				
		}
		
		public String getpword(String pword)
		{
			Cursor cursor=db.query("LOGIN", null, " PASSWORD=?", new String[]{pword}, null, null, null);
	        if(cursor.getCount()<1) 
	        {
	        	cursor.close();
	        	return "NOT EXIST";
	        }
		    cursor.moveToFirst();
		    
			String pwordg= cursor.getString(cursor.getColumnIndex("PASSWORD"));
		    
		    
			cursor.close();
			return pwordg;				
		}
}