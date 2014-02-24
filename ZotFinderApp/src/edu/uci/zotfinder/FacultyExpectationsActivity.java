package edu.uci.zotfinder;

import com.actionbarsherlock.app.SherlockActivity;
import com.example.test2app.R;

import android.os.Bundle;
import android.content.Intent;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class FacultyExpectationsActivity extends SherlockActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_faculty_expectations);
		
		getSupportActionBar().setTitle("Faculty/Staff Role and Expectation");
		getSupportActionBar().setHomeButtonEnabled(true);
		
		//creates textView:"ins" that corresponds to textView:"EarthquakeTextView" in file:"activity_earthquake.xml"
		TextView ins = (TextView)findViewById(R.id.FacultyTextView);
		//sets the text of textview to string found in strings file
		ins.setText(Html.fromHtml(getString(R.string.faculty_expectations)));
	}
	
	@Override
	public boolean onOptionsItemSelected(com.actionbarsherlock.view.MenuItem item) {
		if(item.getItemId() == android.R.id.home){
			finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	};

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

}
