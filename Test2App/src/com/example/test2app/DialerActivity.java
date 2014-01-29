package com.example.test2app;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class DialerActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_dialer);
	}
	
	//Dialer Methods

	//method to switch intent to phone's internal dialing activity
	//creates intent used to store the information of a different activity within this activity
	//Uri is a data structure used to store data passed from one activity to another
	//tel:xxxxxxxxx is predefined data format used for telephone number
	//startActivity(intent) changes the current
	public void call911(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:911"));
		startActivity(intent);	
	}
	 
	public void callUciPoliceDept(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498245223"));
		startActivity(intent); 	
	}
	 
	public void callEmergencyMgmt(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498247147"));
		startActivity(intent);  
	}
	 
	public void callCounselingCenter(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498246457"));
		startActivity(intent);
	}
	 
	public void callStudentHealth(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498245301"));
		startActivity(intent);  
	}
	 
	public void callEmergencyHealthAndSafety(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498246200"));
		startActivity(intent); 
	}
	 
	public void callFacilitiesMgmtService(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498245444"));
		startActivity(intent); 
	}
	
	public void callOit(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:9498242222"));
		startActivity(intent);  	
	}
	 
	public void callEmergencyInfoLine(View view) {
		Intent intent = new Intent(Intent.ACTION_DIAL);
		intent.setData(Uri.parse("tel:8664786397"));
		startActivity(intent); 
	}
	
	//Footer Methods
  public void finishActivity(View v){
	    finish();
	    }
	
	//method to go to activity: MainActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current activity to the intent activity
	public void goToMap(View view) { 
		Intent intent = new Intent(this,MainActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_right,R.anim.abc_fade_in);
	}
	 
	//method to go to activity: EmergencyInfoActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current activity to the intent activity
	public void goToEmergencyInfo(View view) { 
		Intent intent = new Intent(this,EmergencyInfoActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_right,R.anim.abc_fade_in);
	}

	//method to go to activity: DialerActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current
	public void goToEmergencyDialer(View view) { 
		Intent intent = new Intent(this,DialerActivity.class);
		startActivity(intent);
	}
	 
	//menu functionality when the user press the physical menu button located on the phone
	//currently the menu feature does nothing
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialer, menu);
		return true;
	}
}
