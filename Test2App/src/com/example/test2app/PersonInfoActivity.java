package com.example.test2app;

import java.util.HashMap;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PersonInfoActivity extends Activity {
	String number;
	String name;
	String officeLocation;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_info);
		
		Intent intent = getIntent();
		HashMap<String,String> personResults = (HashMap<String, String>) intent.getSerializableExtra("person");
		Log.w("com.example.test2app",personResults.get("name"));
	
	
		//grabs the name from the intent passed from SearchActivity
		//puts it into set textView:"personInfoHeaderTextView"
		name = personResults.get("name");
		TextView nameTextView = (TextView) findViewById(R.id.personInfoHeaderTextView);
		nameTextView.setText(name);  
		
		//grabs the officeLocation from the intent passed from SearchActivity
		//puts it into set textView:"officeLocation"
		officeLocation = personResults.get("address");
		TextView officeTextView = (TextView) findViewById(R.id.officeLocation);
		officeTextView.setText(officeLocation);    
		officeTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
		officeTextView.setTextColor(getResources().getColor(R.color.black));
		officeTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        
		//some faculty do not have a phone number so this will put the text only if it is a valid phone number
		//if the number provided is equal to "N/A" then a textview will not be set
        number = personResults.get("phoneNumber");
        if (!number.equals("N/A"))
        {
			TextView phoneTextView = (TextView) findViewById(R.id.phoneNumber);
			phoneTextView.setText(number);    
			phoneTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
			phoneTextView.setTextColor(getResources().getColor(R.color.black));
			phoneTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        }
        
        //grabs the email from the intent passed from SearchActivity
      	//puts it into set textView:"email"
        String email = personResults.get("email");
		TextView emailTextView = (TextView) findViewById(R.id.email);
		emailTextView.setText(email);    
		emailTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
		emailTextView.setTextColor(getResources().getColor(R.color.black));
		emailTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
		
	}
	
	//goes to the phone's internal dial screen with the number given
	//if the number is equal to "N/A" meaning the faculty member did not have a phone number, nothing will happen
	public void call(View view) {
		 Intent intent = new Intent(Intent.ACTION_DIAL);
		 if(!(number.equals("N/A"))) {
			 intent.setData(Uri.parse("tel:" + number));
			 startActivity(intent); 
		 }
	}
	
	public void plotPoint(View view)
	{
		String buildingLocation = officeLocation;
		for(int i=1; i<buildingLocation.length(); i++)
		{
			if(Character.isDigit(buildingLocation.charAt(0)))
			{
				buildingLocation = buildingLocation.substring(1);
			}
			else
			{
				buildingLocation = buildingLocation.substring(1);
				break;
			}
		}
		
		//hardcoded solution for DBH
		if(buildingLocation.equals("Donald Bren Hall"))
		{
			buildingLocation = "Bren Hall";
		}
		
		SQLiteDatabase buildingDb = (new BuildingDatabase(this)).getReadableDatabase();
		Cursor cursor = buildingDb.rawQuery("SELECT _id, buildingName, buildingNumber, buildingAddress, buildingLongitude, buildingLatitude FROM building WHERE buildingName like ?",
        		new String[]{buildingLocation});
	    
		 if (cursor.getCount() == 1)
		 {
			 cursor.moveToFirst();
			 Intent intent = new Intent(this,MapActivity.class);
			 Bundle bundle = new Bundle();
			 bundle.putInt("type", -1);
			 bundle.putString("personName", name);
			 bundle.putString("officeAddress", officeLocation);
			 bundle.putFloat("officeLatitude", cursor.getFloat(cursor.getColumnIndex("buildingLatitude")));
			 bundle.putFloat("officeLongitude", cursor.getFloat(cursor.getColumnIndex("buildingLongitude")));
			 intent.putExtras(bundle);
			 startActivity(intent);
		 }
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
	 
	//method to go to activity: EmergencyInfoActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current activity to the intent activity
	public void goToEmergencyInfo(View view) { 
		Intent intent = new Intent(this,EmergencyInfoActivity.class);
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
