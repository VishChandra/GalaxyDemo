package com.vishal.learningjava;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
 
public class DataBaseHelper extends SQLiteOpenHelper
{
	public static String DB_PATH = "/data/data/com.vishal.learningjava/databases/";
    public static String DB_NAME = "login.db";
    private SQLiteDatabase mydb;
    private Context context;
	
	public DataBaseHelper(Context context, String name,CursorFactory factory, int version) 
    {
	           super(context, DB_NAME, null, 1);
	           this.context = context;
	}
	
	@Override
	public void onCreate(SQLiteDatabase _db) 
	{
		_db.execSQL(DataBaseAdapter.DATABASE_CREATE);
	}
	
	@Override
	public synchronized void close(){
	    if(mydb!=null){
	        mydb.close();
	    }
	    super.close();
	}
	
	public void copydb() throws IOException{
	    try {
		        InputStream myInput = context.getAssets().open(DB_NAME);
		        String outputFileName = DB_PATH + DB_NAME;
		        OutputStream myOutput = new FileOutputStream(outputFileName);
	
		        byte[] buffer = new byte[1024];
		        int length;
	
		        while((length = myInput.read(buffer))>0){
		            myOutput.write(buffer, 0, length);
		        }
	        
			    myOutput.flush();
			    myOutput.close();
			    myInput.close();
	        
	    } 
	    catch (Exception e) {
	        Log.e("copydb", e.getMessage());
	    }
	}
	
	public void openDataBase() throws SQLException{
	    String myPath = DB_PATH + DB_NAME;
	    mydb = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
	}
	public void createDataBase() throws IOException {
	        this.getReadableDatabase();
	        try {
	            copydb();
	        } catch (IOException e) {
	           
	        }
	    }
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	
}