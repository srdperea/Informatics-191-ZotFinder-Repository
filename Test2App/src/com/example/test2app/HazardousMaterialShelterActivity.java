package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class HazardousMaterialShelterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hazardous_material_shelter);
		
		//creates textView:"ins" that corresponds to textView:"HazardousMaterialShelterTextView" in file:"activity_hazardous_material_shelter.xml"
		TextView ins = (TextView)findViewById(R.id.HazardousMaterialShelterTextView);
		//sets the text of textview to string found in strings file
		ins.setText(Html.fromHtml(getString(R.string.hazardous_material_shelter_text)));
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
		getMenuInflater().inflate(R.menu.hazardous_material_shelter, menu);
		return true;
	}

}
