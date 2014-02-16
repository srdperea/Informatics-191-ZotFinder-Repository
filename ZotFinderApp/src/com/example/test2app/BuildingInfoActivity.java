package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class BuildingInfoActivity extends Activity {

	protected TextView buildingName;
	protected TextView buildingAddress;
	protected TextView buildingNumber;
	protected String buildingNameString;
	protected String buildingAddressString;
	protected String buildingNumberString;
    protected int buildingId;
    protected float buildingLongitude;
    protected float buildingLatitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		buildingId = getIntent().getExtras().getInt("BUILDING_ID");
        SQLiteDatabase db = (new BuildingDatabase(this)).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, buildingName, buildingNumber, buildingAddress, buildingLongitude, buildingLatitude FROM building WHERE _id=?",
        		new String[]{""+buildingId});
        
        if (cursor.getCount() == 1)
        {
        	cursor.moveToFirst();
        
        	buildingName = (TextView) findViewById(R.id.buildingName);
        	buildingNameString = cursor.getString(cursor.getColumnIndex("buildingName"));
        	buildingName.setText(buildingNameString);
        	
	
	        buildingAddress = (TextView) findViewById(R.id.buildingAddress);
	        buildingAddressString = cursor.getString(cursor.getColumnIndex("buildingAddress"));
	        buildingAddress.setText(buildingAddressString);
	        

	        buildingNumber = (TextView) findViewById(R.id.buildingNumber);
	        buildingNumberString = cursor.getString(cursor.getColumnIndex("buildingNumber"));
	        buildingNumber.setText(buildingNumberString);
	        
	        buildingLongitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("buildingLongitude")));
	        
	        buildingLatitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("buildingLatitude")));
	        
        }
	}
	
	public void plotPoint(View view)
	{
		Intent intent = new Intent(this,MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("type", 1);
		bundle.putInt("BUILDING_ID", buildingId);
		bundle.putString("buildingName", buildingNameString);
		bundle.putString("buildingAddress", buildingAddressString);
		bundle.putString("buildingNumber", buildingNumberString);
		bundle.putFloat("buildingLongitude", buildingLongitude);
		bundle.putFloat("buildingLatitude", buildingLatitude);
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
