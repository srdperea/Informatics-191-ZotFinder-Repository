package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ServicesInfoActivity extends Activity {
	
	protected TextView serviceName;
	protected TextView serviceAddress;
	protected String serviceNameString;
	protected String serviceAddressString;
	protected float serviceLongitude;
	protected float serviceLatitude;
    protected int serviceId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_services_info);
		
		serviceId = getIntent().getExtras().getInt("SERVICE_ID");
        SQLiteDatabase db = (new ServicesDatabase(this)).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, serviceName, serviceAddress, serviceLongitude, serviceLatitude FROM service WHERE _id=?",
        		new String[]{""+serviceId});
        
        if (cursor.getCount() == 1)
        {
        	cursor.moveToFirst();
        
        	serviceName = (TextView) findViewById(R.id.serviceName);
        	serviceNameString = cursor.getString(cursor.getColumnIndex("serviceName"));
        	serviceName.setText(serviceNameString);
        	
	        serviceAddress = (TextView) findViewById(R.id.serviceAddress);
	        serviceAddressString = cursor.getString(cursor.getColumnIndex("serviceAddress"));
	        serviceAddress.setText(serviceAddressString);
	        
	        serviceLongitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("serviceLongitude")));
	        serviceLatitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("serviceLatitude")));
        }
	}
	
	public void plotPoint(View view)
	{
		Intent intent = new Intent(this,MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("type", 4);
		bundle.putInt("service_ID", serviceId);
		bundle.putString("serviceName", serviceNameString);
		bundle.putString("serviceAddress", serviceAddressString);
		bundle.putFloat("serviceLongitude", serviceLongitude);
		bundle.putFloat("serviceLatitude", serviceLatitude);
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
