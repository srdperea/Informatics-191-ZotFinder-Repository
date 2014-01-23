package com.example.test2app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PersonInfoActivity extends Activity {
	String number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_info);
		
		//grabs the name from the intent passed from SearchActivity
		//puts it into set textView:"personInfoHeaderTextView"
		String name = getIntent().getExtras().getString("name");
		TextView nameTextView = (TextView) findViewById(R.id.personInfoHeaderTextView);
		nameTextView.setText(name);  
		
		//grabs the officeLocation from the intent passed from SearchActivity
		//puts it into set textView:"officeLocation"
		String officeLocation = getIntent().getExtras().getString("address");
		TextView officeTextView = (TextView) findViewById(R.id.officeLocation);
		officeTextView.setText(officeLocation);    
		officeTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
		officeTextView.setTextColor(getResources().getColor(R.color.black));
		officeTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        
		//some faculty do not have a phone number so this will put the text only if it is a valid phone number
		//if the number provided is equal to "N/A" then a textview will not be set
        number = getIntent().getExtras().getString("phone");
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
        String email = getIntent().getExtras().getString("email");
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
