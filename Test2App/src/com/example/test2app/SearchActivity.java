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
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends Activity {
EditText inputBox;
String phoneNumber;
Bundle bundle;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		inputBox = (EditText)findViewById(R.id.searchEditText);
		
 		inputBox.setOnKeyListener(
			new View.OnKeyListener() {

				@Override
				public boolean onKey(View v, int keyCode, KeyEvent event) {
					if(keyCode == 66){
						
						getData(inputBox.getText().toString());
						InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
			               imm.hideSoftInputFromWindow(inputBox.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
						return true;
					}	
					return false;
				}		
			});
	
	}
	
	public void getData(String inputValue) {
	    try {
	        StrictMode.ThreadPolicy policy = new StrictMode.
	          ThreadPolicy.Builder().permitAll().build();
	        StrictMode.setThreadPolicy(policy); 
	        URL url = new URL("http://directory.uci.edu/index.php?uid=" + inputValue + "&form_type=plaintext");
	        HttpURLConnection con = (HttpURLConnection) url
	          .openConnection();
	        
	        
	        //sheena
	        //String passedData = readStream(con.getInputStream());
	        bundle = new Bundle();
	        readStream(con.getInputStream(), bundle);
	        //Bundle bundle = new Bundle();
	        //bundle.putString("personData", passedData);
	        //Setup the Intent that will start the next Activity
	        Intent personInfoActivity = new Intent(this, PersonInfoActivity.class); 
	        //Assumes this references this instance of Activity A
	        personInfoActivity.putExtras(bundle);
	        startActivity(personInfoActivity);
	   
	        
	       
	        //readStream(con.getInputStream());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}     

	private void readStream(InputStream in, Bundle readBundle) {
	  BufferedReader reader = null;
	  String output = "";
	  String ucinetid, name, title, department, address, phone = "0", fax = "0", email;
	  //String personOutput = "";
	  //Boolean hasPhone = false, hasFax = false;
	  try {
	    reader = new BufferedReader(new InputStreamReader(in));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	      output+=line;
	    }
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
	    if (output.contains("Phone: ")){
	    	//hasPhone = true;
	    	phone = output.split("Phone: ")[1].split("<br/>")[0];
	    	readBundle.putString("phone", phone);
	    }
	    else
	    	readBundle.putString("phone", "N/A");
	    if (output.contains("Fax: ")){
	    	//hasFax = true;
	    	fax = output.split("Fax: ")[1].split("<br/>")[0];
	    	readBundle.putString("fax", fax);
	    }
	    else
	    	readBundle.putString("fax", "N/A");
	   	email = ucinetid + "@uci.edu";
	   	readBundle.putString("email", email);
/*	   	personOutput = "Name: " + name + '\n';
	   	personOutput+= "UCInetID: " + ucinetid + '\n';
	   	personOutput+= "Title: " + title + '\n';
	   	personOutput+= "E-mail: " + email + '\n';
	   	personOutput+= "Department: " + department + '\n';
	   	personOutput+= "Address: " + address + '\n';
	   	if(hasPhone){
	   		personOutput+= "Phone: " + phone + '\n';
	   	}
	   	if (hasFax){
	   		personOutput+= "Fax: " + fax + '\n';
	   	}
	   	hasPhone = false;
	   	hasFax = false;*/
	    //return personOutput;
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
	//return output;
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
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
}
