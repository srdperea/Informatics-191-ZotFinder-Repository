package com.example.test2app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

public class SearchActivity extends ListActivity {
	EditText searchBox;
	//bundle is global so that it may be accessed from outside the getData() method
	Bundle bundle;
	ListAdapter listAdapter;
	SimpleAdapter simpleAdapter;
	ListView searchResults;
	Cursor cursor;
	SQLiteDatabase buildingDb;
	SQLiteDatabase departmentDb;
	SQLiteDatabase serviceDb;
	boolean addedDatabase;
	int searchChooser; //-1=person; 0=building; 1=department ; 2=services
	String personOutput;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
		
		BuildingDatabase buildingDatabase = new BuildingDatabase(this);
		DepartmentDatabase departmentDatabase = new DepartmentDatabase(this);
		ServicesDatabase servicesDatabase = new ServicesDatabase(this);
		
		BufferedReader br = null;
		String line = "";
		InputStream buildingIS = null;
		InputStream departmentIS = null;
		InputStream servicesIS = null;
		
		SharedPreferences settings = getSharedPreferences("ZotFinder Preferences", 0);
		addedDatabase = settings.getBoolean("addedDatabase", false);
		searchChooser = settings.getInt("searchType", 0);
		if (!addedDatabase)
		{
			buildingIS = getResources().openRawResource(R.raw.building_file);
			try {
				br = new BufferedReader(new InputStreamReader(buildingIS));
				while ((line = br.readLine()) != null)
				{
					String[] buildingInfo = line.split(",");
					buildingDatabase.addToDatabase(buildingInfo);
				}
				buildingIS.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			departmentIS = getResources().openRawResource(R.raw.departments_file);
			try {
				br = new BufferedReader(new InputStreamReader(departmentIS));
				while ((line = br.readLine()) != null)
				{
					String[] departmentInfo = line.split(",");
					departmentDatabase.addToDatabase(departmentInfo);
				}
				departmentIS.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			servicesIS = getResources().openRawResource(R.raw.campus_services);
			try {
				br = new BufferedReader(new InputStreamReader(servicesIS));
				while ((line = br.readLine()) != null)
				{
					String[] servicesInfo = line.split(",");
					servicesDatabase.addToDatabase(servicesInfo);
				}
				servicesIS.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			addedDatabase = true;
		}
		

		buildingDb = buildingDatabase.getReadableDatabase();
		departmentDb = departmentDatabase.getReadableDatabase();
		serviceDb = servicesDatabase.getReadableDatabase();
		searchBox = (EditText) findViewById(R.id.searchText);
		
		searchBox.setOnEditorActionListener(new OnEditorActionListener() {

	        @Override
	        public boolean onEditorAction(TextView v, int actionId,
	                KeyEvent event) {
	            if (event != null&& (event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
	                InputMethodManager in = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
	                in.hideSoftInputFromWindow(searchBox
	                        .getApplicationWindowToken(),
	                        InputMethodManager.HIDE_NOT_ALWAYS);
	               // Must return true here to consume event
	               return true;
	            }
	            return false;
	        }
	    });
	}
	
	//return false = list of people
	//return true = one person
	public boolean personSearchResultType(String inputValue) throws InterruptedException, ExecutionException	{
		String input = inputValue;
		String url = "http://directory.uci.edu/index.php?basic_keywords=" + input + "&modifier=Exact+Match&basic_submit=Search&checkbox_employees=Employees&form_type=basic_search";
		String output = new RetreiveDirectoryResultTask().execute(url).get();
		   if (output.contains("Your search"))
			   return false;
		   else
			   return true;
	}
	
	private List<HashMap<String, String>> readSingleResultStream(String inputValue) throws InterruptedException, ExecutionException {
		List<HashMap<String, String>> personResults = new ArrayList<HashMap<String, String>>();
    	//creating an http connection to make an Http Request
    	String input = inputValue;
        String url = "http://directory.uci.edu/index.php?basic_keywords=" + input + "&modifier=Exact+Match&basic_submit=Search&checkbox_employees=Employees&form_type=basic_search";
        String output = new RetreiveDirectoryResultTask().execute(url).get();
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("rowid","1");
        output = output.replaceAll("\\r\\n\\t|\\r|\\n|\\t", "");
        String name = output.split("<span class=\"label\">Name</span><span class=\"resultData\">")[1].split("</span></p>")[0];
        map.put("name", name);
        String ucinetid = output.split("<span class=\"label\">UCInetID</span><span class=\"resultData\">")[1].split("</span></p>")[0];
        map.put("ucinetid",ucinetid);
        if (output.contains("Title </span></TD>")){
        	
            String title = output.split("<TD class=\"positioning_cell\"><span class=\"table_label\">Title</span></TD><TD><span class=\"table_data\">")[1].split("</span></TD>")[0];
            map.put("title", title);
            String department = output.split("<TD class=\"positioning_cell\"><span class=\"table_label\">Department</span></TD><TD><span class=\"table_data\">")[1].split("</span></TD>")[0];
            map.put("department", department);
            	
        }
        else{
            String department = output.split("<TD class=\"positioning_cell\"><span class=\"table_label\">Department</span></TD><TD><span class=\"table_data\">")[1].split("</span></TD>")[0];
            map.put("title", department);
        }
        if(output.contains("Address</span></TD>")){
        	String address = output.split("<TD class=\"positioning_cell\"><span class=\"table_label\">Address</span></TD><TD><span class=\"table_data\">")[1].split("</span></TD>")[0];
            map.put("address", address);	
        }
        if(output.contains("<span class=\"label\">Phone</span><span class=\"resultData\">")){
        	String phoneNumber = output.split("<span class=\"label\">Phone</span><span class=\"resultData\">")[1].split("</span></p>")[0];
        	map.put("phoneNumber",phoneNumber);
        }
        else
        	map.put("phoneNumber","N/A");
        if(output.contains("p><span class=\"label\">Fax</span><span class=\"resultData\">")){
        	String faxNumber = output.split("p><span class=\"label\">Fax</span><span class=\"resultData\">")[1].split("</span></p>")[0];
        	map.put("faxNumber",faxNumber);
        }
        else
        	map.put("faxNumber", "N/A");
        String email = "E-mail: " + ucinetid + "@uci.edu";
        map.put("email", email);
        personResults.add(map);
        return personResults;
	}
	
	private List<HashMap<String, String>> readMultipleResultStream(String inputValue) throws InterruptedException, ExecutionException {
		List<HashMap<String, String>> personResults = new ArrayList<HashMap<String, String>>();
    	//creating an http connection to make an Http Request
    	String input = inputValue;
        String url = "http://directory.uci.edu/index.php?basic_keywords=" + input + "&modifier=Exact+Match&basic_submit=Search&checkbox_employees=Employees&form_type=basic_search";
        String output = new RetreiveDirectoryResultTask().execute(url).get();
        
        String[] ucinetidSplit = output.split("uid=");
        String[] nameSplit = output.split("&return=basic_keywords%3D" + input + "%26modifier%3DExact%2BMatch%26basic_submit%3DSearch%26checkbox_employees%3DEmployees%26form_type%3Dbasic_search'>");
        String[] titleSplit = output.split("<span class=\"departmentmajor\">"); 
        int j = 1;
        for(int i = 1; i < nameSplit.length; i++){
        	HashMap<String, String> map = new HashMap<String, String>();
        	map.put("personid", "" +i);
        	map.put("ucinetid", ucinetidSplit[i].split("&")[0]);
        	map.put("name", nameSplit[i].split("</a>")[0]);
        	if(titleSplit[j].split("</span>")[0].contains("<br />"))
        		map.put("title",titleSplit[j].split("</span>")[0].split("<br />")[0]);
        	else
        		map.put("title",titleSplit[j].split("</span>")[0]);
        	j += 2;
        	personResults.add(map);
		}
        return personResults;
	}
					   
	
	public void choosePersonSearch(View view){
		searchChooser = -1;
	}
	public void chooseBuildingSearch(View view){
		searchChooser = 0;
	}
	public void chooseDepartmentSearch(View view){
		searchChooser = 1;
	}
	public void chooseServicesSearch(View view){
		searchChooser = 2;
	}
	@SuppressWarnings("deprecation")
	public void search(View view) throws InterruptedException, ExecutionException{
		if (searchChooser == 0){
			cursor = buildingDb.rawQuery("SELECT _id, buildingName, buildingNumber, buildingAddress, buildingAbbreviation FROM building WHERE buildingName || ' ' || buildingAbbreviation || ' ' || buildingNumber LIKE ?" , 
					new String[]{"%" + searchBox.getText().toString() + "%"});
			listAdapter = new SimpleCursorAdapter(
					this, 
					R.layout.activity_building_list_item, 
					cursor, 
					new String[] {"buildingName", "buildingNumber", "buildingAddress"}, 
					new int[] {R.id.buildingName,R.id.buildingNumber, R.id.buildingAddress});
			setListAdapter(listAdapter);
		}	else if (searchChooser == 1){
			cursor = departmentDb.rawQuery("SELECT _id, departmentName, departmentAddress FROM department WHERE departmentName || ' ' || departmentAddress LIKE ?", 
					new String[]{"%" + searchBox.getText().toString() + "%"});
			listAdapter = new SimpleCursorAdapter(
					this, 
					R.layout.activity_department_list_item, 
					cursor, 
					new String[] {"departmentName", "departmentAddress"}, 
					new int[] {R.id.departmentName, R.id.departmentAddress});
			setListAdapter(listAdapter);
		
		} else if (searchChooser == -1){
			String searchInput = searchBox.getText().toString();
			searchInput = searchInput.toLowerCase();
			searchInput = searchInput.trim();
	    	if(searchInput.contains(" ")){
	    		searchInput = searchInput.replaceAll(" ", "+");
			}
			if(searchInput.matches("^[a-zA-Z]+"))
			{
				
				boolean resultType = personSearchResultType(searchInput);
				List<HashMap<String, String>> personResults;
				
				if(resultType)
					personResults = readSingleResultStream(searchInput);		
				else
					personResults = readMultipleResultStream(searchInput);
				
				String[] from = new String[] {"name", "title"};
			    int[] to = new int[] {R.id.personName, R.id.personTitle};
				simpleAdapter = new SimpleAdapter(this,personResults, R.layout.activity_person_list_item,from,to);
				setListAdapter(simpleAdapter);
			}
		}
		else if (searchChooser == 2){
			cursor = serviceDb.rawQuery("SELECT _id, serviceName, serviceAddress FROM service WHERE serviceName || ' ' || serviceAddress LIKE ?", 
					new String[]{"%" + searchBox.getText().toString() + "%"});
			listAdapter = new SimpleCursorAdapter(
					this, 
					R.layout.activity_services_list_item, 
					cursor, 
					new String[] {"serviceName", "serviceAddress"}, 
					new int[] {R.id.serviceName, R.id.serviceAddress});
			setListAdapter(listAdapter);
		}
	}
	
	
	
    public void onListItemClick(ListView parent, View view, int position, long id){
    	Bundle bundle = new Bundle();
    	if (searchChooser == 0)
    	{
	    	Intent intent = new Intent(this, BuildingInfoActivity.class);
	    	Cursor cursor = (Cursor) listAdapter.getItem(position);
	    	bundle.putInt("BUILDING_ID", cursor.getInt(cursor.getColumnIndex("_id")));
	    	intent.putExtras(bundle);
	    	startActivity(intent);
    	}
    	else if (searchChooser == 1)
    	{
	    	Intent intent = new Intent(this, DepartmentInfoActivity.class);
	    	Cursor cursor = (Cursor) listAdapter.getItem(position);
	    	bundle.putInt("DEPARTMENT_ID", cursor.getInt(cursor.getColumnIndex("_id")));
	    	intent.putExtras(bundle);
	    	startActivity(intent);
    	}
    	else if (searchChooser == -1)
    	{
	    	Intent intent = new Intent(this, PersonInfoActivity.class);
	    	HashMap<String, String> personResults = null;
	    	HashMap<String, String> listResults = null;
	    	try {
	    		listResults = (HashMap<String, String>) simpleAdapter.getItem(position);
				personResults = readSingleResultStream(listResults.get("ucinetid")).get(0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
	    	//bundle.putSerializable("person", personResults);
	    	intent.putExtra("person",personResults);
	    	startActivity(intent);
    	}
    	else if (searchChooser == 2){
    		Intent intent = new Intent(this, ServicesInfoActivity.class);
	    	Cursor cursor = (Cursor) listAdapter.getItem(position);
	    	bundle.putInt("SERVICE_ID", cursor.getInt(cursor.getColumnIndex("_id")));
	    	intent.putExtras(bundle);
	    	startActivity(intent);
    	}
    }
    
	private class RetreiveDirectoryResultTask extends AsyncTask<String, Integer,String> {

		@Override
		protected String doInBackground(String... urls) {
			String output = "";
			HttpGet httpGet = null;
			DefaultHttpClient httpClient = null;
			try{
				httpClient = new DefaultHttpClient();
				URI url = new URI(urls[0]);
				httpGet = new HttpGet(url);
				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
			    output = EntityUtils.toString(httpEntity);
			    
		   		output = output.replaceAll("\\r\\n\\t|\\r|\\n|\\t", "");
			
				} catch (Exception e) {
					Log.d("Exception while downloading url", e.toString());
			 	}
			return output;
		}
	}
	
  //Back button
  	public void finishActivity(View v){
  	    finish();
  	    }
    
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
	 
	//menu functionality when the user press the physical menu button located on the phone
	//currently the menu feature does nothing
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.search, menu);
		return true;
	}
	
	@Override
	protected void onStop() {
		SharedPreferences settings = getSharedPreferences("ZotFinder Preferences", 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putBoolean("addedDatabase", addedDatabase);
	    editor.putInt("searchType", searchChooser);
	    editor.commit();
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		SharedPreferences settings = getSharedPreferences("ZotFinder Preferences", 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putBoolean("addedDatabase", addedDatabase);
	    editor.putInt("searchType", searchChooser);
	    editor.commit();
		super.onDestroy();
	}
	
	@Override
	protected void onPause() {
		SharedPreferences settings = getSharedPreferences("ZotFinder Preferences", 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putBoolean("addedDatabase", addedDatabase);
	    editor.putInt("searchType", searchChooser);
	    editor.commit();
		super.onPause();
	}
}
