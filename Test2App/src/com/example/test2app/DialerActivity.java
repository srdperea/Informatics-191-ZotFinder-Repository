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
	
	 public void goToMap(View view) { 
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
		}
	 
	 public void goToEmergencyInfo(View view) { 
			Intent intent = new Intent(this,EmergencyInfoActivity.class);
			startActivity(intent);
		}
	 
	 public void goToEmergencyDialer(View view) { 
			Intent intent = new Intent(this,DialerActivity.class);
			startActivity(intent);
		}
	 
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.dialer, menu);
		return true;
	}

}
