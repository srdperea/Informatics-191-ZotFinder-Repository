package com.example.test2app;

import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class PersonInfoActivity extends Activity {
	String number;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_person_info);
		
		String name = getIntent().getExtras().getString("name");
		TextView nameTextView = (TextView) findViewById(R.id.personInfoHeaderTextView);
		nameTextView.setText(name);  
		
		String officeLocation = getIntent().getExtras().getString("address");
		TextView officeTextView = (TextView) findViewById(R.id.officeLocation);
		officeTextView.setText(officeLocation);    
		officeTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
		officeTextView.setTextColor(getResources().getColor(R.color.black));
		officeTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        
        number = getIntent().getExtras().getString("phone");
        if (!number.equals("N/A"))
        {
			TextView phoneTextView = (TextView) findViewById(R.id.phoneNumber);
			phoneTextView.setText(number);    
			phoneTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
			phoneTextView.setTextColor(getResources().getColor(R.color.black));
			phoneTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        }
        
        String email = getIntent().getExtras().getString("email");
		TextView emailTextView = (TextView) findViewById(R.id.email);
		emailTextView.setText(email);    
		emailTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
		emailTextView.setTextColor(getResources().getColor(R.color.black));
		emailTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        
        
        String fax = getIntent().getExtras().getString("fax");
        if (!fax.equals("N/A"))
        {
			TextView faxTextView = (TextView) findViewById(R.id.fax);
			faxTextView.setText(fax);    
			faxTextView.setTextSize(getResources().getDimension(R.dimen.search_out));
			faxTextView.setTextColor(getResources().getColor(R.color.black));
			faxTextView.setBackgroundColor(getResources().getColor(R.color.light_gray));
        }
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
	 
	 public void call(View view) {
		 Intent intent = new Intent(Intent.ACTION_DIAL);
		 if(!(number.equals("N/A")))
		 {
			 intent.setData(Uri.parse("tel:" + number));
			 startActivity(intent); 
		 }
	
 }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.person_info, menu);
		return true;
	}

}
