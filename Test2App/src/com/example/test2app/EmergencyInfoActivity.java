package com.example.test2app;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class EmergencyInfoActivity extends Activity {
	Bundle bundle;

	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_info);
	       //bundle is used as a map (data structure) to pass to new activity
        bundle = new Bundle();
	}
	
	//Emergency Information methods
	
	//method to go to activity: ActiveShooterActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current activity to the intent activity

	public void viewInfo(View v)
	{
		int id = v.getId();

		if(id == R.id.topActiveShooterButton || id == R.id.activeShooterButton) {
			bundle.putString("emergencyName", getString(R.string.active_shooter_title));
			bundle.putString("emergencyInfo", getString(R.string.active_shooter_text));
		} else if (id == R.id.topEarthquakeButton || id == R.id.earthquakeButton){
			bundle.putString("emergencyName", getString(R.string.earthquake_title));
			bundle.putString("emergencyInfo", getString(R.string.earthquake_text));
		} else if (id == R.id.topEmergencyPreparednessButton || id == R.id.emergencyPreparednessButton){
			bundle.putString("emergencyName", getString(R.string.emergency_preparedness_title));
			bundle.putString("emergencyInfo", getString(R.string.emergency_preparedness_text));
		} else if (id == R.id.topFireButton || id == R.id.fireButton){
			bundle.putString("emergencyName", getString(R.string.fire_title));
			bundle.putString("emergencyInfo", getString(R.string.fire_text));
		} else if (id == R.id.topPersonsInDistressButton || id == R.id.personsInDistressButton){
			bundle.putString("emergencyName", getString(R.string.persons_in_distress_title));
			bundle.putString("emergencyInfo", getString(R.string.persons_in_distress_text));
		} else if (id == R.id.bombThreatButton){
			bundle.putString("emergencyName", getString(R.string.bomb_threat_title));
			bundle.putString("emergencyInfo", getString(R.string.bomb_threat_text));
		} else if (id == R.id.evacuationButton){
			bundle.putString("emergencyName", getString(R.string.evacuation_title));
			bundle.putString("emergencyInfo", getString(R.string.evacuation_text));
		} else if (id == R.id.evacuationDisabilitiesButton){
			bundle.putString("emergencyName", getString(R.string.evacuation_disabilities_title));
			bundle.putString("emergencyInfo", getString(R.string.evacuation_disabilities_text));
		} else if (id == R.id.hazardousMaterialButton){
			bundle.putString("emergencyName", getString(R.string.hazardous_material_title));
			bundle.putString("emergencyInfo", getString(R.string.hazardous_material_text));
		} else if (id == R.id.hazardousMaterialShelterButton){
			bundle.putString("emergencyName", getString(R.string.hazardous_material_shelter_title));
			bundle.putString("emergencyInfo", getString(R.string.hazardous_material_shelter_text));
		} else if (id == R.id.medicalEmergencyButton){
			bundle.putString("emergencyName", getString(R.string.medical_emergency_title));
			bundle.putString("emergencyInfo", getString(R.string.medical_emergency_text));
		} else if (id == R.id.suspiciousPackageButton){
			bundle.putString("emergencyName", getString(R.string.suspicious_package_title));
			bundle.putString("emergencyInfo", getString(R.string.suspicious_package_text));
		} else if (id == R.id.violenceButton){
			bundle.putString("emergencyName", getString(R.string.violence_title));
			bundle.putString("emergencyInfo", getString(R.string.violence_text));
		} else if (id == R.id.utilityFailureButton){
			bundle.putString("emergencyName", getString(R.string.utility_failure_title));
			bundle.putString("emergencyInfo", getString(R.string.utility_failure_text));
		}

		 //Setup the Intent that will start the next Activity
	    Intent emergencyProcedureActivity = new Intent(this, EmergencyProcedureActivity.class); 
	    
	    //Assumes this references this instance of Activity A
	    //puts the bundle into the intent:"personInfoActivity"
	    emergencyProcedureActivity.putExtras(bundle);
	    startActivity(emergencyProcedureActivity);	
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
	}

	//method to go to activity: DialerActivity
	//creates intent used to store the information of a different activity within this activity
	//startActivity(intent) changes the current
	public void goToEmergencyDialer(View view) { 
		Intent intent = new Intent(this,DialerActivity.class);
		startActivity(intent);
		overridePendingTransition(R.anim.slide_left,R.anim.abc_fade_in);
	}
	
	public void goToRolesExpectations(View view) { 
		Intent intent = new Intent(this,RolesExpectationsActivity.class);
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
