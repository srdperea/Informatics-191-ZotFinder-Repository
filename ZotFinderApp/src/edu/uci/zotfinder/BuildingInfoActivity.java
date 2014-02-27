package edu.uci.zotfinder;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.concurrent.ExecutionException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.util.EntityUtils;

import com.example.test2app.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class BuildingInfoActivity extends Activity {

	protected TextView buildingName;
	protected TextView buildingAddress;
	protected TextView buildingNumber;
	protected ImageView buildingImage;
	protected String buildingNameString;
	protected String buildingAddressString;
	protected String buildingNumberString;
    protected int buildingId;
    protected float buildingLongitude;
    protected float buildingLatitude;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_building_info);
		
		buildingId = getIntent().getExtras().getInt("BUILDING_ID");
        SQLiteDatabase db = (new BuildingDatabase(this)).getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT _id, buildingName, buildingNumber, buildingAddress, buildingLongitude, buildingLatitude FROM building WHERE _id=?",
        		new String[]{""+buildingId});
        
        if (cursor.getCount() == 1)
        {
        	cursor.moveToFirst();
        
        	buildingName = (TextView) findViewById(R.id.buildingName);
        	buildingNameString = cursor.getString(cursor.getColumnIndex("buildingName"));
        	buildingName.setText(buildingNameString);
        	
	
	        buildingAddress = (TextView) findViewById(R.id.buildingAddress);
	        buildingAddressString = cursor.getString(cursor.getColumnIndex("buildingAddress"));
	        buildingAddress.setText(buildingAddressString);
	        

	        buildingNumber = (TextView) findViewById(R.id.buildingNumber);
	        buildingNumberString = cursor.getString(cursor.getColumnIndex("buildingNumber"));
	        buildingNumber.setText(buildingNumberString);
	        
	        buildingLongitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("buildingLongitude")));
	        
	        buildingLatitude = Float.valueOf(cursor.getString(cursor.getColumnIndex("buildingLatitude")));
	        
	        buildingImage = (ImageView) findViewById(R.id.building_image);
	        String imageUrl = "https://eee.uci.edu/images/buildings/" + buildingNumberString + ".jpg";
	        Bitmap img = null;
			try {
				img = new RetreiveDirectoryResultTask().execute(imageUrl).get();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
			
			if(img!=null)
				buildingImage.setImageBitmap(img);
        }
	}
	
	public void plotPoint(View view)
	{
		Intent intent = new Intent(this,MainActivity.class);
		Bundle bundle = new Bundle();
		bundle.putInt("type", 1);
		bundle.putInt("BUILDING_ID", buildingId);
		bundle.putString("buildingName", buildingNameString);
		bundle.putString("buildingAddress", buildingAddressString);
		bundle.putString("buildingNumber", buildingNumberString);
		bundle.putFloat("buildingLongitude", buildingLongitude);
		bundle.putFloat("buildingLatitude", buildingLatitude);
		intent.putExtras(bundle);
		startActivity(intent);
	}
	

	private class RetreiveDirectoryResultTask extends AsyncTask<String, Integer,Bitmap> {

		@Override
		protected Bitmap doInBackground(String... urls) {
			Bitmap img = null;
			InputStream is = null;
			HttpGet httpGet = null;
			DefaultHttpClient httpClient = null;
			HttpParams httpParameters = new BasicHttpParams();
			int timeoutConnection = 3000;
			int timeoutSocket = 5000;
			HttpConnectionParams.setConnectionTimeout(httpParameters, timeoutConnection);
			HttpConnectionParams.setSoTimeout(httpParameters, timeoutSocket);
			try{
				httpClient = new DefaultHttpClient(httpParameters);
				URI url = new URI(urls[0]);
				httpGet = new HttpGet(url);
				HttpResponse httpResponse = httpClient.execute(httpGet);
				HttpEntity httpEntity = httpResponse.getEntity();
			    is = httpEntity.getContent();
			    img = BitmapFactory.decodeStream(is);
			} catch (Exception e) {
					Log.d("Exception while downloading url", e.toString());
			 	}
			return img;
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
		//currently the menu feature does nothing	@Override
		public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.person_info, menu);
			return true;
		}

	}
