package inf191.team2x2.testapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Get message from Intent in MainActivity when user types
		Intent intent = getIntent();
		
		String message = intent.getStringExtra(MainActivity.var_message);
		
		//Create Text view in new Activity 
		//this means you create text box in a new screen 
		//setText will add a text in the text box from the intent

		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(message);
		
		
		//Set the activity with new text that you set 
		setContentView(textView);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_message, menu);
		return true;
	}

}
