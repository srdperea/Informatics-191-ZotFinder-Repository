package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DepartmentInfoActivity extends Activity {
	
	protected TextView departmentName;
	protected TextView departmentAddress;
	protected TextView departmentPhoneNumber;
	protected TextView departmentWebsite;
	protected String departmentNameString;
	protected String departmentAddressString;
	protected String departmentPhoneNumberString;
	protected String departmentWebsiteString;
	protected float departmentLongitude;
	protected float departmentLatitude;
    protected int departmentId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_department_info);
		
		departmentId = getIntent().getExtras().getInt("DEPARTMENT_ID");
        SQLiteDatabase db = (new DepartmentDatabase(this)).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, departmentName, departmentPhoneNumber, departmentAddress, departmentWebsite, departmentLongitude, departmentLatitude FROM department WHERE _id=?",
        		new String[]{""+departmentId});
        
        if (cursor.getCount() == 1)
        {
        	cursor.moveToFirst();
        
        	departmentName = (TextView) findViewById(R.id.departmentName);
        	departmentNameString = cursor.getString(cursor.getColumnIndex("departmentName"));
        	departmentName.setText(departmentNameString);
	
	        departmentPhoneNumber = (TextView) findViewById(R.id.departmentPhoneNumber);
	        departmentPhoneNumberString = cursor.getString(cursor.getColumnIndex("departmentPhoneNumber"));
	        departmentPhoneNumber.setText(departmentPhoneNumberString);
        	
	        departmentAddress = (TextView) findViewById(R.id.departmentAddress);
	        departmentAddressString = cursor.getString(cursor.getColumnIndex("departmentAddress"));
	        departmentAddress.setText(departmentAddressString);
	        
	        departmentWebsite = (TextView) findViewById(R.id.departmentWebsite);
	        departmentWebsiteString = cursor.getString(cursor.getColumnIndex("departmentWebsite"));
	        departmentWebsite.setText(departmentWebsiteString);
	        
	        departmentLongitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("departmentLongitude")));
	        departmentLatitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("departmentLatitude")));
        }
	}
	
	public void plotPoint(View view)
	{
		Intent intent = new Intent(this,MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("type", 2);
		bundle.putInt("DEPARTMENT_ID", departmentId);
		bundle.putString("departmentName", departmentNameString);
		bundle.putString("departmentAddress", departmentAddressString);
		bundle.putString("departmentPhoneNumber", departmentPhoneNumberString);
		bundle.putFloat("departmentLongitude", departmentLongitude);
		bundle.putFloat("departmentLatitude", departmentLatitude);
		intent.putExtras(bundle);
		startActivity(intent);
	}

	//Back button
		public void finishActivity(View v){
			finish();
		    }
	
	//Footer Methods
		//method to go to activity: MainActivity
		//creates intent used to store the information of a different activity within this activity
		//startActivity(intent) changes the current activity to the intent activity
		public void goToMap(View view) { 
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}
		 
		//method to go to activity: EmergencyActivity
		//creates intent used to store the information of a different activity within this activity
		//startActivity(intent) changes the current activity to the intent activity
		public void goToEmergencyInfo(View view) { 
			Intent intent = new Intent(this,EmergencyActivity.class);
			startActivity(intent);
		}

		//method to go to activity: DialerActivity
		//creates intent used to store the information of a different activity within this activity
		//startActivity(intent) changes the current
		public void goToEmergencyDialer(View view) { 
			Intent intent = new Intent(this,DialerActivity.class);
			startActivity(intent);
		}
		 
		//menu functionality when the user press the physical menu button located on the phone
		//currently the menu feature does nothing	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.person_info, menu);
			return true;
		}

	}