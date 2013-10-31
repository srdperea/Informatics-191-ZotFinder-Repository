package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PowerOutageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_power_outage);
		
		TextView ins = (TextView)findViewById(R.id.PowerOutageTextView);
		ins.setText(Html.fromHtml(getString(R.string.power_outage_text)));
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

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.power_outage, menu);
		return true;
	}

}