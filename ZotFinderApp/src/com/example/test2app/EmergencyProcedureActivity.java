package com.example.test2app;

import com.actionbarsherlock.app.SherlockActivity;

import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class EmergencyProcedureActivity extends SherlockActivity {
    
	String emergencyTitle;
	String emergencyInfo;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_emergency_procedure);
		
		getSupportActionBar().setHomeButtonEnabled(true);
		
		//grabs the name from the intent passed from SearchActivity
		//puts it into set textView:"personInfoHeaderTextView"
		
		emergencyTitle = getIntent().getExtras().getString("emergencyName");
		getSupportActionBar().setTitle(emergencyTitle);
		emergencyInfo = getIntent().getExtras().getString("emergencyInfo");
		TextView emergencyTextView = (TextView) findViewById(R.id.emergencyProcedureTextView);
		emergencyTextView.setText(Html.fromHtml(emergencyInfo)); 
		
			
	}
	
	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		if(item.getItemId() == android.R.id.home){
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	};
	
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

}
