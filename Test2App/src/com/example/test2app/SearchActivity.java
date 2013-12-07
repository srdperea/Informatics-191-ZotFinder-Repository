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
import android.widget.EditText;
import android.widget.TextView;

public class SearchActivity extends Activity {
EditText inputBox;
	
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
	        TextView httptextview = (TextView)findViewById(R.id.httpTextView);
	        httptextview.setText(readStream(con.getInputStream()));
	        //readStream(con.getInputStream());
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}     

	private String readStream(InputStream in) {
	  BufferedReader reader = null;
	  String output = "";
	  String ucinetid, name, title, department, address, phone, fax, email;
	  String personOutput = "";
	  try {
	    reader = new BufferedReader(new InputStreamReader(in));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	      output+=line;
	    }
	    ucinetid = output.split("UCInetID: ")[1].split("<br/>")[0];
	    name = output.split("Name: ")[1].split("<br/>")[0];
	    title = output.split("Title: ")[1].split("<br/>")[0];
	    department = output.split("Department: ")[1].split("<br/>")[0];
	    address = output.split("Address: ")[1].split("<br/>")[0];
	    phone = output.split("Phone: ")[1].split("<br/>")[0];
	    fax = output.split("Fax: ")[1].split("<br/>")[0];
	   	email = ucinetid + "@uci.edu";
	   	personOutput = "Name: " + name + '\n';
	   	personOutput+= "UCInetID: " + ucinetid + '\n';
	   	personOutput+= "Title: " + title + '\n';
	   	personOutput+= "E-mail: " + email + '\n';
	   	personOutput+= "Department: " + department + '\n';
	   	personOutput+= "Address: " + address + '\n';
	   	personOutput+= "Phone#: " + phone + '\n';
	   	personOutput+= "Fax: " + fax + '\n';
	   	
	    return personOutput;
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
	return output;
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
