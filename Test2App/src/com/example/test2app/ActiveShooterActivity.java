package com.example.test2app;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Html;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class ActiveShooterActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_active_shooter);
		
		TextView ins = (TextView)findViewById(R.id.ActiveShooterTextView);
		ins.setText(Html.fromHtml(getString(R.string.active_shooter_text)));
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
		getMenuInflater().inflate(R.menu.active_shooter, menu);
		return true;
	}

}
