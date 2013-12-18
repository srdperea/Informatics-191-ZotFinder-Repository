package com.example.test2app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.Bundle;
import android.os.StrictMode;
import android.app.Activity;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SearchActivity extends Activity {
	EditText inputBox;
	//bundle is global so that it may be accessed from outside the getData() method
	Bundle bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		//initializes the textView
		inputBox = (EditText)findViewById(R.id.searchEditText);
		
		//adds a listener to when the user presses enter
		//keyCode 66 is the code corresponding to the ENTER key
		//when the user presses the enter key, calls the getData() method and hides the keyboard
 		inputBox.setOnKeyListener(
			new View.OnKeyListener() {

				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if(keyCode == 66){
						//uses the input from the input box as parameter for getData() method
						getData(inputBox.getText().toString());
						
						//hides the keyboard after user presses enter
						InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			               imm.hideSoftInputFromWindow(inputBox.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
						return true;
					}	
					return false;
				}		
			}
		);
	}
	
	//makes HTTP request and creates new intent with parsed output 
	public void getData(String inputValue) {
	    try {
	    	//creating an http connection to make an Http Request
	        StrictMode.ThreadPolicy policy = new StrictMode.
	          ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        URL url = new URL("http://directory.uci.edu/index.php?uid=" + inputValue + "&form_type=plaintext");
	        HttpURLConnection con = (HttpURLConnection) url
	          .openConnection();
	        
	        //bundle is used as a map (data structure) to pass to new activity
	        bundle = new Bundle();
	        readStream(con.getInputStream(), bundle);
	        
	        //Setup the Intent that will start the next Activity
	        Intent personInfoActivity = new Intent(this, PersonInfoActivity.class); 
	        
	        //Assumes this references this instance of Activity A
	        //puts the bundle into the intent:"personInfoActivity"
	        personInfoActivity.putExtras(bundle);
	        startActivity(personInfoActivity);
	   
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}     
	
	//parses the output from the HttpRequest
	//method is void since it access the global variable bundle
	//may have to change this
	private void readStream(InputStream in, Bundle readBundle) {
	  BufferedReader reader = null;
	  //initialize an output string
	  String output = "";
	  //initializes individual tag strings
	  String ucinetid, name, title, department, address, phone = "0", fax = "0", email;
	  try {
	    reader = new BufferedReader(new InputStreamReader(in));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	      output+=line;
	    }
	    
	    //sets the tag strings as the correct data from the output
	    //the following must be done in this order
	    ucinetid = output.split("UCInetID: ")[1].split("<br/>")[0];
	    readBundle.putString("ucinetid", ucinetid);
	    name = output.split("Name: ")[1].split("<br/>")[0];
	    readBundle.putString("name", name);
	    title = output.split("Title: ")[1].split("<br/>")[0];
	    readBundle.putString("title", title);
	    department = output.split("Department: ")[1].split("<br/>")[0];
	    readBundle.putString("department", department);
	    address = output.split("Address: ")[1].split("<br/>")[0];
	    readBundle.putString("address", address);
	    
	    //since some faculty/staff don't have phone numbers or fax number, the method will only parse the number if it exists
	    //if the output does not contain a number, the tag string is written as "N/A"
	    if (output.contains("Phone: ")){
	    	phone = output.split("Phone: ")[1].split("<br/>")[0];
	    	readBundle.putString("phone", phone);
	    }
	    else
	    	readBundle.putString("phone", "N/A");
	    if (output.contains("Fax: ")){
	    	fax = output.split("Fax: ")[1].split("<br/>")[0];
	    	readBundle.putString("fax", fax);
	    }
	    else
	    	readBundle.putString("fax", "N/A");
	   	email = ucinetid + "@uci.edu";
	   	readBundle.putString("email", email);
	   	
	  } catch (IOException e) {
	    e.printStackTrace();
	  } finally {
	    if (reader != null) {
	      try {
	        reader.close();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	    }
	  }
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
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
}
