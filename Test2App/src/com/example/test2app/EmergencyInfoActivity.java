package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class EmergencyInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_info);
	}
	
	//Emergency Information methods
	
	//method to go to activity: ActiveShooterActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current activity to the intent activity
	public void goToActiveShooter(View view) {
		Intent intent = new Intent(this,ActiveShooterActivity.class);
		startActivity(intent);
	}
	
	public void goToEarthquake(View view) {
		Intent intent = new Intent(this,EarthquakeActivity.class);
		startActivity(intent);
	}
	
	public void goToBombThreat(View view) {
		Intent intent = new Intent(this,BombThreatActivity.class);
		startActivity(intent);
	}
	
	public void goToEvacuation(View view) {
		Intent intent = new Intent(this,EvacuationActivity.class);
		startActivity(intent);
	}
	
	public void goToHazardousMaterial(View view) {
		Intent intent = new Intent(this,HazardousMaterialActivity.class);
		startActivity(intent);
	}
	
	public void goToViolence(View view) {
		Intent intent = new Intent(this,ViolenceActivity.class);
		startActivity(intent);
	}
	
	public void goToEvacuationDisabilities(View view) {
		Intent intent = new Intent(this,EvacuationDisabilitiesActivity.class);
		startActivity(intent);
	}
	
	public void goToHazardousMaterialShelter (View view) {
		Intent intent = new Intent(this,HazardousMaterialShelterActivity.class);
		startActivity(intent);
	}	
	
	public void goToMedicalEmergency(View view) {
		Intent intent = new Intent(this,MedicalEmergencyActivity.class);
		startActivity(intent);
	}	
	
	public void goToUtilityFailure(View view) {
		Intent intent = new Intent(this,UtilityFailureActivity.class);
		startActivity(intent);
	}
	
	public void goToSuspiciousPackage(View view) {
		Intent intent = new Intent(this,SuspiciousPackageActivity.class);
		startActivity(intent);
	}
	
	public void goToFire(View view) {
		Intent intent = new Intent(this,FireActivity.class);
		startActivity(intent);
	}
	
	public void goToEmergencyPreparedness(View view) {
		Intent intent = new Intent(this,EmergencyPreparednessActivity.class);
		startActivity(intent);
	}
	
	public void goToPersonsInDistress(View view) {
		Intent intent = new Intent(this,PersonsInDistressActivity.class);
		startActivity(intent);
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
	//currently the menu feature does nothing
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emergency_info, menu);
		return true;
	}
}
