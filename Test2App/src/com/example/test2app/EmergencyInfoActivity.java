package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class EmergencyInfoActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_info);
	}
	
	
	/**ALL THE EMERGENCY INFO 
	 * 
	 * ACTIVITY STARTERS FOR BUTTONS
	 */
	
	public void goToActiveShooter(View view)
	{
		Intent intent = new Intent(this,ActiveShooterActivity.class);
		startActivity(intent);
	}
	
	public void goToEarthquake(View view)
	{
		Intent intent = new Intent(this,EarthquakeActivity.class);
		startActivity(intent);
	}
	
	public void goToBombThreat(View view)
	{
		Intent intent = new Intent(this,BombThreatActivity.class);
		startActivity(intent);
	}
	
	public void goToEvacuation(View view)
	{
		Intent intent = new Intent(this,EvacuationActivity.class);
		startActivity(intent);
	}
	
	public void goToHazardousMaterial(View view)
	{
		Intent intent = new Intent(this,HazardousMaterialActivity.class);
		startActivity(intent);
	}
	
	public void goToViolence(View view)
	{
		Intent intent = new Intent(this,ViolenceActivity.class);
		startActivity(intent);
	}
	
	public void goToEvacuationDisabilities(View view)
	{
		Intent intent = new Intent(this,EvacuationDisabilitiesActivity.class);
		startActivity(intent);
	}
	
	public void goToHazardousMaterialShelter (View view)
	{
		Intent intent = new Intent(this,HazardousMaterialShelterActivity.class);
		startActivity(intent);
	}	
	
	public void goToMedicalEmergency(View view)
	{
		Intent intent = new Intent(this,MedicalEmergencyActivity.class);
		startActivity(intent);
	}	
	
	public void goToPowerOutage(View view)
	{
		Intent intent = new Intent(this,UtilityFailureActivity.class);
		startActivity(intent);
	}
	
	public void goToSuspiciousPackage(View view)
	{
		Intent intent = new Intent(this,SuspiciousPackageActivity.class);
		startActivity(intent);
	}
	
	/**Footer Activity Starters
	 * 
	 * @param view
	 */
	
	 public void goToMap(View view)
	 { 
			Intent intent = new Intent(this,MainActivity.class);
			startActivity(intent);
	 }
	 
	 public void goToEmergencyInfo(View view) 
	 { 
			Intent intent = new Intent(this,EmergencyInfoActivity.class);
			startActivity(intent);
	 }	
	 
	 public void goToEmergencyDialer(View view) 
	 { 
			Intent intent = new Intent(this,DialerActivity.class);
			startActivity(intent);
	 }
	 
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) 
	{
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.emergency_info, menu);
		return true;
	}

}
